package com.functional.java;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.functional.java.model.User;
import com.functional.java.service.EmailService;

public class AdvancedStream10 {
	
	public static void main(String[] args) {
		
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
				.setVerified(false)
				.setEmailAddress("charlie@fastcampus.co.kr");
		
		User user4 = new User()
				.setId(104)
				.setName("David")
				.setVerified(true)
				.setEmailAddress("david@fastcampus.co.kr");
		
		User user5 = new User()
				.setId(105)
				.setName("Eve")
				.setVerified(false)
				.setEmailAddress("eve@fastcampus.co.kr");
		
		User user6 = new User()
				.setId(106)
				.setName("Frank")
				.setVerified(false)
				.setEmailAddress("frank@fastcampus.co.kr");
		
		List<User> users = Arrays.asList(user1, user2, user3, user4, user5, user6);
		long normalStartTime = System.currentTimeMillis();
		EmailService emailService = new EmailService();
		users.stream()
			.filter( x -> !x.isVerified())
			.forEach(emailService::sendVerifyYourEmailEmail);
		long normalEndTime = System.currentTimeMillis();
		System.out.println("normal stream using time : " + String.valueOf(normalEndTime - normalStartTime) );
		
		long parallelStartTime = System.currentTimeMillis();
		users.stream().parallel()
			.filter( x -> !x.isVerified())
			.forEach(emailService::sendVerifyYourEmailEmail);
		long parallelEndTime = System.currentTimeMillis();
		System.out.println("parallel stream using time : " + String.valueOf(parallelEndTime - parallelStartTime) );
		
		List<User> processedUsers = users.parallelStream()
				.map(user -> {
					System.out.println("Capitalize user name for user : " + user.getId());
					user.setName(user.getName().toUpperCase());
					return user;
				})
				.map(user -> {
					System.out.println("Set isVerified to true for user : " + user.getId());
					user.setVerified(true);
					return user;
				})
				.collect(Collectors.toList());
		System.out.println(processedUsers);
		
		
		
	}

}
