package com.perfios.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.perfios.model.Station;

@Repository
public interface StationRepo extends JpaRepository<Station,Integer>{

	Station findByName(String name);

//	Station findByStation(String stationName);

	



}