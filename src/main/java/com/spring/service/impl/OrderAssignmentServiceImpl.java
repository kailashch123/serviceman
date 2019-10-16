package com.spring.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.iface.IOrderAssignmentDao;
import com.spring.model.User;
import com.spring.model.Vehicle;
import com.spring.service.iface.IOrderAssignmentService;

@Service("mechanicService")
@Transactional
public class OrderAssignmentServiceImpl implements IOrderAssignmentService {

	@Autowired
	private IOrderAssignmentDao mechanicDao;

	@Override
	public List<User> getAllMechanic() {
		return mechanicDao.getAllMechanic();
	}

	@Override
	public User getMechanicById(int mechId) {
		return mechanicDao.getMechanicById(mechId);
	}

	@Override
	public List<Vehicle> findAllSubmittedVehicle() {
		return mechanicDao.findAllSubmittedVehicle();
	}

	@Override
	public void saveAssignment(int mechId, int vehicleId) {
		mechanicDao.saveAssignment(mechId, vehicleId);
	}
	
}
