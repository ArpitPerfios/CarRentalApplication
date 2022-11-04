package com.perfios.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.perfios.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long>{
			
	User findByEmailAndPassword(String mail, String password);

	User findByEmail(String userEmail);

	Optional<User> findById(Long id);
	
}