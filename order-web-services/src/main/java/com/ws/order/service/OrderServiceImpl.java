package com.ws.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.ws.order.dao.OrderDao;
import com.ws.order.exception.ResourceNotFoundException;
import com.ws.order.model.Order;

@Service
public class OrderServiceImpl implements OrderService 
{
	@Autowired
	private OrderDao orderDao;
	
	@Override
	public Order saveOrder(Order order)
	{
		return orderDao.saveOrder(order);
	}

	@Override
	public List<Order> getOrders()
	{
		return orderDao.getOrders();
	}

	@Override
	public Order getOrder(String id)
	{
		return orderDao.getOrder(id);
	}

	@Override
	public Order deleteOrder(String id)
	{
		Order order = orderDao.getOrder(id);
		
		if(ObjectUtils.isEmpty(order))
			throw new ResourceNotFoundException("Order", "Id", id);
		
		orderDao.deleteOrder(order);
		
		return order;
	}
}
