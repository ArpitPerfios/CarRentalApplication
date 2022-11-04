package com.perfios.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.perfios.model.CarRent;
import com.perfios.model.User;


@Repository
public interface CarRentRepo extends JpaRepository<CarRent,Integer>{

	List<CarRent> findByDriver(User user) ;

	CarRent findByModelNameAndNumberPlate(String carName, String numberPlate);

	


	

}

