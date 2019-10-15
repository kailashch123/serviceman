package com.spring.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
public class MyOrder {

	private Integer orderId;
	private String orderReceiver;
	private String customerName;
	private String customerMobile;
	private String customerEmail;
	private Date serviceDate;
	private String vehicleBrand;
	private String vehicleModel;
	private String customerRecomendation;
	private String observerRecomendation;
	private String status;
	private double expectedServiceCost;
	private Date deliveryDateTime;
	private String delDate;
	private String delTime;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getOrderReceiver() {
		return orderReceiver;
	}

	public void setOrderReceiver(String orderReceiver) {
		this.orderReceiver = orderReceiver;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerMobile() {
		return customerMobile;
	}

	public void setCustomerMobile(String customerMobile) {
		this.customerMobile = customerMobile;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getServiceDate() {
		return serviceDate;
	}

	public void setServiceDate(Date serviceDate) {
		this.serviceDate = serviceDate;
	}

	public String getVehicleBrand() {
		return vehicleBrand;
	}

	public void setVehicleBrand(String vehicleBrand) {
		this.vehicleBrand = vehicleBrand;
	}

	public String getVehicleModel() {
		return vehicleModel;
	}

	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

	public String getCustomerRecomendation() {
		return customerRecomendation;
	}

	public void setCustomerRecomendation(String customerRecomendation) {
		this.customerRecomendation = customerRecomendation;
	}

	public String getObserverRecomendation() {
		return observerRecomendation;
	}

	public void setObserverRecomendation(String observerRecomendation) {
		this.observerRecomendation = observerRecomendation;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getExpectedServiceCost() {
		return expectedServiceCost;
	}

	public void setExpectedServiceCost(double expectedServiceCost) {
		this.expectedServiceCost = expectedServiceCost;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getDeliveryDateTime() {
		return deliveryDateTime;
	}

	public void setDeliveryDateTime(Date deliveryDateTime) {
		this.deliveryDateTime = deliveryDateTime;
	}

	@Transient
	public String getDelDate() {
		return delDate;
	}

	public void setDelDate(String delDate) {
		this.delDate = delDate;
	}

	@Transient
	public String getDelTime() {
		return delTime;
	}

	public void setDelTime(String delTime) {
		this.delTime = delTime;
	}

}
