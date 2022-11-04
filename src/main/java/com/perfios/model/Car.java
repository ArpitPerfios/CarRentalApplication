package com.perfios.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="car")
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String company;
	private String modelName;
	private String engineType;
	private String numberPlate;
	private int mileage;
	private int manfYear;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="stationid",referencedColumnName="id")
    private Station station;

	private String status;
	
	@OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="userid",referencedColumnName="id")
    private User owner;
	
	public Car()
	{
		
	}
	
	

	public Car( String company, String modelName, String engineType, String numberPlate, int mileage,
			int manfYear, Station station,String status,User owner) {
		super();
		this.company = company;
		this.modelName = modelName;
		this.engineType = engineType;
		this.numberPlate = numberPlate;
		this.mileage = mileage;
		this.manfYear = manfYear;
		this.station = station;
		this.status = status;
		this.owner = owner;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Station getStation() {
		return station;
	}

	public void setStation(Station station) {
		this.station = station;
	}



	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}



	public User getOwner() {
		return owner;
	}



	public void setOwner(User owner) {
		this.owner = owner;
	}

	
	
	
	
	
	
}
