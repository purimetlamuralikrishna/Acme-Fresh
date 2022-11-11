package com.AcmeFresh.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class LoginDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer log_Id;
	
	private Integer cid;
	
	private LocalDateTime localDateTime;
	
	private String uuid;
}
