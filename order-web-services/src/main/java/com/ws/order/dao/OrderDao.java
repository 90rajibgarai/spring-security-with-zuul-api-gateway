package com.ws.order.dao;

import java.util.List;

import com.ws.order.model.Order;

public interface OrderDao
{
	public Order saveOrder(Order order);

	public List<Order> getOrders();

	public Order getOrder(String id);

	public void deleteOrder(Order order);
}
