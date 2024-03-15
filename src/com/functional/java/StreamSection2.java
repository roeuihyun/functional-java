package com.functional.java;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.functional.java.model.Order;
import com.functional.java.model.Order.OrderStatus;
import com.functional.java.model.User;

public class StreamSection2 {

	public static void main(String[] args) {
		
		// 만족하는 데이터만 걸러내는데 사용
		// predicate 를 통해서 true 를 반환하는 데이터만 stream 으로 return
		// Stream<T> filter(Predicate<? super T> predicate);
		Stream<Integer> numberStream = Stream.of(-9,-7,-5,-3,-1,0,1,3,5,7,9);
		Stream<Integer> filteredNumberStream = numberStream.filter(x -> x > 0);
		List<Integer> filteredNumberList = filteredNumberStream.collect(Collectors.toList());
		System.out.println(filteredNumberList);
		
//		Stream<Integer> newNumberStream = Stream.of(-9,-7,-5,-3,-1,0,1,3,5,7,9).filter(x -> x > 0);
		List<Integer> newFilteredNumberList = Stream.of(-9,-7,-5,-3,-1,0,1,3,5,7,9)
													.filter(x -> x >= 0)
													.collect(Collectors.toList());
		System.out.println(newFilteredNumberList);
		
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
		List<User> verifiedUsers = users.stream()
			.filter(User::isVerified)
			.collect(Collectors.toList());
		System.out.println(verifiedUsers);
		
		List<User> unverifiedUsers = users.stream()
				.filter(user -> !user.isVerified())
				.collect(Collectors.toList());
		System.out.println(unverifiedUsers);
		
		Order order1 = new Order()
				.setId(1001)
				.setStatus(OrderStatus.CREATED);
		Order order2 = new Order()
				.setId(1002)
				.setStatus(OrderStatus.ERROR);
		Order order3 = new Order()
				.setId(1003)
				.setStatus(OrderStatus.PROCESSED);
		Order order4 = new Order()
				.setId(1004)
				.setStatus(OrderStatus.ERROR);
		Order order5 = new Order()
				.setId(1005)
				.setStatus(OrderStatus.IN_PROGRESS);
		
		List<Order> orders = Arrays.asList(order1, order2, order3, order4, order5);
		List<Order> filteredOrders = orders.stream()
											.filter(x->x.getStatus() == OrderStatus.ERROR)
											.collect(Collectors.toList());
		System.out.println(filteredOrders);
	}

}