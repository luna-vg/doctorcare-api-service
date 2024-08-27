package vn.com.doctorcare.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.doctorcare.dao.DoctorRepository;
import vn.com.doctorcare.dao.PatientRepository;
import vn.com.doctorcare.entity.Doctor;
import vn.com.doctorcare.entity.Patient;
import vn.com.doctorcare.error.DoctorNotFoundException;

@Service
public class DoctorServiceImpl implements DoctorService {
	
	@Autowired
	private DoctorRepository doctorRepository;
	
	@Autowired
	private PatientService patientService;
		
	@Override
	public Doctor findById(int doctorId) {
		
		Optional<Doctor> result = doctorRepository.findById(doctorId);
		
		Doctor doctor = null;
		
		if (result.isPresent()) {
			doctor = result.get();
		} else {
			throw new RuntimeException("Doctor id - " + doctorId + " not found");
		}
		
		return doctor;
	}
	
	@Override
	public List<Doctor> searchDoctors(String keyword) {
		
		List<Integer> doctors = doctorRepository.searchDoctors(keyword);
		
		List<Doctor> theDoctors = new ArrayList<>();
		
		for (int i : doctors) {
			theDoctors.add(findById(i));
		}
		
		return theDoctors;
		
	}

	@Override
	public void saveDoctor(Doctor doctor) {
		
		doctorRepository.save(doctor);
		
	}

	@Override
	public List<Patient> getPatients(int doctorId) {
		
		try {
		
		List<Integer> patientIds = doctorRepository.getPatients(doctorId);
		
		List<Patient> patients = new ArrayList<>();
		
		for (int i : patientIds) {
			patients.add(patientService.findById(i));
		}
		
		return patients;
		
		} catch (Exception e) {
			throw new DoctorNotFoundException("Doctor id - " + doctorId + " not found");
		}
		
	}

}
