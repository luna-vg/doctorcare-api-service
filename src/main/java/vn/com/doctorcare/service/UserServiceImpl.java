package vn.com.doctorcare.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.doctorcare.dao.UserRepository;
import vn.com.doctorcare.entity.User;
import vn.com.doctorcare.error.UserNotFoundException;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void saveUser(User user) {
		
		userRepository.save(user);
		
	}
	
	@Override
	public User findById(int userId) {
		
		Optional<User> result = userRepository.findById(userId);
		
		User user = null;
		
		if (result.isPresent()) {
			user = result.get();
		} else {
			throw new UserNotFoundException("User id - " + userId + " not found");
		}
		
		return user;
	}
	
	@Override
	public List<String> getAllEmails() {
		
		return userRepository.findAllEmails();
		
	}
	
	@Override
	public boolean emailExisted(String theEmail) {
		
		for (String email : getAllEmails()) {
			if (theEmail.equals(email)) {
				return true;
			}
		}
		
		return false;
	}

}
