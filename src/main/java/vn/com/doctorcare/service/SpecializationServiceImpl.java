package vn.com.doctorcare.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.doctorcare.dao.SpecializationRepository;
import vn.com.doctorcare.entity.Specialization;

@Service
public class SpecializationServiceImpl implements SpecializationService {
	
	@Autowired
	private SpecializationRepository specializationRepository;

	@Override
	public Specialization findById(int id) {
		Optional<Specialization> result = specializationRepository.findById(id);
		
		Specialization theSpecialization = null;
		
		if (result.isPresent()) {
			theSpecialization = result.get();
		}
		else {
			// we didn't find the specialization
			throw new RuntimeException("Specialization id - " + id + " not found");
		}
		
		return theSpecialization;

	}
	
}
