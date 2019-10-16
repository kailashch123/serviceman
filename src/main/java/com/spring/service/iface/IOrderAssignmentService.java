package com.spring.service.iface;

import java.util.List;

import com.spring.model.User;
import com.spring.model.Vehicle;

public interface IOrderAssignmentService {

	List<User> getAllMechanic();

	User getMechanicById(int mechId);

	List<Vehicle> findAllSubmittedVehicle();

	void saveAssignment(int mechId, int vehicleId);

}
