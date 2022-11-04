package com.perfios.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.perfios.dto.CarRegistrationDto;
import com.perfios.model.Car;
import com.perfios.model.User;
import com.perfios.repository.CarRepo;
import com.perfios.repository.UserRepository;
import com.perfios.service.CarService;
import com.perfios.service.StationService;
import com.perfios.service.UserService;


@Controller
public class CarRegistrationController {

	@Autowired
	CarRepo carrepo;
	@Autowired
	private CarService carservice;
	@Autowired
	private StationService stationservice;
	@Autowired
	private UserRepository userRepository;
	@Autowired 
	private UserService userService;
	 
	public User loginDetails() {
		 AbstractAuthenticationToken auth = (AbstractAuthenticationToken)
					SecurityContextHolder.getContext().getAuthentication();
					User user=userRepository.findByEmail(auth.getName());
					return user;
	 }
	
	@GetMapping("/carRegister")
	public String addCarDetails( Model model) {
		Car car = new Car();
		model.addAttribute("car",car);
		model.addAttribute("stations", stationservice.findAll());
		return "carRegister";
	}
	
	@PostMapping("/carRegister")
	public String registerCar(@ModelAttribute("car") CarRegistrationDto registrationDto){
		User user =  loginDetails();
		Long id = user.getId();
		String s1 = registrationDto.getModelName();
		String s2 = registrationDto.getNumberPlate();
		Car c = carrepo.findByModelNameAndNumberPlate(s1,s2);
		if(c==null) {
			registrationDto.setOwner(id);
		carservice.save(registrationDto);
		return "successfulCarRegistration";
		}
		else {
			return "alreadyRegistered";
		}
	}
	
}
