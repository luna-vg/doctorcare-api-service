package vn.com.doctorcare.error;

public class PatientNotFoundException extends RuntimeException {

	public PatientNotFoundException(String message) {
		super(message);
	}
}
