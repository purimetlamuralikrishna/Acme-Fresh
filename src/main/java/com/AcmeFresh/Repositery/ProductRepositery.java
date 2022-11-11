package com.AcmeFresh.Repositery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AcmeFresh.models.Product;
@Repository
public interface ProductRepositery extends JpaRepository<Product,String> {

}
