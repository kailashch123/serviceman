package com.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.iface.IVehicleDao;
import com.spring.model.Vehicle;
import com.spring.service.iface.IVehicleService;

@Service("vehicleService")
public class VehicleDaoImpl implements IVehicleService {

	
	@Autowired
	private IVehicleDao vehicleDao;
	@Override
	public List<Vehicle> findAllByUserId(int userId) {
		return vehicleDao.findAllByUserId(userId);
	}
	
	@Override
	public void saveVehicle(Vehicle vehicle) {
		vehicleDao.saveVehicle(vehicle);
	}

	@Override
	public Vehicle findVehicleById(int vehicleId) {
		return vehicleDao.findVehicleById(vehicleId);
	}

	@Override
	public List<Vehicle> findAllVehicle() {
		return vehicleDao.findAllVehicle();
	}

	@Override
	public void deleteVehicle(int vehicleId) {
		vehicleDao.deleteVehicle(vehicleId);
	}

	@Override
	public List<String> searchOwner(String parameter) {
		return vehicleDao.searchOwner(parameter);
	}

}
