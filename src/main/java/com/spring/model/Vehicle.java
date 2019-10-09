package com.spring.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Vehicle {

	private Integer vehicleId;
	private String brand;
	private String model;
	private Date makeYear;
	private String regNumber;
	private User owner;
	private String status;
	private String ownerString;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Integer vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Temporal(TemporalType.DATE)
	public Date getMakeYear() {
		return makeYear;
	}

	public void setMakeYear(Date makeYear) {
		this.makeYear = makeYear;
	}

	public String getRegNumber() {
		return regNumber;
	}

	public void setRegNumber(String regNumber) {
		this.regNumber = regNumber;
	}

	@ManyToOne
	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getOwnerString() {
		return ownerString;
	}

	public void setOwnerString(String ownerString) {
		this.ownerString = ownerString;
	}

}
