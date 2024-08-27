package vn.com.doctorcare.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.doctorcare.dao.LockedAccountRepository;
import vn.com.doctorcare.dao.UserRepository;
import vn.com.doctorcare.entity.LockedAccount;
import vn.com.doctorcare.error.UserNotFoundException;

@Service
public class LockedAccountServiceImpl implements LockedAccountService {
	
	@Autowired
	private LockedAccountRepository lockedAccountRepository;
	
	@Override
	public int findIdByUserId(int userId) {
		
		Optional<Integer> result = lockedAccountRepository.findByUserId(userId);
		
		if (result.isPresent()) {
			return result.get();
		} else {
			throw new UserNotFoundException("User id - " + userId + " not found");
		}
		
	}
	
	@Override
	public void lockAccount(LockedAccount account) {
		
		lockedAccountRepository.save(account);
		
	}
	
	@Override
	public void unlockAccount(int lockedAccountId) {
		
		lockedAccountRepository.deleteById(lockedAccountId);
				
	}

}
