package com.perfios.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.perfios.dto.CarRentalDto;
import com.perfios.model.Car;
import com.perfios.model.CarRent;
import com.perfios.model.Station;
import com.perfios.model.User;
import com.perfios.repository.CarRentRepo;
import com.perfios.repository.CarRepo;
import com.perfios.repository.StationRepo;
import com.perfios.repository.UserRepository;
import com.perfios.service.CarRentService;
import com.perfios.service.CarServiceImpl;
import com.perfios.service.StationService;
import com.perfios.service.UserService;


@Controller
public class CarRentalController {
	

	@Autowired
	private CarRentRepo carrentrepo;
	@Autowired
	private CarRepo carrepo;
	
	@Autowired
	private CarRentService carrentserv;

	@Autowired
	private StationService stationservice;

	@Autowired
	private StationRepo sr;
	
	@Autowired
	private CarServiceImpl carservice;
	
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
	
	@GetMapping("/carRental")
	public String carRentalDetails(Model model)
	{
		User user =  loginDetails();
		CarRent c = new CarRent();
		model.addAttribute("carrent",c);
		System.out.println(stationservice.findAll());
		model.addAttribute("stations", stationservice.findAll());
		model.addAttribute("cars",carservice.findAllCars());
		model.addAttribute("carrents",carrentrepo.findByDriver(user));
		return "carRental";
	}
	
	@GetMapping("/carRental1")
	public String carRentalDetails1(Model model)
	{
		model.addAttribute("cars",carservice.findAllCars());
		return "carRental1";
	}	

	@PostMapping("/carRental")
	public String saveRentalCarDetails(@ModelAttribute("carrent") CarRentalDto registrationDto,Model model) throws ParseException {
		User user =  loginDetails();
		String station=registrationDto.getBookStation();
		Station s=sr.findByName(station);
		
		//checking for carrent size to see any ride is already booked or not
		String useremail = user.getEmail();
		String mail = registrationDto.getDriver();
		List<CarRent> cr =  carrentrepo.findByDriver(user);
		int size=cr.size();
		
		//check for dates
		String date1 = registrationDto.getRentalDate();
		Date d1 = new SimpleDateFormat("yyyy-MM-dd").parse(date1);
		String date2 = registrationDto.getReturnDate();
		Date d2 = new SimpleDateFormat("yyyy-MM-dd").parse(date2);
		LocalDate dt1 = LocalDate.parse("2022-11-04");
	    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
		LocalDate now = LocalDate.now(); 
		Date d3 =new SimpleDateFormat("yyyy-MM-dd").parse(dtf.format(now));
		
		
		//check for kilometer value negative or not
		int km = registrationDto.getKm();
		
		if(size>0)
		{
			return "redirect:/carRental?already";
		}
		else if(d2.before(d1)) {
			return "redirect:/carRental?pleaseEnterCorrectDate";
		}
		else if(d1.before(d3)) {
			return "redirect:/carRental?pleaseEnterCorrectDate";
		}
		else if(km<=0) {
			return "redirect:/carRental?pleaseEnterCorrectKM";
		}
//		else if(useremail.equalsIgnoreCase(mail)) {
//			registrationDto.setDriver(useremail);
//		carrentserv.save(registrationDto);
//		String status="notBooked";
//		model.addAttribute("cars",carrepo.findByStationAndStatus(s,status));
//		return "carRental1";
//		}
		else {
			registrationDto.setDriver(useremail);
			carrentserv.save(registrationDto);
			String status="notBooked";
			model.addAttribute("cars",carrepo.findByStationAndStatus(s,status));
			return "carRental1";
		}
	}
	
	
	@GetMapping("/showFormForUpdate/{id}")
	public String fetchCarId(@PathVariable(value = "id") int id){	
		int carId=id;
		Optional<Car> c = carrepo.findById(carId);
		String numberPlate = c.get().getNumberPlate();
		String carName = c.get().getModelName();
		
		User user =  loginDetails();
		String useremail = user.getEmail();
	
		List<CarRent> cr =  carrentrepo.findByDriver(user);
		CarRent cr1 = carrentrepo.findByModelNameAndNumberPlate(carName,numberPlate);
		int size=cr.size();
		if(size>1)
		{
			return "redirect:/carRental?already";
		}
		
			CarRent carRent=cr.get(0);
			carRent.setDriver(user);
			carRent.setNumberPlate(numberPlate);
			carRent.setModelName(carName);
			carrentrepo.save(carRent);
			
			Car c1 = carrepo.findByModelNameAndNumberPlate(carName,numberPlate);
			c1.setStatus("booked");
			carrepo.save(c1);
			return "carBooked";	
	}
	
	
	@GetMapping("/carRental2")
	public String carRental(Model model)
	{
		User user =  loginDetails();
		model.addAttribute("carrents",carrentrepo.findByDriver(user));
		return "carRental2";
	}	
	//fix currentdate issue
	//exception handling custom exception
	@GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable(value = "id") long id) {
		Optional<CarRent> c = carrentrepo.findById((int) id);
		String modelName=c.get().getModelName();
		String numberPlate = c.get().getNumberPlate();
		Car c1 = carrepo.findByModelNameAndNumberPlate(modelName,numberPlate);
		c1.setStatus("notBooked");
		carrentrepo.deleteById((int) id);
        return "DeleteRide";
    }
}