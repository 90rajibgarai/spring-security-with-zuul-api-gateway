package com.ws.order.service;

import java.util.List;

import com.ws.order.model.Order;

public interface OrderService 
{
	public Order saveOrder(Order order);

	public List<Order> getOrders();

	public Order getOrder(String id);

	public Order deleteOrder(String id);
}
