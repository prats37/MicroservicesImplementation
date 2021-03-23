package com.wipro.price.controller;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.price.entity.Price;
import com.wipro.price.service.PriceService;
import com.wipro.price.utility.CustomError;

@RestController
@RefreshScope
@RequestMapping("/price")
public class PriceController {
	@Autowired
	PriceService priceService;
	
	@PostMapping("/add")
	public ResponseEntity<?> addPrice(@Valid @RequestBody Price price){
		ResponseEntity<?> response=new ResponseEntity(
				new CustomError("Unable to add price")+price.toString(), HttpStatus.CONFLICT);
		if(price!=null) {
			Price addedPrice=priceService.addPrice(price);
			response=new ResponseEntity<>(addedPrice,HttpStatus.CREATED);		
		}else {
			response=new ResponseEntity<>("Price should not be null",HttpStatus.BAD_REQUEST);
		}	
		return response;
	}
	
	@PostMapping("/view")
	public ResponseEntity<?> viewPrice(@Valid @RequestBody Price price){
		ResponseEntity<?> response=new ResponseEntity(
				new CustomError("Unable to view price")+price.toString(), HttpStatus.CONFLICT);
		if(price!=null) {
			Price fetchedPrice=priceService.viewPrice(price);
			if(fetchedPrice!=null) {
				response=new ResponseEntity<>(fetchedPrice,HttpStatus.OK);
			}else {
				response=new ResponseEntity<>("Product not found with given ID",HttpStatus.BAD_REQUEST);
			}
					
		}else {
			response=new ResponseEntity<>("Price should not be null",HttpStatus.BAD_REQUEST);
		}	
		return response;
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> updatePrice(@Valid @RequestBody Price price){
		ResponseEntity<?> response=new ResponseEntity(
				new CustomError("Unable to update price")+price.toString(), HttpStatus.CONFLICT);
		if(price!=null) {
			Price updatedPrice=priceService.updatePrice(price);
			response=new ResponseEntity<>(updatedPrice,HttpStatus.CREATED);		
		}else {
			response=new ResponseEntity<>("Price should not be null",HttpStatus.BAD_REQUEST);
		}	
		return response;
	}
	
	@PostMapping("/delete")
	public ResponseEntity<?> deletePrice(@Valid @RequestBody Price price){
		ResponseEntity<?> response=new ResponseEntity(
				new CustomError("Unable to delete price ")+price.toString(), HttpStatus.CONFLICT);
		if(price!=null) {
			boolean status=priceService.deletePrice(price);
			if(status) {
				response=new ResponseEntity<>("Price deleted successfully",HttpStatus.OK);
			}else {
				response=new ResponseEntity<>("Price deletion failed",HttpStatus.BAD_REQUEST);
			}		
		}else {
			response=new ResponseEntity<>("Price should not be null",HttpStatus.BAD_REQUEST);
		}	
		return response;
	}

}