package vn.com.doctorcare.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vn.com.doctorcare.entity.Appointment;
import vn.com.doctorcare.entity.Clinic;
import vn.com.doctorcare.entity.ClinicSpecialization;
import vn.com.doctorcare.entity.Doctor;
import vn.com.doctorcare.entity.Patient;
import vn.com.doctorcare.entity.Specialization;
import vn.com.doctorcare.entity.User;
import vn.com.doctorcare.error.EmailExistedException;
import vn.com.doctorcare.service.AppointmentService;
import vn.com.doctorcare.service.ClinicService;
import vn.com.doctorcare.service.ClinicSpecializationService;
import vn.com.doctorcare.service.DoctorService;
import vn.com.doctorcare.service.EmailService;
import vn.com.doctorcare.service.PatientService;
import vn.com.doctorcare.service.SpecializationService;
import vn.com.doctorcare.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private AppointmentService appointmentService;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private ClinicService clinicService;
	
	@Autowired
	private SpecializationService specializationService;
	
	@Autowired
	private PatientService patientService;
	
	@Autowired
	private DoctorService doctorService;
	
	@Autowired
	private ClinicSpecializationService clinicSpecializationService;
	
	@Autowired
	private UserService userService;
	
	// yeu cau 5.1.2
	@PostMapping("/register")
	public String registerUser(@RequestBody User user) {
		
		if (userService.emailExisted(user.getEmail())) {
			throw new EmailExistedException("Email " + user.getEmail() + " already registered");
		}
		
		user.setEnabled(1);
		
		user.setRoleId(4);
		
		userService.saveUser(user);
		
		Patient patient = new Patient();
		
		patient.setUser(user);
		
		patientService.savePatient(patient);
		
		return "Successfully registered!";
		
	}
	
	// yeu cau 5.1.3
	@GetMapping("/forgotPassword/{userId}")
	public String forgotPassword(@PathVariable int userId) {
		
		User user = userService.findById(userId);
		
		emailService.sendSimpleEmail(user.getEmail());
		
		return "A password-reset link was just sent to your registered email!";
		
	}
	
	@PutMapping("/reset-password/{userId}")
	public String resetPassword(@RequestBody String password, @PathVariable int userId) {
		
		User user = userService.findById(userId);
		
		user.setPassword(password);
		
		userService.saveUser(user);
		
		return "Successfully reset the password!";
		
	}
	
	// yeu cau 5.1.4
	@GetMapping("/popularSpecialization/{clinicId}")
	public Specialization getPopularSpecialization(@PathVariable int clinicId) {
		
		int specializationId = appointmentService.getMostCommonSpecialization(clinicId);
		
		return specializationService.findById(specializationId);
		
	}
	
	// yeu cau 5.1.5
	@GetMapping("/popularClinics")
	public List<Clinic> getPopularClinics() {
		
		List<Integer> clinics = appointmentService.getMostCommonClinics();
		
		List<Clinic> mostPopularClinics = new ArrayList<>();
		
		for (int i : clinics) {
			mostPopularClinics.add(clinicService.findById(i));	
		}
		
		return mostPopularClinics;
		
	}
	
	// yeu cau 5.1.6
	@GetMapping("/information/{patientId}")
	public Patient getInformation(@PathVariable int patientId) {
		
		return patientService.findById(patientId);
		
	}
	
	// yeu cau 5.1.7
	@GetMapping("/searchGeneral")
	public List<ClinicSpecialization> searchGeneral(@RequestParam String keyword) {
		
		return clinicSpecializationService.searchGeneral(keyword);
		
	}
	
	// yeu cau 5.1.8
	@GetMapping("/searchDoctors")
	public List<Doctor> searchDoctors(@RequestParam String keyword) {
		
		return doctorService.searchDoctors(keyword);
		
	}
	
	// yeu cau 5.1.9
	@PostMapping("/createAppointment")
	public String createAppointment(@RequestBody Appointment appointment) {
				
		appointment.setId(0);
		
		appointment.setStatus(1);
		
		appointment.setConfirmed(0);
		
		appointmentService.saveAppointment(appointment);
		
		return "Successfully created the appointment!";
		
	}
	
}
