package com.perfios.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perfios.dto.CarRentalDto;
import com.perfios.model.CarRent;
import com.perfios.model.Station;
import com.perfios.model.User;
import com.perfios.repository.CarRentRepo;
import com.perfios.repository.CarRepo;
import com.perfios.repository.StationRepo;
import com.perfios.repository.UserRepository;



@Service
public class CarRentServiceImpl implements CarRentService {

	    @Autowired
	    private CarRepo carRepository;
	    @Autowired
	    private StationRepo stationRepository;
	    @Autowired
	    private UserRepository userrepository;
	    @Autowired
	    private CarRentRepo carRentRepository;

	    
	@Override
	public CarRent save(CarRentalDto registrationDto) throws ParseException {
		// TODO Auto-generated method stub
		String userEmail = registrationDto.getDriver();
		String model_name = registrationDto.getCar();
		String numberPlate = registrationDto.getNumberPlate();
		String station1 = registrationDto.getBookStation();
//		String station2 = registrationDto.getDropStation();
//		SimpleDateFormat formatter= new SimpleDateFormat("dd/MM/yyyy");
//		Date date = new Date();
		
		
		String d1=registrationDto.getRentalDate();
		Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(d1); 
		String d2 = registrationDto.getReturnDate();
		Date date2=new SimpleDateFormat("yyyy-MM-dd").parse(d2); 
		String status = "booked";
		User u = userrepository.findByEmail(userEmail);
		Station s1 = stationRepository.findByName(station1);
		
		if(u!=null && s1!=null && d1.compareTo(d2)<=0  ) {
			CarRent crent= new CarRent(date1,date2
					,u,registrationDto.getCar(),registrationDto.getKm(),registrationDto.getNumberPlate(),s1,status);
		    return carRentRepository.save(crent);
		}
		else {
			return null;
		}

}
}