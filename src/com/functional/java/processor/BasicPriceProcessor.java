package com.functional.java.processor;

import com.functional.java.model.Price;
import com.functional.java.service.PriceService;

public class BasicPriceProcessor implements PriceService{

	@Override
	public Price process(Price price) {
		return price;
	}

}
