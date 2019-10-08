package com.spring.dao.iface;

import java.util.List;

import com.spring.model.Vehicle;

public interface IVehicleDao {
	
	List<Vehicle> findAllByUserId(int userId);

	void saveVehicle(Vehicle vehicle);

	Vehicle findVehicleById(int vehicleId);
	
	Vehicle findVehicleByReg(String regNumber);

	List<Vehicle> findAllVehicle();

	void deleteVehicle(int vehicleId);

	List<String> searchOwner(String parameter);

}
