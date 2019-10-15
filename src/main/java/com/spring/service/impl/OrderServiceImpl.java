package com.spring.service.impl;

import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.iface.IOrderDao;
import com.spring.model.MyOrder;
import com.spring.service.iface.IOrderService;

@Service("orderService")
@Transactional
public class OrderServiceImpl implements IOrderService {
	
	@Autowired
	private IOrderDao orderDao;

	@Override
	public List<MyOrder> findAll() {
		return orderDao.findAll();
	}

	@Override
	public MyOrder findById(int orderId) {
		return orderDao.findById(orderId);
	}

	@Override
	public MyOrder saveOrder(MyOrder order) {
		MyOrder orderTemp = orderDao.saveOrder(order);
		return orderTemp;
	}

	@Override
	public MyOrder update(MyOrder order) {
		return orderDao.update(order);
	}

	@Override
	public void deleteOrderById(int orderId) {
		orderDao.deleteOrderById(orderId);
	}

}
