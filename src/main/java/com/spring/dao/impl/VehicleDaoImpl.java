package com.spring.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.spring.dao.iface.IVehicleDao;
import com.spring.model.User;
import com.spring.model.Vehicle;

@Repository("vehicleDao")
public class VehicleDaoImpl extends AbstractDao<Integer, Vehicle> implements IVehicleDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Vehicle> findAllByUserId(int userId) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("userId", userId));
		List<Vehicle> vehicles = criteria.list();
		return vehicles;
	}

	@Override
	public void saveVehicle(Vehicle vehicle) {
		save(vehicle);
	}

	@Override
	public Vehicle findVehicleById(int vehicleId) {
		Vehicle vehicle = getByKey(vehicleId);
		return vehicle;
	}

	@Override
	public Vehicle findVehicleByReg(String regNumber) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("regNumber", regNumber));
		Vehicle vehicle = (Vehicle) criteria.uniqueResult();
		return vehicle;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Vehicle> findAllVehicle() {
		Criteria criteria = createEntityCriteria();
		return criteria.list();
	}

	@Override
	public void deleteVehicle(int vehicleId) {
		Vehicle vehicle = getByKey(vehicleId);
		vehicle.setStatus("INACTIVE");
		save(vehicle);
	}

	@Override
	public List<String> searchOwner(String parameter) {
		Criteria cri = getSession().createCriteria(User.class);
		cri.add(Restrictions.like("firstName", parameter, MatchMode.ANYWHERE));
		List<User> users = cri.list();
		List<String> stringList = new ArrayList<String>();
		for(User u : users) {
			stringList.add(u.getFirstName()+" "+u.getLastName()+" ("+u.getEmail()+")");
		}
		return stringList;
	}
}
