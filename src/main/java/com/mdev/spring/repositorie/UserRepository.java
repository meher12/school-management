package com.mdev.spring.repositorie;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mdev.spring.entites.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	Optional<User> findByEmail(String email);

}
