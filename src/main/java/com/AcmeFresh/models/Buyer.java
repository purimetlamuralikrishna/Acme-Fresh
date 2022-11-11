package com.AcmeFresh.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Buyer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerId;

	@NotEmpty(message = "Name could not be null")
	private String name;
	
	@Pattern(regexp = "[789]{1}[0-9]{9}")
	private String mobileNumber;
	
	@NotNull(message = "Password  could not be null")
	@Size(min=4,max=10,message ="Password size min 4 and max 10 required")
	private String password;
}
