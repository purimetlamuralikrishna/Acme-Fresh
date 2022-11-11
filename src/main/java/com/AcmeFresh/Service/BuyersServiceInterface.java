package com.AcmeFresh.Service;

import java.util.List;

import com.AcmeFresh.exception.AccountException;
import com.AcmeFresh.exception.ProductException;
import com.AcmeFresh.models.Buyer;
import com.AcmeFresh.models.LoginDTO;
import com.AcmeFresh.models.LoginDetails;
import com.AcmeFresh.models.Product;
import com.AcmeFresh.models.SuccessMessage;

public interface BuyersServiceInterface {

	public SuccessMessage register(Buyer buyer) throws AccountException;
	public LoginDTO buyerLogin(LoginDetails logindetails) throws AccountException;
	public Buyer isBuyerLoggedIn(String key) throws AccountException;
	public SuccessMessage buyerLogout(String key) throws AccountException;
	public List<Product> getAllProducts(String key)throws AccountException;
}
