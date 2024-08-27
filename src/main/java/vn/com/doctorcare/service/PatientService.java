package vn.com.doctorcare.service;

import vn.com.doctorcare.entity.Patient;

public interface PatientService {

	Patient findById(int id);

	void savePatient(Patient patient);

}
