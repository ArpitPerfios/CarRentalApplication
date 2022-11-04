package com.perfios.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perfios.dto.CarRegistrationDto;
import com.perfios.model.Car;
import com.perfios.model.CarRent;
import com.perfios.model.Station;
import com.perfios.model.User;
import com.perfios.repository.CarRentRepo;
import com.perfios.repository.CarRepo;
import com.perfios.repository.StationRepo;
import com.perfios.repository.UserRepository;


@Service
public class CarServiceImpl implements CarService {

	    @Autowired
	    private CarRepo carRepository;
	    
	    @Autowired
	    private StationRepo stationRepository;
	    
	    @Autowired
	    private CarRentRepo carrentrepo;
	    @Autowired
	    private UserRepository userRepository;
		
	    @Override
	    public Car save(CarRegistrationDto registrationDto) {
	    	
	    	String stationName=registrationDto.getStation();
	    	Station s = stationRepository.findByName(stationName);
	    	String numberPlate =registrationDto.getNumberPlate();
	        Optional<Car> car1 = carRepository.findByNumberPlate(numberPlate);
	        Long id=registrationDto.getOwner();
	        Optional<User> u = userRepository.findById(id);
	        User u1 = u.get();
//	        CarRent cr = carrentrepo.findByModelNameAndNumberPlate(registrationDto.getModelName(), registrationDto.getNumberPlate());
	    	if(s!=null && car1.isEmpty()) {
	    		Car car = new Car(registrationDto.getCompany(),registrationDto.getModelName(),registrationDto.getEngineType(),
						registrationDto.getNumberPlate(),registrationDto.getMileage(),registrationDto.getManfYear(),s,"notBooked",u1);
				return carRepository.save(car);
	    	}
	    	
	    	else {
	    		return null;}
	    	
	    	}

	    @Override
		public List<Car> findAllCars() {
			// TODO Auto-generated method stub
			return carRepository.findAll();
		}


//	    @Override
//		public List<String> findByNumberPlate() {
//			// TODO Auto-generated method stub
//			return carRepository.findByNumberPlate();
//		}

			
	    

}
