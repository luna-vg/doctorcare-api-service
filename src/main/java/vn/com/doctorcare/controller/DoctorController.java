package vn.com.doctorcare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.com.doctorcare.entity.Doctor;
import vn.com.doctorcare.entity.Patient;
import vn.com.doctorcare.service.AppointmentService;
import vn.com.doctorcare.service.DoctorService;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
	
	@Autowired
	private DoctorService doctorService;
	
	@Autowired
	private AppointmentService appointmentService;
	
	// yeu cau 5.2.2
	@GetMapping("/{doctorId}/getPatients")
	public List<Patient> getPatients(@PathVariable int doctorId) {
				
		return doctorService.getPatients(doctorId);
		
	}
	
	// yeu cau 5.2.3a
	@PutMapping("/confirmAppointment/{appointmentId}")
	public String confirmAppointment(@PathVariable int appointmentId) {
		
		appointmentService.confirmAppointment(appointmentId);
		
		return "Successfully confirmed the appointment!";
		
	}
	
	// yeu cau 5.2.3b
	@PutMapping("/rejectAppointment/{appointmentId}")
	public String rejectAppointment(@PathVariable int appointmentId, @RequestBody String rejectText) {
		
		appointmentService.rejectAppointment(appointmentId, rejectText);
		
		return "Successfully rejected the appointment!";
		
	}

}
