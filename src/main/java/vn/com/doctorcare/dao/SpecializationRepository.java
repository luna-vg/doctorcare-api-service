package vn.com.doctorcare.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.com.doctorcare.entity.Specialization;

public interface SpecializationRepository extends JpaRepository<Specialization, Integer> {
		
}
