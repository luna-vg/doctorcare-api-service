package vn.com.doctorcare.service;

import vn.com.doctorcare.entity.LockedAccount;

public interface LockedAccountService {

	void lockAccount(LockedAccount account);

	void unlockAccount(int lockedAccountId);

	int findIdByUserId(int userId);

}
