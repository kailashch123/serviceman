package com.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OrderAssignment {

	private Integer oaId;
	private Integer mechId;
	private Integer vehicleId;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getOaId() {
		return oaId;
	}

	public void setOaId(Integer oaId) {
		this.oaId = oaId;
	}

	public Integer getMechId() {
		return mechId;
	}

	public void setMechId(Integer mechId) {
		this.mechId = mechId;
	}

	public Integer getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Integer vehicleId) {
		this.vehicleId = vehicleId;
	}

}
