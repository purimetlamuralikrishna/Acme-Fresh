package com.AcmeFresh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.AcmeFresh.Service.BuyersServiceInterface;
import com.AcmeFresh.models.Buyer;
import com.AcmeFresh.models.LoginDTO;
import com.AcmeFresh.models.LoginDetails;
import com.AcmeFresh.models.Product;
import com.AcmeFresh.models.SuccessMessage;

@RestController
public class BuyerController {

	@Autowired
	BuyersServiceInterface buyerService;
	
	
	@PostMapping("/buyer/register")
	public ResponseEntity<SuccessMessage> buyerRegister(@RequestBody Buyer buyer){
		
		return new ResponseEntity<SuccessMessage>(buyerService.register(buyer),HttpStatus.ACCEPTED);	
	}
	
	
	@PostMapping("/buyer/Login")
	public ResponseEntity<LoginDTO> buyerLogin(@RequestBody LoginDetails logDetails){
		
		return new ResponseEntity<LoginDTO>(buyerService.buyerLogin(logDetails),HttpStatus.ACCEPTED);	
	}
	
	
	@DeleteMapping("/buyer/Logout/{key}")
	public ResponseEntity<SuccessMessage> buyerLogout(@PathVariable("key") String key){
		
		return new ResponseEntity<SuccessMessage>(buyerService.buyerLogout(key),HttpStatus.ACCEPTED);	
	}
	
	@GetMapping("/buyer/getProducts/{key}")
	public ResponseEntity<List<Product>>  buyerGetAllProducts(@PathVariable("key") String key){
		
		return new ResponseEntity<List<Product>>(buyerService.getAllProducts(key),HttpStatus.ACCEPTED);
		
	}
	
	
}
