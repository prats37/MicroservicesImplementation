package com.wipro.price.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.price.entity.Price;

@Repository
public interface PriceRepository extends JpaRepository<Price,Integer>{
	
}
