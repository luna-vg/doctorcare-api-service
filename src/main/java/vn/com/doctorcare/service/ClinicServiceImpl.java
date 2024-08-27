package vn.com.doctorcare.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.doctorcare.dao.ClinicRepository;
import vn.com.doctorcare.dao.ClinicSpecializationRepository;
import vn.com.doctorcare.entity.Clinic;
import vn.com.doctorcare.error.ClinicNotFoundException;

@Service
public class ClinicServiceImpl implements ClinicService {
	
	@Autowired
	private ClinicRepository clinicRepository;
	
	@Autowired
	private ClinicSpecializationRepository clinicSpecializationRepository;
	
	@Override
	public Clinic findById(int id) {
		Optional<Clinic> result = clinicRepository.findById(id);
		
		Clinic theClinic = null;
		
		if (result.isPresent()) {
			theClinic = result.get();
		}
		else {
			// we didn't find the clinic
			throw new ClinicNotFoundException("Clinic id - " + id + " not found");
		}
		
		return theClinic;

	}
	
}
