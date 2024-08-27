package vn.com.doctorcare.error;

public class ClinicNotFoundException extends RuntimeException {
	
	public ClinicNotFoundException(String message) {
		super(message);
	}

}
