package com.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BasicCheckList {

	private Integer checkListId;
	private boolean engineOilCheck;
	private boolean oilFilterCheck;
	private boolean airFilterCheck;
	private boolean sparkPlugCheck;
	private boolean driveChainCheck;
	private boolean oilGreaseCheck;
	private boolean clutchCheck;
	private boolean mileageCheck;
	private boolean brakePadCheck;
	private Integer sericeId;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getCheckListId() {
		return checkListId;
	}

	public void setCheckListId(Integer checkListId) {
		this.checkListId = checkListId;
	}

	public boolean isEngineOilCheck() {
		return engineOilCheck;
	}

	public void setEngineOilCheck(boolean engineOilCheck) {
		this.engineOilCheck = engineOilCheck;
	}

	public boolean isOilFilterCheck() {
		return oilFilterCheck;
	}

	public void setOilFilterCheck(boolean oilFilterCheck) {
		this.oilFilterCheck = oilFilterCheck;
	}

	public boolean isAirFilterCheck() {
		return airFilterCheck;
	}

	public void setAirFilterCheck(boolean airFilterCheck) {
		this.airFilterCheck = airFilterCheck;
	}

	public boolean isSparkPlugCheck() {
		return sparkPlugCheck;
	}

	public void setSparkPlugCheck(boolean sparkPlugCheck) {
		this.sparkPlugCheck = sparkPlugCheck;
	}

	public boolean isDriveChainCheck() {
		return driveChainCheck;
	}

	public void setDriveChainCheck(boolean driveChainCheck) {
		this.driveChainCheck = driveChainCheck;
	}

	public boolean isOilGreaseCheck() {
		return oilGreaseCheck;
	}

	public void setOilGreaseCheck(boolean oilGreaseCheck) {
		this.oilGreaseCheck = oilGreaseCheck;
	}

	public boolean isClutchCheck() {
		return clutchCheck;
	}

	public void setClutchCheck(boolean clutchCheck) {
		this.clutchCheck = clutchCheck;
	}

	public boolean isMileageCheck() {
		return mileageCheck;
	}

	public void setMileageCheck(boolean mileageCheck) {
		this.mileageCheck = mileageCheck;
	}

	public boolean isBrakePadCheck() {
		return brakePadCheck;
	}

	public void setBrakePadCheck(boolean brakePadCheck) {
		this.brakePadCheck = brakePadCheck;
	}

	public Integer getSericeId() {
		return sericeId;
	}

	public void setSericeId(Integer sericeId) {
		this.sericeId = sericeId;
	}
	
	

}
