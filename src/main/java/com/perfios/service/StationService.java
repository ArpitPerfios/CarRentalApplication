package com.perfios.service;

import java.util.List;

import com.perfios.dto.StationRegistrationDto;
import com.perfios.model.Station;

public interface StationService  {

	List<Station> findAll();

	Station Save(StationRegistrationDto registrationDto);
	
}

