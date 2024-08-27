package vn.com.doctorcare.service;

import java.util.List;

import vn.com.doctorcare.entity.Appointment;

public interface AppointmentService {

	int getMostCommonSpecialization(int clinicId);

	List<Integer> getMostCommonClinics();

	void saveAppointment(Appointment theAppointment);

	void confirmAppointment(int appointmentId);

	Appointment findById(int appointmentId);

	void rejectAppointment(int appointmentId, String rejectText);

}
