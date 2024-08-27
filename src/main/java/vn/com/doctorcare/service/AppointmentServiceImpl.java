package vn.com.doctorcare.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.doctorcare.dao.AppointmentRepository;
import vn.com.doctorcare.entity.Appointment;
import vn.com.doctorcare.error.AppointmentNotFoundException;
import vn.com.doctorcare.error.ClinicNotFoundException;

@Service
public class AppointmentServiceImpl implements AppointmentService {
	
	@Autowired
	private AppointmentRepository appointmentRepository;
	
	@Override
	public Appointment findById(int appointmentId) {
		
		Optional<Appointment> result = appointmentRepository.findById(appointmentId);
		
		Appointment theAppointment = null;
		
		if (result.isPresent()) {
			theAppointment = result.get();
		} else {
			throw new AppointmentNotFoundException("Appointment id - " + appointmentId + " not found");
		}
		
		return theAppointment;
		
	}
	
	@Override
	public void saveAppointment(Appointment theAppointment) {
		appointmentRepository.save(theAppointment);
	}
	
	@Override
	public int getMostCommonSpecialization(int clinicId) {
		
		return appointmentRepository.findMostCommonSpecialization(clinicId);

	}
	
	@Override
	public List<Integer> getMostCommonClinics() {
		return appointmentRepository.findMostCommonClinics();
	}
	
	@Override
	public void confirmAppointment(int appointmentId) {
		
		Appointment appointment = findById(appointmentId);
		
		appointment.setConfirmed(1);
		
		appointment.setRejectText(null);
		
		saveAppointment(appointment);
		
	}
	
	@Override
	public void rejectAppointment(int appointmentId, String rejectText) {
		
		Appointment appointment = findById(appointmentId);
		
		appointment.setConfirmed(2);
		
		appointment.setRejectText(rejectText);
		
		saveAppointment(appointment);

	}
	
}
