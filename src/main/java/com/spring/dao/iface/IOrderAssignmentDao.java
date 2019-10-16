package com.spring.dao.iface;

import java.util.List;

import com.spring.model.User;
import com.spring.model.Vehicle;

public interface IOrderAssignmentDao {

	List<User> getAllMechanic();

	User getMechanicById(int mechId);

	List<Vehicle> findAllSubmittedVehicle();

	void saveAssignment(int mechId, int vehicleId);
}
