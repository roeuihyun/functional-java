package com.functional.java.service;

import com.functional.java.model.Price;

@FunctionalInterface
public interface PriceService {
	
	Price process(Price price);
	
	default PriceService andThen(PriceService next) {
		return price -> next.process(process(price));
	}

}
