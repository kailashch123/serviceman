package com.spring.service.iface;

import java.util.List;

import com.spring.model.MyOrder;

public interface IOrderService {

	List<MyOrder> findAll();

	MyOrder findById(int orderId);

	MyOrder saveOrder(MyOrder order);

	MyOrder update(MyOrder order);

	void deleteOrderById(int orderId);
}
