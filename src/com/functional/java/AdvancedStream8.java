package com.functional.java;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.functional.java.model.User;
import com.functional.java.service.EmailService;

public class AdvancedStream8 {
	
	public static void main(String[] args) {
		
		List<Integer> numbers = Arrays.asList(13, 2, 101, 203, 304, 402, 305, 349, 2312, 203);
		Map<Boolean, List<Integer>> oddOrEven = numbers.stream()
				.collect(Collectors.partitioningBy( x -> x % 2 == 0));
		System.out.println("oddOrEven : " + oddOrEven);
		System.out.println("oddOrEven.get(true) : " + oddOrEven.get(true));
		System.out.println("oddOrEven.get(false) : " + oddOrEven.get(false));
		
		User user1 = new User()
				.setId(101)
				.setName("Alice")
				.setEmailAddress("alice@fastcampus.co.kr")
				.setFriendUserId(Arrays.asList(201, 202, 203, 204, 211, 212, 213, 214));
		
		User user2 = new User()
				.setId(102)
				.setName("Bob")
				.setEmailAddress("bob@fastcampus.co.kr")
				.setFriendUserId(Arrays.asList(204, 205, 206));
		
		User user3 = new User()
				.setId(103)
				.setName("Charlie")
				.setEmailAddress("charlie@fastcampus.co.kr")
				.setFriendUserId(Arrays.asList(204, 205, 207, 218));
		List<User> users = Arrays.asList(user1, user2, user3);
		Map<Boolean, List<User>> userPartition = users.stream()
				.collect(Collectors.partitioningBy( u -> u.getFriendUserId().size() > 5 ));
		System.out.println("userPartition : " + userPartition);
		System.out.println("userPartition.get(true) : " + userPartition.get(true));
		System.out.println("userPartition.get(false) : " + userPartition.get(false));
		
		
		userPartition.get(true).stream().forEach(u -> {
			EmailService emailService = new EmailService();
			emailService.sendPlayWithFriendsEmail(u);
		});
		userPartition.get(false).stream().forEach(u -> {
			EmailService emailService = new EmailService();
			emailService.sendMakeMoreFriendsEmail(u);
		});
		
	}

}
