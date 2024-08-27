package vn.com.doctorcare.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import vn.com.doctorcare.entity.ClinicSpecialization;

public interface ClinicSpecializationRepository extends JpaRepository<ClinicSpecialization, Integer> {
	
	@Query(value = "SELECT a.id FROM clinic_specialization a JOIN clinics b ON a.clinic_id = b.id JOIN specializations c ON a.specialization_id = c.id WHERE CONCAT(b.address, ' ', c.name, ' ', a.price, ' ', b.name) LIKE %?1%", nativeQuery = true)
	public List<Integer> searchClinicSpecializations(String keyword);
	
}
