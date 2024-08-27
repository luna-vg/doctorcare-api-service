package vn.com.doctorcare.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.com.doctorcare.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
