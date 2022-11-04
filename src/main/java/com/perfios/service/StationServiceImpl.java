package com.perfios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perfios.dto.StationRegistrationDto;
import com.perfios.model.Station;
import com.perfios.repository.StationRepo;

@Service
public class StationServiceImpl implements StationService {

	@Autowired
	private StationRepo stationrepository;
	
	@Override
	public List<Station> findAll() {
        return stationrepository.findAll();
    }
	
	@Override
    public Station Save(StationRegistrationDto registrationDto) {
		Station station = new Station(registrationDto.getName());
		return stationrepository.save(station);
		
	}
}
