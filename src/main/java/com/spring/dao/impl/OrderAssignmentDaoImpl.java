package com.spring.dao.impl;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.spring.dao.iface.IOrderAssignmentDao;
import com.spring.model.OrderAssignment;
import com.spring.model.User;
import com.spring.model.Vehicle;

@Repository("mechanicDao")
public class OrderAssignmentDaoImpl extends AbstractDao<Integer, User> implements IOrderAssignmentDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllMechanic() {
		Criteria cr = getSession().createCriteria(User.class);
		cr.add(Restrictions.eq("role", "MECHANIC"));
		List<User> mechanics = getMechanicsWithOrderPending(cr.list());
		return mechanics;
	}

	@SuppressWarnings("unchecked")
	private List<User> getMechanicsWithOrderPending(List<User> mechanics) {
		Iterator<User> it = mechanics.iterator();
		while(it.hasNext()) {
			User user = it.next();
			int userId = user.getUserId();
			Criteria cr = getSession().createCriteria(OrderAssignment.class);
			cr.add(Restrictions.eq("userId", userId));
			List<OrderAssignment> assignments = cr.list();
			int count = assignments.size();
			user.setOrderPending(count);
		}
		return mechanics;
	}

	@Override
	public User getMechanicById(int mechId) {
		User user = getByKey(mechId);
		return user;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Vehicle> findAllSubmittedVehicle() {
		Criteria cr = getSession().createCriteria(Vehicle.class);
		cr.add(Restrictions.eq("status", "SUBMITTED"));
		return cr.list();
	}

	@Override
	public void saveAssignment(int mechId, int vehicleId) {
		OrderAssignment oa = new OrderAssignment();
		oa.setMechId(mechId);
		oa.setVehicleId(vehicleId);
		getSession().save(oa);
	}

}
