package vn.com.doctorcare.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import vn.com.doctorcare.entity.LockedAccount;

public interface LockedAccountRepository extends JpaRepository<LockedAccount, Integer> {
	
	@Query(value = "SELECT l.id FROM locked_account l WHERE l.user_id = ?1", nativeQuery = true)
	public Optional<Integer> findByUserId(int userId);

}
