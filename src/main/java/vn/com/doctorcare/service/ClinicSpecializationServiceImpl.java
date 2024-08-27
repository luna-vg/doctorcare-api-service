package vn.com.doctorcare.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.doctorcare.dao.ClinicSpecializationRepository;
import vn.com.doctorcare.entity.ClinicSpecialization;

@Service
public class ClinicSpecializationServiceImpl implements ClinicSpecializationService {
	
	@Autowired
	private ClinicSpecializationRepository clinicSpecializationRepository;
	
	@Override
	public ClinicSpecialization findById(int clinicSpecializationId) {
		
		Optional<ClinicSpecialization> result = clinicSpecializationRepository.findById(clinicSpecializationId);
		
		ClinicSpecialization theClinicSpecialization = null;
		
		if (result.isPresent()) {
			theClinicSpecialization = result.get();
		} else {
			throw new RuntimeException("Clinic_specialization id - " + clinicSpecializationId + " not found");
		}
		
		return theClinicSpecialization;
	}
	
	@Override
	public List<ClinicSpecialization> searchGeneral(String keyword) {
		
		List<Integer> theIds = clinicSpecializationRepository.searchClinicSpecializations(keyword);
		
		List<ClinicSpecialization> results = new ArrayList<>();
		
		for (int i : theIds) {
			results.add(findById(i));
		}
		
		return results;
		
	}

}
