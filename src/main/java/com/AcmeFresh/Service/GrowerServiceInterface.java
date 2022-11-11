package com.AcmeFresh.Service;

import java.util.List;

import com.AcmeFresh.exception.AccountException;
import com.AcmeFresh.exception.ProductException;
import com.AcmeFresh.models.Growers;
import com.AcmeFresh.models.LoginDTO;
import com.AcmeFresh.models.LoginDetails;
import com.AcmeFresh.models.Product;
import com.AcmeFresh.models.SuccessMessage;

public interface GrowerServiceInterface {

	public SuccessMessage register(Growers grower)throws AccountException;
	public LoginDTO growerLogin(LoginDetails logindetails)throws AccountException;
	public Growers isGrowerLoggedIn(String key)throws AccountException;
	public SuccessMessage growerLogout(String key)throws AccountException;
	public Product addProduct(Product product,String key)throws ProductException;
	public Product updateProduct(Product product,String key)throws ProductException;
	public SuccessMessage removeProduct(String productCode,String key)throws ProductException;
	public List<Product> getProducts(String key)throws ProductException;
}
