package vn.com.doctorcare.service;

import java.util.List;

import vn.com.doctorcare.entity.User;

public interface UserService {

	void saveUser(User user);

	User findById(int userId);

	List<String> getAllEmails();

	boolean emailExisted(String theEmail);

}
