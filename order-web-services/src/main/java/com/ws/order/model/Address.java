package com.ws.order.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
public class Address 
{
	private String addressLine;
	
	private String city;
	
	private String state;
	
	private String country;
	
	private String zipCode;
}
