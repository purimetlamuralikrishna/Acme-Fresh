package com.AcmeFresh.models;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CurrentUserSession {

	
	@Id
	private String MobileNumber;
	
	@Column(unique = true)
	private Integer customerId;
	
	private String uuid;
	
	private LocalDateTime localDateTime;
	
}
