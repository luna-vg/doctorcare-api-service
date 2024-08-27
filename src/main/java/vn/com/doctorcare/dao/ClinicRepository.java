package vn.com.doctorcare.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.com.doctorcare.entity.Clinic;

public interface ClinicRepository extends JpaRepository<Clinic, Integer> {

}
