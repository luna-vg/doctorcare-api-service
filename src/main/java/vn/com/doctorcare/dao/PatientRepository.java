package vn.com.doctorcare.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.com.doctorcare.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

}
