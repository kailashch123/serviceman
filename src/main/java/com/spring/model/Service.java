package com.spring.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class Service {

	private Integer serviceId;
	private Vehicle vehicle;
	private List<ServicePart> parts;
	private Date serviceDate;
	private double labourCharge;
	private User mechanic;
	private String status;
	private BasicCheckList checkList;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getServiceId() {
		return serviceId;
	}

	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="serviceId")
	public List<ServicePart> getParts() {
		return parts;
	}

	public void setParts(List<ServicePart> parts) {
		this.parts = parts;
	}

	public Date getServiceDate() {
		return serviceDate;
	}

	public void setServiceDate(Date serviceDate) {
		this.serviceDate = serviceDate;
	}

	public double getLabourCharge() {
		return labourCharge;
	}

	public void setLabourCharge(double labourCharge) {
		this.labourCharge = labourCharge;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public User getMechanic() {
		return mechanic;
	}

	public void setMechanic(User mechanic) {
		this.mechanic = mechanic;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "checkListId", unique = true)
	public BasicCheckList getCheckList() {
		return checkList;
	}

	public void setCheckList(BasicCheckList checkList) {
		this.checkList = checkList;
	}
	

}
