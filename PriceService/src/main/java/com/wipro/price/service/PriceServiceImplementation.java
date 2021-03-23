package com.wipro.price.service;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.price.dao.PriceRepository;
import com.wipro.price.entity.Price;

@Service
public class PriceServiceImplementation implements PriceService{
	
	@Autowired
	PriceRepository priceRepo;

	@Override
	public Price addPrice(@Valid Price price) {
		Price savedPrice=priceRepo.save(price);
		return savedPrice;
	}

	@Override
	public Price viewPrice(@Valid Price price) {
		Optional<Price> fetchedPriceObj=priceRepo.findById(price.getProductId());
		Price outputPrice=new Price();
		if(fetchedPriceObj.isEmpty()) {
			return null;
		}else {
			outputPrice.setProductId(price.getProductId());
			outputPrice.setProductPrice(fetchedPriceObj.get().getProductPrice());
			return outputPrice;
		}
	}

	@Override
	public Price updatePrice(@Valid Price price) {
		Optional<Price> fetchedPriceObj=priceRepo.findById(price.getProductId());
		Price outputPriceObj=new Price();
		if(fetchedPriceObj.isEmpty()) {
			return null;
		}else {
			fetchedPriceObj.get().setProductPrice(price.getProductPrice());
			outputPriceObj=priceRepo.save(fetchedPriceObj.get());
			return outputPriceObj;
		}
	}

	@Override
	public boolean deletePrice(@Valid Price price) {
		boolean status=false;
		Optional<Price> fetchedPriceObj=priceRepo.findById(price.getProductId());
		if(fetchedPriceObj.isEmpty()) {
			status=false;
		}else {
			priceRepo.delete(price);
			status=true;
		}
		return status;
	}
	
}
