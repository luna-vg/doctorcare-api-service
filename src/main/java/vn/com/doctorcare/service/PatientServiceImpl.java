package vn.com.doctorcare.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.doctorcare.dao.PatientRepository;
import vn.com.doctorcare.entity.Patient;
import vn.com.doctorcare.entity.Specialization;
import vn.com.doctorcare.error.PatientNotFoundException;

@Service
public class PatientServiceImpl implements PatientService {
	
	@Autowired
	private PatientRepository patientRepository;
	
	@Override
	public Patient findById(int id) {
		Optional<Patient> result = patientRepository.findById(id);
		
		Patient thePatient = null;
		
		if (result.isPresent()) {
			thePatient = result.get();
		}
		else {
			// we didn't find the patient
			throw new PatientNotFoundException("Patient id - " + id + " not found");
		}
		
		return thePatient;

	}
	
	@Override
	public void savePatient(Patient patient) {
		patientRepository.save(patient);
	}

}
