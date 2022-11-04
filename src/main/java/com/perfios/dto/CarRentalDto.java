package com.perfios.dto;

import java.time.LocalDate;


import org.springframework.format.annotation.DateTimeFormat;

public class CarRentalDto{

    private String rentalDate;
    private String returnDate;
    private String driver;
    private String car;
    private Integer km;
    private String numberPlate;
    private String bookStation;
    private String status;
	public CarRentalDto() {
		super();
	}

	public CarRentalDto(String rentalDate, String returnDate, String driver, String car,Integer km,String numberPlate,
			String bookStation,String status) {
		super();
		this.rentalDate = rentalDate;
		this.returnDate = returnDate;
		this.driver = driver;
		this.car = car;
		this.km = km;
		this.numberPlate = numberPlate;
		this.bookStation = bookStation;
		this.status = status;
	}

	public String getRentalDate() {
		return rentalDate;
	}

	public void setRentalDate(String rentalDate) {
		this.rentalDate = rentalDate;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getCar() {
		return car;
	}

	public void setCar(String car) {
		this.car = car;
	}

	
	
	public Integer getKm() {
		return km;
	}

	public void setKm(Integer km) {
		this.km = km;
	}

	
	
	public String getNumberPlate() {
		return numberPlate;
	}

	public void setNumberPlate(String numberPlate) {
		this.numberPlate = numberPlate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getBookStation() {
		return bookStation;
	}

	public void setBookStation(String bookStation) {
		this.bookStation = bookStation;
	}


    
}