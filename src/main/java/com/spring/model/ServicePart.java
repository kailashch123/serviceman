package com.spring.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ServicePart {

	private Integer partId;
	private String name;
	private String brand;
	private Date makeYear;
	private double pricePerUnit;
	private double vatPercent;
	private int quantity;
	private String partFor;
	private Date lastModifiedDate;
	private String availability;
	private Service service;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getPartId() {
		return partId;
	}

	public void setPartId(Integer partId) {
		this.partId = partId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Date getMakeYear() {
		return makeYear;
	}

	public void setMakeYear(Date makeYear) {
		this.makeYear = makeYear;
	}

	public double getPricePerUnit() {
		return pricePerUnit;
	}

	public void setPricePerUnit(double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

	public double getVatPercent() {
		return vatPercent;
	}

	public void setVatPercent(double vatPercent) {
		this.vatPercent = vatPercent;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getPartFor() {
		return partFor;
	}

	public void setPartFor(String partFor) {
		this.partFor = partFor;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}
	
	@ManyToOne
	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

}
