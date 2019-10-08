package com.spring.service.iface;

import java.util.List;

import com.spring.model.Vehicle;

public interface IVehicleService {

	List<Vehicle> findAllByUserId(int userId);

	void saveVehicle(Vehicle vehicle);

	Vehicle findVehicleById(int vehicleId);

	List<Vehicle> findAllVehicle();

	void deleteVehicle(int vehicleId);

	List<String> searchOwner(String parameter);
	
}
