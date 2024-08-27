package vn.com.doctorcare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.com.doctorcare.dao.LockedAccountRepository;
import vn.com.doctorcare.entity.Doctor;
import vn.com.doctorcare.entity.LockedAccount;
import vn.com.doctorcare.entity.User;
import vn.com.doctorcare.service.DoctorService;
import vn.com.doctorcare.service.LockedAccountService;
import vn.com.doctorcare.service.UserService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private LockedAccountService lockedAccountService;
	
	@Autowired
	private DoctorService doctorService;
	
	@Autowired
	private UserService userService;
	
	// yeu cau 5.3.2a va 5.3.5a
	@PostMapping("/lockAccount/{userId}")
	public String lockAccount(@PathVariable int userId, @RequestBody String reason) {
		
		User user = userService.findById(userId);
		
		user.setEnabled(0);
		
		userService.saveUser(user);
		
		LockedAccount account = new LockedAccount(userId, reason);
		
		lockedAccountService.lockAccount(account);
		
		return "Successfully locked account id - " + account.getId();
		
	}
	
	// yeu cau 5.3.2b va 5.3.5b
	@DeleteMapping("/unlockAccount/{userId}")
	public String unlockAccount(@PathVariable int userId) {
		
		User user = userService.findById(userId);
		
		user.setEnabled(1);
		
		userService.saveUser(user);
		
		int lockedAccountId = lockedAccountService.findIdByUserId(userId);
		
		lockedAccountService.unlockAccount(lockedAccountId);
		
		return "Successfully unlock account id - " + lockedAccountId;
		
	}
	
	// yeu cau 5.3.4
	@PostMapping("/addDoctor")
	public String addDoctor(@RequestBody Doctor doctor) {
		
		User newUser = doctor.getUser();
		
		newUser.setRoleId(3);
		
		newUser.setEnabled(1);
				
		doctorService.saveDoctor(doctor);
		
		userService.saveUser(newUser);
		
		return "Successfully added the doctor!";
		
	}

}
