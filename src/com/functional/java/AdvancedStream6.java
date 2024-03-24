package com.functional.java;


import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.functional.java.model.Order;
import com.functional.java.model.Order.OrderStatus;
import com.functional.java.model.User;

public class AdvancedStream6 {
	
	public static void main(String[] args) {
		
		Map<Integer,String> numberMap = Stream.of(3, 5, -4, 2, 6)
				.collect(
						Collectors.toMap(
						key -> key 
						, value -> "Number is : " +  value)
						);
		System.out.println("numberMap : " + numberMap);
		
		Map<Integer,String> numberMap2 = Stream.of(3, 5, -4, 2, 6)
				.collect(
						Collectors.toMap(
						Function.identity() 
						, value -> "Number is : " +  value)
						);
		System.out.println("numberMap2 : " + numberMap2);
		
		User user1 = new User()
				.setId(101)
				.setName("Alice")
				.setVerified(true)
				.setEmailAddress("alice@fastcampus.co.kr");
		User user2 = new User()
				.setId(102)
				.setName("Bob")
				.setVerified(false)
				.setEmailAddress("bob@fastcampus.co.kr");
		User user3 = new User()
				.setId(103)
				.setName("Charlie")
				.setVerified(true)
				.setEmailAddress("charlie@fastcampus.co.kr");
		
		List<User> users = Arrays.asList(user1, user2, user3);
		
		Map<Integer, User> userIdToUserMap = users.stream()
				.collect(
						Collectors.toMap(
								User::getId, 
								eachUser -> eachUser
								)
						);
		System.out.println("userIdToUserMap : " + userIdToUserMap);
		
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
		
		Map<Long,Order> orderIdToOrderMap = orders.stream()
				.collect(
						Collectors.toMap(
								Order::getId
								, o -> o
								)
						);
				
		System.out.println("orderIdToOrderMap : " + orderIdToOrderMap);
		
		
		Map<Long,OrderStatus> orderIdToOrderStatusMap = orders.stream()
				.collect(
						Collectors.toMap(
								Order::getId
								, o -> o.getStatus()
								)
						);
				
		System.out.println("orderIdToOrderStatusMap : " + orderIdToOrderStatusMap);
	}

}
