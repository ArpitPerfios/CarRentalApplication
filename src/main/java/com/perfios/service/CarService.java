package com.perfios.service;

import java.util.List;

import com.perfios.dto.CarRegistrationDto;
import com.perfios.model.Car;



public interface CarService {

	Car save(CarRegistrationDto registrationDto);

	List<Car> findAllCars();
}
