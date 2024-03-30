package com.functional.java;

import com.functional.java.model.Price;
import com.functional.java.processor.BasicPriceProcessor;
import com.functional.java.processor.DiscountPriceProcessor;
import com.functional.java.processor.TaxInfoPriceProcessor;
import com.functional.java.service.PriceService;

public class DesignPatternsUsingFunctionalProgramming3 {
	
	// 생성 패턴 (Creational Patterns) - 오브젝트의 생성에 관련된 패턴
	// 구조 패턴 (Strutural Patterns) - 상속을 이용해 클래스/오브젝트를 조합하여 더 발전된 구조로 만드는 패턴
	// 행동 패턴 (Behavioral Patterns) - 필요한 작업을 여러 객체를 분해하여 객체간 결합도를 줄이게 해주는 패턴
	
	// Decorate patterns
	public static void main(String[] args) {
		
		Price unprocessedPrice = new Price("Original Price");
		
		PriceService basicPriceProcessor = new BasicPriceProcessor();
		PriceService discountPriceProcessor = new DiscountPriceProcessor();
		PriceService taxinfoPriceProcessor = new TaxInfoPriceProcessor();
		
		PriceService decoratedDiscountPriceProcessor = basicPriceProcessor
			.andThen(discountPriceProcessor);
		Price processedPrice = decoratedDiscountPriceProcessor.process(unprocessedPrice);
		System.out.println("processedPrice : " + processedPrice.getPrice());
		
		PriceService decoratedDiscountTaxPriceProcessor = basicPriceProcessor
				.andThen(discountPriceProcessor)
				.andThen(taxinfoPriceProcessor);
		Price processedPrice2 = decoratedDiscountTaxPriceProcessor.process(unprocessedPrice);		
		System.out.println("processedPrice2 : " + processedPrice2.getPrice());
		
		PriceService decoratedAnotherPriceProcessor = basicPriceProcessor
				.andThen(taxinfoPriceProcessor)
				.andThen(price -> 
					new Price(price.getPrice() + ", then apply another processor!!") 
				);
		Price processedPrice3 = decoratedAnotherPriceProcessor.process(unprocessedPrice);		
		System.out.println("processedPrice3 : " + processedPrice3.getPrice());
		
		
	}

}
