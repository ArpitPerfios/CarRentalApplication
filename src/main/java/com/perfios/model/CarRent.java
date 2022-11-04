package com.perfios.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import net.bytebuddy.utility.nullability.NeverNull;

@Entity
@Table(name="carrent")
public class CarRent {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Date rentalDate;
    private Date returnDate;

    @OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="userid",referencedColumnName="id")
    private User driver;

    private String modelName;
    
    private Integer km;
    private String numberPlate;
    @OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="pickupstationid",referencedColumnName="id")
    private Station bookStation;

    private String status;
	public CarRent() {
		super();
	}

	

	public CarRent( Date rentalDate, Date returnDate, User driver, String modelName, Integer km,
			String numberPlate, Station bookStation, String status) {
		super();
		this.rentalDate = rentalDate;
		this.returnDate = returnDate;
		this.driver = driver;
		this.modelName = modelName;
		this.km = km;
		this.numberPlate = numberPlate;
		this.bookStation = bookStation;
		this.status = status;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public Date getRentalDate() {
		return rentalDate;
	}



	public void setRentalDate(Date rentalDate) {
		this.rentalDate = rentalDate;
	}



	public Date getReturnDate() {
		return returnDate;
	}



	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}



	public User getDriver() {
		return driver;
	}



	public void setDriver(User driver) {
		this.driver = driver;
	}



	public String getModelName() {
		return modelName;
	}



	public void setModelName(String modelName) {
		this.modelName = modelName;
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



	public Station getBookStation() {
		return bookStation;
	}



	public void setBookStation(Station bookStation) {
		this.bookStation = bookStation;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	
}
