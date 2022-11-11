package com.AcmeFresh.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AcmeFresh.Repositery.BuyerRepositery;
import com.AcmeFresh.Repositery.CurrentUserSessionRepo;
import com.AcmeFresh.Repositery.ProductRepositery;
import com.AcmeFresh.exception.AccountException;
import com.AcmeFresh.models.Buyer;
import com.AcmeFresh.models.CurrentUserSession;
import com.AcmeFresh.models.LoginDTO;
import com.AcmeFresh.models.LoginDetails;
import com.AcmeFresh.models.Product;
import com.AcmeFresh.models.SuccessMessage;

import net.bytebuddy.utility.RandomString;

@Service
public class BuyerService implements BuyersServiceInterface {
	
	
	@Autowired
	BuyerRepositery buyerRepo;
	
	@Autowired
	CurrentUserSessionRepo currentuserRepo;
	
	@Autowired
	ProductRepositery productRepo;

	@Override
	public SuccessMessage register(Buyer buyer) throws AccountException{
		
		Optional<Buyer> opt = buyerRepo.findByMobileNumber(buyer.getMobileNumber());
		
		if(opt.isPresent()) {
			throw new AccountException("Account Already Registered");
		}
		
		buyerRepo.save(buyer);
		
		SuccessMessage msg = new SuccessMessage();
		msg.setMessage("Buyer Registed Successfully");
		msg.setDateAndTime(LocalDateTime.now());
		
		return msg;
	}

	@Override
	public LoginDTO buyerLogin(LoginDetails logindetails) throws AccountException {
		
		Optional<Buyer> opt = buyerRepo.findByMobileNumber(logindetails.getMobileNumber());
		
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
			
			throw new AccountException("Invalid Password");
			
			
		}
		throw new AccountException("User Already logged In");
	}

	@Override
	public Buyer isBuyerLoggedIn(String key) throws AccountException {
		
		Optional<CurrentUserSession> user=currentuserRepo.findById(key.substring(0,10));
		
		if(user.isEmpty()) {
			
			if(!user.get().getUuid().equals(key)){
				throw new AccountException("Invalid Key");
			}
			
			throw new AccountException("Invalid Key");
		}
		
		return buyerRepo.findById(user.get().getCustomerId()).get();
	}

	@Override
	public SuccessMessage buyerLogout(String key) throws AccountException {
		
		if(isBuyerLoggedIn(key)!=null) {
			
			currentuserRepo.deleteById(key.substring(0,10));
			SuccessMessage msg = new SuccessMessage();
			msg.setMessage("Logged Out Successfully");
			msg.setDateAndTime(LocalDateTime.now());
			return msg;
			
		}
		
		throw new AccountException("Invalid Key");
	}
	
	@Override
	public List<Product> getAllProducts(String key) throws AccountException{
		isBuyerLoggedIn(key);
		return productRepo.findAll();
	}
	
	
	
	

	
}
