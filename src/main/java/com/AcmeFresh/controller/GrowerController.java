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

import com.AcmeFresh.Service.GrowerServiceInterface;
import com.AcmeFresh.models.Growers;
import com.AcmeFresh.models.LoginDTO;
import com.AcmeFresh.models.LoginDetails;
import com.AcmeFresh.models.Product;
import com.AcmeFresh.models.SuccessMessage;

@RestController
public class GrowerController {

	@Autowired
	GrowerServiceInterface growerservice;
	
	
	@PostMapping("/grower/register")
	public ResponseEntity<SuccessMessage> growerRegister(@RequestBody Growers grower){
		
		return new ResponseEntity<SuccessMessage>(growerservice.register(grower),HttpStatus.ACCEPTED);	
	}
	
	@PostMapping("/grower/Login")
	public ResponseEntity<LoginDTO> growerLogin(@RequestBody LoginDetails logDetails){
		
		return new ResponseEntity<LoginDTO>(growerservice.growerLogin(logDetails),HttpStatus.ACCEPTED);	
	}
	
	
	@DeleteMapping("/grower/Logout/{key}")
	public ResponseEntity<SuccessMessage> growerLogout(@PathVariable("key") String key){
		
		return new ResponseEntity<SuccessMessage>(growerservice.growerLogout(key),HttpStatus.ACCEPTED);	
	}
	
	
	@PostMapping("/grower/addProduct/{key}")
	public ResponseEntity<Product> growerAddProduct(@RequestBody Product product,@PathVariable("key") String key){
		
		return new ResponseEntity<Product>(growerservice.addProduct(product, key),HttpStatus.ACCEPTED);	
	}
	
	@GetMapping("/grower/getProducts/{key}")
	public ResponseEntity<List<Product>> getListOfGrowerProducts(@PathVariable("key") String key){
		return new ResponseEntity<List<Product>>(growerservice.getProducts(key),HttpStatus.ACCEPTED);
	}
	
	
	
	@PostMapping("/grower/updateProduct/{key}")
	public ResponseEntity<Product> growerUpdateProduct(@RequestBody Product product,@PathVariable("key") String key){
		
		return new ResponseEntity<Product>(growerservice.updateProduct(product, key),HttpStatus.ACCEPTED);	
	}
	
	
	@DeleteMapping("/grower/deleteProduct/{productCode}/{key}")
	public ResponseEntity<SuccessMessage> growerdeleteProduct(@PathVariable("productCode") String code,@PathVariable("key") String key){
		
		return new ResponseEntity<SuccessMessage>(growerservice.removeProduct(code, key),HttpStatus.ACCEPTED);	
	}
	
	
	
	
	
	
	
	
	
}
