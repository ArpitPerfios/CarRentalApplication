package com.perfios.dto;

import java.sql.Date;

import javax.persistence.Column;

public class UserRegistrationDto {
	
	private String firstName;
	private String lastName;
	private int age;
	private String gender;
	private long contact;
	private String state;
	private String country;
	private String city;
	private String email;
	private String password;
	
	
	public UserRegistrationDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public UserRegistrationDto(String firstName, String lastName, int age, String gender, long contact, String state,
			String country, String city, String email, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.contact = contact;
		this.state = state;
		this.country = country;
		this.city = city;
		this.email = email;
		this.password = password;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public long getContact() {
		return contact;
	}


	public void setContact(long contact) {
		this.contact = contact;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	
	

}