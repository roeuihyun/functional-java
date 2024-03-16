package com.functional.java;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import com.functional.java.model.Order;
import com.functional.java.model.OrderLine;
import com.functional.java.model.OrderLine.OrderLineType;

public class StreamSection7 {
	
	public static void main(String[] args) {
		
		String[][] cities = new String[][] {
			{"Seoul","Busan"},
			{"San Francisco","New York"},
			{"Madrid","Barcelona"}
		};
		System.out.println( cities );
		
		Stream<String[]> cityStream = Arrays.stream(cities);
		Stream<Stream<String>> cityStreamStream = cityStream.map(x-> Arrays.stream(x));
		List<Stream<String>> cityStreamList = cityStreamStream.collect(Collectors.toList());
		
		Stream<String[]> cityStream2 = Arrays.stream(cities);
		Stream<String> flattenedCityStream = cityStream2.flatMap(x->Arrays.stream(x));
		List<String> flattenedCityList = flattenedCityStream.collect(Collectors.toList());
		System.out.println(flattenedCityList);
		
		Order order1 = new Order()
				.setId(1001)
				.setOrderLines(Arrays.asList(
						new OrderLine()
						.setId(10001)
						.setType(OrderLineType.PURCHASE)
						.setAmount(BigDecimal.valueOf(5000)),
						new OrderLine()
						.setId(10002)
						.setType(OrderLineType.PURCHASE)
						.setAmount(BigDecimal.valueOf(4000))
						));
		
		Order order2 = new Order()
				.setId(1002)
				.setOrderLines(Arrays.asList(
						new OrderLine()
						.setId(10003)
						.setType(OrderLineType.PURCHASE)
						.setAmount(BigDecimal.valueOf(2000)),
						new OrderLine()
						.setId(10004)
						.setType(OrderLineType.DISCOUNT)
						.setAmount(BigDecimal.valueOf(-1000))
						));
		
		Order order3 = new Order()
				.setId(1003)
				.setOrderLines(Arrays.asList(
						new OrderLine()
						.setId(10005)
						.setType(OrderLineType.PURCHASE)
						.setAmount(BigDecimal.valueOf(2000))
						));
		
		List<Order> orders = Arrays.asList(order1,order2,order3);
		List<OrderLine> mergedOrderLines = orders.stream()
				.map(Order::getOrderLines)
				.flatMap(x-> x.stream())
				.collect(Collectors.toList());
		System.out.println(mergedOrderLines);
		
		
	}
}
