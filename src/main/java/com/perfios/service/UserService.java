package com.perfios.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.perfios.dto.UserRegistrationDto;
import com.perfios.model.User;


public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto registrationDto);
    User getUserById(long id);
    void saveUser(User user);
}