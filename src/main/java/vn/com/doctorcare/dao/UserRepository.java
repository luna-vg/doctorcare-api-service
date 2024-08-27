package vn.com.doctorcare.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import vn.com.doctorcare.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	@Query(value = "SELECT email FROM users", nativeQuery = true)
	List<String> findAllEmails();

}
