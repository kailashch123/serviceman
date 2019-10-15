package com.spring.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ServicePart {

	private Integer partId;
	private String name;
	private String brand;
	private String vehicelModel;
	private String modelNumber;
	private String makeMonthYear;
	private String supportYears;
	private String material;
	private String color;
	private double pricePerUnit;
	private int quantity;
	private Date lastModifiedDate;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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

	public String getVehicelModel() {
		return vehicelModel;
	}

	public void setVehicelModel(String vehicelModel) {
		this.vehicelModel = vehicelModel;
	}

	public String getModelNumber() {
		return modelNumber;
	}

	public void setModelNumber(String modelNumber) {
		this.modelNumber = modelNumber;
	}

	public String getMakeMonthYear() {
		return makeMonthYear;
	}

	public void setMakeMonthYear(String makeMonthYear) {
		this.makeMonthYear = makeMonthYear;
	}

	public String getSupportYears() {
		return supportYears;
	}

	public void setSupportYears(String supportYears) {
		this.supportYears = supportYears;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getPricePerUnit() {
		return pricePerUnit;
	}

	public void setPricePerUnit(double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	
}
