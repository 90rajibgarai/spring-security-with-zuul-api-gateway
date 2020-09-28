package com.ws.order.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ws.order.exception.ResourceNotFoundException;
import com.ws.order.model.Order;
import com.ws.order.repository.OrderRepository;

@Service
public class OrderDaoImpl implements OrderDao 
{
	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public Order saveOrder(Order order) 
	{
		return orderRepository.save(order);
	}

	@Override
	public List<Order> getOrders()
	{
		return orderRepository.findAll();
	}

	@Override
	public Order getOrder(String id)
	{
		Optional<Order> oplOrder = orderRepository.findById(id);
		
		if(!oplOrder.isPresent())
			throw new ResourceNotFoundException("Order", "Id", id);
		
		 return oplOrder.get();
	}

	@Override
	public void deleteOrder(Order order)
	{
		orderRepository.delete(order);
	}

}
