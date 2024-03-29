package com.functional.java;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import com.functional.java.model.Order;
import com.functional.java.model.OrderLine;
import com.functional.java.processor.OrderLineAggregationPriceProcessor;
import com.functional.java.processor.TaxPriceProcessor;

public class ApplyingFunctionalProgramming3 {
	
	public static void main(String[] args) {
		
		Function<Integer, Integer> multiplyByTwo = x -> 2 * x;
		Function<Integer, Integer> addTen = x -> x + 10;
		
		Function<Integer,Integer> composedFunction = multiplyByTwo.andThen(addTen);
		System.out.println("comp osedFunction.apply(3) : " + composedFunction.apply(3));
		
		Order upprocessedOrder = new Order()
				.setId(1001L)
				.setOrderLines(Arrays.asList(
						new OrderLine().setAmount(BigDecimal.valueOf(1000)),
						new OrderLine().setAmount(BigDecimal.valueOf(2000))
						));
		
		List<Function<Order,Order>> priceProcessors = getPriceProcessors(upprocessedOrder);
		
		Function<Order,Order> mergedPriceProcessors = priceProcessors.stream()
				.reduce( (x,y) -> x.andThen(y))
				.get()
				;
		System.out.println("mergedPriceProcessors.apply(upprocessedOrder) : " + mergedPriceProcessors.apply(upprocessedOrder));
		
	}
	
	public static List<Function<Order,Order>> getPriceProcessors(Order order){
		return Arrays.asList(
				new OrderLineAggregationPriceProcessor(),
				new TaxPriceProcessor(new BigDecimal(9.375))
				);
	}

}
