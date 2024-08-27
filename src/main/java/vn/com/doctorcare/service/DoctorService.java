package vn.com.doctorcare.service;

import java.util.List;

import vn.com.doctorcare.entity.Doctor;
import vn.com.doctorcare.entity.Patient;

public interface DoctorService {

	Doctor findById(int doctorId);

	List<Doctor> searchDoctors(String keyword);

	void saveDoctor(Doctor doctor);

	List<Patient> getPatients(int doctorId);

}
