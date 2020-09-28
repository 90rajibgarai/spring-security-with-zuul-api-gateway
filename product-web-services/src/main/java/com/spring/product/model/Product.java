package com.spring.product.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PRODUCT")
@Data @NoArgsConstructor
public class Product 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String title;
	
	private String description;
	
	private Integer categoryId;
	
	private Integer subCategoryId;
	
	private LocalDateTime addedDate;	
	
	private LocalDateTime updatedDate;
	
	private Integer addedBy;
	
	private Integer modifiedBy;
}
