package com.AcmeFresh.Repositery;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AcmeFresh.models.Buyer;

@Repository
public interface BuyerRepositery extends JpaRepository<Buyer, Integer>{

	public Optional<Buyer> findByMobileNumber(String mobileNumber);
}
