package vn.com.doctorcare.error;

public class EmailExistedException extends RuntimeException {
	
	public EmailExistedException (String message) {
		super(message);
	}

}
