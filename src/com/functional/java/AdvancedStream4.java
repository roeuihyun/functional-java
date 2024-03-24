package com.functional.java;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import com.functional.java.model.Order;
import com.functional.java.model.Order.OrderStatus;
import com.functional.java.model.OrderLine;
import com.functional.java.model.User;

public class AdvancedStream4 {
	
	public static void main(String[] args) {
		
		// Max, Min, Count 도 사실 reduce의 일종
		List<Integer> numbers = Arrays.asList(1, 4, -2, -5, 3);
		int sum = numbers.stream()
					.reduce( (x,y) -> x + y)
					.get();
		System.out.println("sum : " + sum);
		
		int min = numbers.stream()
				.reduce( (x,y) -> x < y ? x : y )
				.get();
		System.out.println("min : " + min);
		
		int product = numbers.stream()
				.reduce(1, (x,y) -> x * y);
		System.out.println("product : " + product);
		
		int max = numbers.stream()
				.reduce( (x,y) -> x > y ? x : y )
				.get();
		System.out.println("max : " + max);
		
		List<String> numberStrList = Arrays.asList("3", "2", "5", "-4");
		int sumOfNumberList = numberStrList.stream()
				.map( x -> Integer.parseInt(x))
				.reduce(0, (x,y) -> x + y)
				;
		System.out.println("sumOfNumberList : " + sumOfNumberList);
		
		int sumOfNumberList2 = numberStrList.stream()
				.reduce(0, (number,str) -> number + Integer.parseInt(str), (num1,num2) -> num1 + num2)
				;
		System.out.println("sumOfNumberList2 : " + sumOfNumberList2);
		
		User user1 = new User()
				.setId(101)
				.setName("Alice")
				.setFriendUserId(Arrays.asList(201, 202, 203, 204));
		
		User user2 = new User()
				.setId(102)
				.setName("Bob")
				.setFriendUserId(Arrays.asList(204, 205, 206));
		
		User user3 = new User()
				.setId(103)
				.setName("Charlie")
				.setFriendUserId(Arrays.asList(204, 205, 207));
		List<User> users = Arrays.asList(user1, user2, user3);
		int sumOfNumberOfFriends1 = users.stream()
				.map(user -> user.getFriendUserId())
				.map(List::size)
				.reduce(0, (x,y) -> x + y);
		System.out.println("sumOfNumberOfFriends1 : " + sumOfNumberOfFriends1);
		
		long sumOfNumberOfFriends2 = users.stream()
				.map(user -> user.getFriendUserId())
				.flatMap(userFriends -> userFriends.stream())
				.count();
		System.out.println("sumOfNumberOfFriends2 : " + sumOfNumberOfFriends2);
		
		Order order1 = new Order()
				.setId(1001L)
				.setAmount(BigDecimal.valueOf(2000))
				.setStatus(OrderStatus.CREATED)
				.setOrderLines(Arrays.asList(
						new OrderLine()
							.setAmount(BigDecimal.valueOf(1000))
						,new OrderLine()
						.setAmount(BigDecimal.valueOf(2000))
						));
		Order order2 = new Order()
				.setId(1002)
				.setAmount(BigDecimal.valueOf(4000))
				.setStatus(OrderStatus.ERROR)
				.setOrderLines(Arrays.asList(
						new OrderLine()
							.setAmount(BigDecimal.valueOf(2000))
						,new OrderLine()
						.setAmount(BigDecimal.valueOf(3000))
						));
		Order order3 = new Order()
				.setId(1003)
				.setAmount(BigDecimal.valueOf(3000))
				.setStatus(OrderStatus.ERROR)
				.setOrderLines(Arrays.asList(
						new OrderLine()
							.setAmount(BigDecimal.valueOf(1000))
						,new OrderLine()
						.setAmount(BigDecimal.valueOf(2000))
						));
		List<Order> orders = Arrays.asList(order1, order2, order3);
		
		BigDecimal theSumOfAmounts = orders.stream()
				.map( order -> order.getOrderLines())
				.flatMap(orderList -> orderList.stream())
				.map( orderLine -> orderLine.getAmount())
				.reduce(BigDecimal.ZERO,(x,y) -> x.add( y));
		System.out.println("theSumOfAmounts : " + theSumOfAmounts);
		
	}

}
