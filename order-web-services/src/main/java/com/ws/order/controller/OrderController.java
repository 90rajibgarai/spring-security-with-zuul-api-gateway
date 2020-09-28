package com.ws.order.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ws.order.exception.ResourceNotFoundException;
import com.ws.order.model.Order;
import com.ws.order.service.OrderService;


@RestController
@RequestMapping("/orders")
public class OrderController 
{
	@Autowired
	private OrderService orderService;
	
//-------------------------------------------------------------------------SAVE ORDER INFORMATION---------------------------------

	@PostMapping()
	public ResponseEntity<?> saveOrder(@RequestBody Order order)
	{
		Order saveOrder = orderService.saveOrder(order);
		
		URI location = ServletUriComponentsBuilder
							.fromCurrentRequest()
							.path("/{id}")
							.buildAndExpand(saveOrder.getId())
							.toUri();
		
		return ResponseEntity.created(location).build();
	}
	
//-------------------------------------------------------------------------GET ORDERS INFORMATIONS---------------------------------
	
	@GetMapping						
	public List<Order> getOrders()
	{
		return orderService.getOrders();
	}
	
//-------------------------------------------------------------------------GET ORDER INFORMATION-----------------------------------	
	
	@GetMapping("/{id}")
	public Order getOrder(@PathVariable("id") String id)
	{
		return orderService.getOrder(id);
	}
	
//-------------------------------------------------------------------------DELETE ORDER INFORMATION---------------------------------	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteOrder(@PathVariable("id") String id)
	{
		Order order = orderService.deleteOrder(id);
		
		if(ObjectUtils.isEmpty(order))
			throw new ResourceNotFoundException("Order", "Id", id);
		
		return ResponseEntity.noContent().build();
	}
	
//--------------------------------------------------------------------------END------------------------------------------------------
}
