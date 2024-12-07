package com.klu.jfsd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klu.jfsd.model.UserDtls;

public interface UserRepository extends JpaRepository<UserDtls, Integer> {

	public UserDtls findByEmail(String email);

	public List<UserDtls> findByRole(String role);

	public UserDtls findByResetToken(String token);

	public Boolean existsByEmail(String email);
}
