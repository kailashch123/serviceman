package com.spring.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.spring.dao.iface.IOrderDao;
import com.spring.model.MyOrder;
import com.spring.model.User;

@Repository("orderDao")
public class OrderDaoImpl extends AbstractDao<Integer, MyOrder> implements IOrderDao {

	@Override
	public List<MyOrder> findAll() {
		Criteria criteria = createEntityCriteria();
		List<MyOrder> orders = criteria.list();
		return orders;
	}

	@Override
	public MyOrder findById(int orderId) {
		MyOrder order = getByKey(orderId);
		return order;
	}

	@Override
	public MyOrder saveOrder(MyOrder order) {
		save(order);
		return order;
	}

	@Override
	public MyOrder update(MyOrder order) {
		getSession().update(order);
		return order;
	}

	@Override
	public void deleteOrderById(int orderId) {
		Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("orderId", orderId));
        MyOrder order = (MyOrder) crit.uniqueResult();
        delete(order);
	}

}
