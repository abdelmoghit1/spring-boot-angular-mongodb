package com.example.accessingdatamongodb;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.data.annotation.Id;


public class Customer {

	@Id
	public String id;

	public String firstName;
	public String lastName;
	public String email;
	public String company;
	public Integer phone;
	public LocalDate created_date;
	
	
	
	public String getEmail() {
		return email;
	}

	public String getCompany() {
		return company;
	}

	public Integer getPhone() {
		return phone;
	}

	public LocalDate getCreated_date() {
		return created_date;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	public void setCreated_date(LocalDate created_date) {
		this.created_date = created_date;
	}


	

	public Customer() {
		this.created_date=LocalDate.now();
	}

	public Customer(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	@Override
	public String toString() {
		return String.format(
				"Customer[id=%s, firstName='%s', lastName='%s']",
				id, firstName, lastName);
	}

}

