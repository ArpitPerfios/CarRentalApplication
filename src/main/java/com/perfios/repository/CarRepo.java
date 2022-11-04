package com.perfios.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.perfios.model.Car;
import com.perfios.model.Station;



@Repository
public interface CarRepo extends JpaRepository<Car,Integer>{

	Car findByModelName(String modelName);

	Optional<Car> findByNumberPlate(String numberPlate);

	Car findByModelNameAndNumberPlate(String s1, String s2);
	
	List<Car> findAll();

	List<Car> findByStation(Station s);

	List<Car> findByStationAndStatus(Station s, String status);

	

//	List<Car> findByModelName();

//	List findByNumberPlate();

//	List<Car> findByStation(Station station);
//
//	List<Car> findByMileageGreaterThan(Integer mileage);

}
