package com.functional.java;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.functional.java.model.Order;
import com.functional.java.model.Order.OrderStatus;

public class AdvancedStream7 {
	
	public static void main(String[] args) {
		
		List<Integer> numbers = Arrays.asList(13, 2, 101, 203, 304, 402, 305, 349, 2312, 203);
		Map<Integer,List<Integer>> unitDigiMap = numbers.stream()
				.collect(Collectors.groupingBy(number -> number % 10));
		System.out.println("unitDigiMap : " + unitDigiMap);
		
		Map<Integer,Set<Integer>> unitDigiSet = numbers.stream()
				.collect(Collectors.groupingBy(number -> number % 10,Collectors.toSet()));
		System.out.println("unitDigiSet : " + unitDigiSet);
		
		Map<Integer, List<String>> unitDigitStr = numbers.stream()
				.collect(Collectors.groupingBy(number -> number%10, Collectors.mapping(number -> "unit digit is : " + number, Collectors.toList())));
		System.out.println("unitDigitStr : " + unitDigitStr);
		System.out.println("unitDigitStr.get(3) : " + unitDigitStr.get(3));
		
		Order order1 = new Order()
				.setId(1001L)
				.setAmount(BigDecimal.valueOf(2000))
				.setStatus(OrderStatus.CREATED);
		Order order2 = new Order()
				.setId(1002)
				.setAmount(BigDecimal.valueOf(4000))
				.setStatus(OrderStatus.ERROR);
		Order order3 = new Order()
				.setId(1003)
				.setAmount(BigDecimal.valueOf(3000))
				.setStatus(OrderStatus.ERROR);
		Order order4 = new Order()
				.setId(1004)
				.setAmount(BigDecimal.valueOf(7000))
				.setStatus(OrderStatus.PROCESSED);
		List<Order> orders = Arrays.asList(order1, order2, order3, order4);
		
		Map<OrderStatus,List<Order>> orderStatusMap = orders.stream()
				.collect(Collectors.groupingBy(order -> order.getStatus()));
		System.out.println("orderStatusMap : " + orderStatusMap);
		
		Map<OrderStatus,BigDecimal> orderStatusToSumOfAmountMap = orders.stream()
				.collect(
						Collectors.groupingBy(
								Order::getStatus,
								Collectors.mapping(Order::getAmount, 
											Collectors.reducing(BigDecimal.ZERO, BigDecimal::add)
											)
							)
						);
		System.out.println("orderStatusToSumOfAmountMap : " + orderStatusToSumOfAmountMap);
		
	}

}
