package vn.com.doctorcare.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import vn.com.doctorcare.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
	
	// search doctor based on specialization name
	@Query(value = "SELECT d.id FROM doctors d JOIN specializations s ON d.specialization_id = s.id WHERE s.name LIKE %?1%", nativeQuery = true)
	public List<Integer> searchDoctors(String keyword);

	@Query(value = "SELECT a.patient_id FROM doctors d JOIN appointments a ON d.id = a.doctor_id WHERE a.doctor_id = ?1", nativeQuery = true)
	public List<Integer> getPatients(int doctorId);

}
