package com.AcmeFresh.Service;


import java.time.LocalDateTime;
import java.util.Optional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AcmeFresh.Repositery.CurrentUserSessionRepo;
import com.AcmeFresh.Repositery.GrowerRepositery;
import com.AcmeFresh.Repositery.ProductRepositery;
import com.AcmeFresh.exception.AccountException;
import com.AcmeFresh.exception.ProductException;
import com.AcmeFresh.models.CurrentUserSession;
import com.AcmeFresh.models.Growers;
import com.AcmeFresh.models.LoginDTO;
import com.AcmeFresh.models.LoginDetails;
import com.AcmeFresh.models.Product;
import com.AcmeFresh.models.SuccessMessage;
import net.bytebuddy.utility.RandomString;
@Service
public class GrowerService implements GrowerServiceInterface{
	
	@Autowired
	GrowerRepositery growerRepo;
	
	@Autowired
	CurrentUserSessionRepo currentuserRepo;
	
	@Autowired
	ProductRepositery productRepo;


	@Override
	public SuccessMessage register(Growers grower) throws AccountException{
		
		Optional<Growers> opt = growerRepo.findByMobileNumber(grower.getMobileNumber());
		
		if(opt.isPresent()) {
			throw new AccountException("Account Already Registered");
		}
		
		growerRepo.save(grower);
		
		SuccessMessage msg = new SuccessMessage();
		msg.setMessage("Buyer Registed Successfully");
		msg.setDateAndTime(LocalDateTime.now());
		
		return msg;
		
	}

	@Override
	public LoginDTO growerLogin(LoginDetails logindetails) throws AccountException{
		
		Optional<Growers> opt = growerRepo.findByMobileNumber(logindetails.getMobileNumber());
		
		if(opt.isEmpty()) {
			throw new AccountException("Account Doesn't Exists");
		}
		
		Optional<CurrentUserSession> currentOpt = currentuserRepo.findById(logindetails.getMobileNumber());
		
		if(currentOpt.isEmpty()) {
			
			if(logindetails.getPassword().equals(opt.get().getPassword())) {
				CurrentUserSession currentUser = new CurrentUserSession(logindetails.getMobileNumber(),
						opt.get().getCustomerId(),
						logindetails.getMobileNumber()+RandomString.make(6),
						LocalDateTime.now());
				currentuserRepo.save(currentUser);
				LoginDTO log = new LoginDTO();
				log.setCid(currentUser.getCustomerId());
				log.setUuid(currentUser.getUuid());
				log.setLocalDateTime(currentUser.getLocalDateTime());
				return log;
			}
			//wrong Password
			throw new AccountException("Invalid Password");
			
			
		}
		
		
		throw new AccountException("User Already logged In");
	}

	@Override
	public Growers isGrowerLoggedIn(String key) throws AccountException {
		
		Optional<CurrentUserSession> user=currentuserRepo.findById(key.substring(0,10));
		
		if(user.isEmpty()) {
			throw new AccountException("Invalid Key");
		}
		
		if(!user.get().getUuid().equals(key)){
			throw new AccountException("Invalid Key");
		}
		
		
		return growerRepo.findById(user.get().getCustomerId()).get();
	}

	@Override
	public SuccessMessage growerLogout(String key) throws AccountException {
		
		if(isGrowerLoggedIn(key)!=null) {
			
			currentuserRepo.deleteById(key.substring(0,10));
			SuccessMessage msg = new SuccessMessage();
			msg.setMessage("Logged Out Successfully");
			msg.setDateAndTime(LocalDateTime.now());
			return msg;
			
		}
		
		throw new AccountException("Invalid Key");
	}

	@Override
	public Product addProduct(Product product, String key) throws ProductException{
		
		Growers grower = isGrowerLoggedIn(key);
		
		List<Product> products = grower.getProducts();
		
		for(Product pro:products) {
			if(pro.getProductCode().equals(product.getProductCode())) {
				throw new ProductException("Product Already Available Just Update the Product");
			}
		}
		
		products.add(product);
		grower.setProducts(products);
		
		growerRepo.save(grower);
		
		
		return product;
	}

	@Override
	public Product updateProduct(Product product, String key) throws ProductException{
		
		Growers grower = isGrowerLoggedIn(key);
		
		List<Product> products = grower.getProducts();
		
		for(Product pro:products) {
			if(pro.getProductCode().equals(product.getProductCode())) {
				pro.setProductName(product.getProductName());
				pro.setProductPrice(product.getProductPrice());
				pro.setProductQuantity(product.getProductQuantity());
				pro.setProducedDate(product.getProducedDate());
				productRepo.save(pro);
				return pro;
			}
		}
		
		throw new ProductException("Product Not Avalible Kindly Add the Product");
	}

	@Override
	public SuccessMessage removeProduct(String productCode, String key)throws ProductException {
		
		Growers grower = isGrowerLoggedIn(key);
		
		List<Product> products = grower.getProducts();
		
		for(Product pro:products) {
			if(pro.getProductCode().equals(productCode)) {
				
				products.remove(pro);
				grower.setProducts(products);
				growerRepo.save(grower);
				productRepo.deleteById(productCode);
				return new SuccessMessage("Product Removed Successfully",LocalDateTime.now());
			}
		}
		
		
		throw new ProductException("Check Product Key");
	}

	@Override
	public List<Product> getProducts(String key) throws ProductException{
		
		Growers grower = isGrowerLoggedIn(key);
		if(grower.getProducts().size()==0) {
			throw new ProductException("No Products Avalible");
		} 
		
		return grower.getProducts();
	}
	
	

}
