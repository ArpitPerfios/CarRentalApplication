package com.perfios.dto;

import javax.persistence.ManyToOne;

public class CarRegistrationDto {

	private String company;
	private String modelName;
	private String engineType;
	private String numberPlate;
	private int mileage;
	private int manfYear;
	
	
    private String station;
    private String status;

    private Long owner;
	public CarRegistrationDto() {
		super();
	}

	public CarRegistrationDto(String company, String modelName, String engineType, String numberPlate, int mileage,
			int manfYear, String station,String status,Long owner) {
		super();
		this.company = company;
		this.modelName = modelName;
		this.engineType = engineType;
		this.numberPlate = numberPlate;
		this.mileage = mileage;
		this.manfYear = manfYear;
		this.station = station;
		this.status = status;
		this.owner=owner;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getEngineType() {
		return engineType;
	}

	public void setEngineType(String engineType) {
		this.engineType = engineType;
	}

	public String getNumberPlate() {
		return numberPlate;
	}

	public void setNumberPlate(String numberPlate) {
		this.numberPlate = numberPlate;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	public int getManfYear() {
		return manfYear;
	}

	public void setManfYear(int manfYear) {
		this.manfYear = manfYear;
	}

	public String getStation() {
		return station;
	}

	public void setStation(String station) {
		this.station = station;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getOwner() {
		return owner;
	}

	public void setOwner(Long owner) {
		this.owner = owner;
	}

	
	

	
}
