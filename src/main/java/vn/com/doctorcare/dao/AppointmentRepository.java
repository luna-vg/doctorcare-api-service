package vn.com.doctorcare.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import vn.com.doctorcare.entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer>{

	// lay ra specialization noi bat nhat dua tren so luot kham duoc dat
	@Query(value = "SELECT b.specialization_id FROM (SELECT d.specialization_id FROM appointments a JOIN doctors d ON a.doctor_id = d.id AND d.clinic_id = ?1) b GROUP BY b.specialization_id ORDER BY COUNT(*) DESC LIMIT 1", nativeQuery = true)
	public int findMostCommonSpecialization(int clinicId);
	
	// lay ra clinic noi bat nhat dua tren so luot kham duoc dat
	@Query(value = "SELECT d.clinic_id FROM appointments a JOIN doctors d ON a.doctor_id = d.id GROUP BY d.clinic_id ORDER BY COUNT(*) DESC LIMIT 3", nativeQuery = true)
	public List<Integer> findMostCommonClinics();
	
}
