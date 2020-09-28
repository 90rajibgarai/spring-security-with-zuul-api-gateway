package com.ws.order.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException
{
	private static final long serialVersionUID = -2497741127030199824L;
	
	private String resourceName;
    private String propertyName;
    private Object propertyValue;

	public ResourceNotFoundException(String resourceName, String propertyName, Object propertyValue)
	{
		super(String.format("%s is not found by %s : '%s'", resourceName, propertyName, propertyValue));
		
		this.resourceName = resourceName;
        this.propertyName = propertyName;
        this.propertyValue = propertyValue;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public Object getPropertyValue() {
		return propertyValue;
	}

	public void setPropertyValue(Object propertyValue) {
		this.propertyValue = propertyValue;
	}
}
