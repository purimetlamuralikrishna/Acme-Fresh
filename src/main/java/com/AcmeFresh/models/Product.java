package com.AcmeFresh.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {

	@Id
	private String productCode;
	private String productName;
	private LocalDateTime producedDate;
	private Integer productPrice;
	private Integer productQuantity;
	
}
