package com.wipro.price.service;

import java.util.Optional;

import javax.validation.Valid;

import com.wipro.price.entity.Price;

public interface PriceService {

	Price addPrice(@Valid Price price);

	Price viewPrice(@Valid Price price);

	Price updatePrice(@Valid Price price);

	boolean deletePrice(@Valid Price price);

}
