package com.functional.java;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import com.functional.java.model.Order;
import com.functional.java.model.User;
import com.functional.java.model.Order.OrderStatus;

public class AdvancedStream2 {
	
	public static void main(String[] args) {
		
		List<Integer> numbers = Arrays.asList(3, -4, 2, 7, 9);
		boolean allPostive = numbers.stream()
				.allMatch( x -> x > 0);
		System.out.println("allPostive : " + allPostive);

		boolean anyNegative = numbers.stream()
				.anyMatch( x -> x < 0);
		System.out.println("anyNegative : " + anyNegative);
		
		boolean anyPostive = numbers.stream()
				.anyMatch( x -> x > 0);
		System.out.println("anyPostive : " + anyPostive);
		
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
		
		boolean arrAllUserVerified = users.stream()
				.allMatch(user -> user.isVerified());
		System.out.println("arrAllUserVerified : " + arrAllUserVerified);
		
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
		
		boolean isAnyOrderInErrorStatus = orders.stream()
				.anyMatch(order -> OrderStatus.ERROR.equals(order.getStatus()) );
		System.out.println("isAnyOrderInErrorStatus : " + isAnyOrderInErrorStatus);
		
	}

}
