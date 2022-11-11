package com.AcmeFresh.Repositery;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.AcmeFresh.models.Growers;
@Repository
public interface GrowerRepositery extends JpaRepository<Growers, Integer>{

	public Optional<Growers> findByMobileNumber(String mobileNumber);
}
