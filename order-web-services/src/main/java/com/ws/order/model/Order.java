package com.ws.order.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "order")
@Data @NoArgsConstructor
public class Order 
{
	@Id
	private Integer id;
	
	private LocalDateTime orderedDate;
	
	private LocalDateTime shippedDate;
	
	private Address shipTo;
	
	private String orderStatus;
	
	private Double totalPrice;
	
	private Integer addedBy;
}
