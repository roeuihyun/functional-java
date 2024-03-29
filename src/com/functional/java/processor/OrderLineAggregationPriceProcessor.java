package com.functional.java.processor;

import java.util.function.Function;

import com.functional.java.model.Order;

public class OrderLineAggregationPriceProcessor implements Function<Order, Order> {

	@Override
	public Order apply(Order order) {
		return order.setAmount(
				order.getOrderLines().stream().map(orderLine -> orderLine.getAmount()).reduce((x,y) -> x.add(y)).get()
				);
	}

}
