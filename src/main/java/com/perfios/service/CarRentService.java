package com.perfios.service;

import java.text.ParseException;

import com.perfios.dto.CarRentalDto;
import com.perfios.model.CarRent;



public interface CarRentService {

	CarRent save(CarRentalDto registrationDto) throws ParseException;
}
