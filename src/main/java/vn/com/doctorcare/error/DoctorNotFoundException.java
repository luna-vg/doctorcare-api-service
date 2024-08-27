package vn.com.doctorcare.error;

public class DoctorNotFoundException extends RuntimeException {

	public DoctorNotFoundException (String message) {
		super(message);
	}
}
