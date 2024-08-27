package vn.com.doctorcare.service;

import java.util.List;

import vn.com.doctorcare.entity.ClinicSpecialization;

public interface ClinicSpecializationService {

	List<ClinicSpecialization> searchGeneral(String keyword);

	ClinicSpecialization findById(int clinicSpecializationId);

}
