package com.perfios.controller;

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
import com.perfios.dto.StationRegistrationDto;
import com.perfios.model.Car;
import com.perfios.model.CarRent;
import com.perfios.model.Station;
import com.perfios.model.User;
import com.perfios.repository.StationRepo;
import com.perfios.repository.UserRepository;
import com.perfios.service.StationService;
import com.perfios.service.UserService;

@Controller
public class MainController {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private StationRepo stationRepository;
	@Autowired 
	private UserService userService;
	@Autowired
	private StationService stationService;
	
	 public User loginDetails() {
		 AbstractAuthenticationToken auth = (AbstractAuthenticationToken)
					SecurityContextHolder.getContext().getAuthentication();
					User user=userRepository.findByEmail(auth.getName());
					return user;
	 }
	 
	 
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	 @GetMapping("/")
	    public String home(Model model){
//		 User user =  LoginDetails();
		 model.addAttribute("user",loginDetails());
	        return "index";
	    }
	 
	 @GetMapping("/addStation")
		public String carRentalDetails(Model model)
		{
		    Station station = new Station();
		    model.addAttribute("stationDetail",station);
			return "StationRegister";
		}
	 
	 @PostMapping("/addStation")
		public String registerCar(@ModelAttribute("stationDetail") StationRegistrationDto registrationDto){
		 Station s = stationRepository.findByName(registrationDto.getName());
		 if(s==null) {
		 stationService.Save(registrationDto);
		 return "StationRegisterSuccess";
		 }
		 else {
			 return "redirect:/addStation";
		 }
		}
}