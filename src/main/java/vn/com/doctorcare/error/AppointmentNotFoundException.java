package vn.com.doctorcare.error;

public class AppointmentNotFoundException extends RuntimeException {

	public AppointmentNotFoundException(String message) {
		super(message);
	}
}
