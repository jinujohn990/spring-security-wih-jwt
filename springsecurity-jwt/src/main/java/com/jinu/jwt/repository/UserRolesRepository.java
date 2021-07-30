package com.jinu.jwt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jinu.jwt.model.User;
import com.jinu.jwt.model.UserRoles;
@Repository
public interface UserRolesRepository extends JpaRepository<UserRoles, String> {
	
	//@Query("SELECT u FROM UserRoles u WHERE u.user = :userId")
    public List<UserRoles> getUserRolesByUser(@Param("user") User user);
}
