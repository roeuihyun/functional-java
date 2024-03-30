package com.functional.java;

import java.util.Arrays;
import java.util.List;

import com.functional.java.model.BuilderUser;
import com.functional.java.provider.EmailProvider;
import com.functional.java.provider.MakeMoreFriendEmailProvider;
import com.functional.java.provider.VerifyYourEmailAddressEmailProvider;
import com.functional.java.sender.EmailSender;

public class DesignPatternsUsingFunctionalProgramming4 {
	
	// 생성 패턴 (Creational Patterns) - 오브젝트의 생성에 관련된 패턴
	// 구조 패턴 (Strutural Patterns) - 상속을 이용해 클래스/오브젝트를 조합하여 더 발전된 구조로 만드는 패턴
	// 행동 패턴 (Behavioral Patterns) - 필요한 작업을 여러 객체를 분해하여 객체간 결합도를 줄이게 해주는 패턴
	
	// Strategy Pattern
	public static void main(String[] args) {
		
		BuilderUser user1 = BuilderUser.builder(101, "Alice")
				.with(builder ->{
					builder.emailAddress = "alice@fastcampus.co.kr";
					builder.isVerified = false;
					builder.friendUserId = Arrays.asList(201, 202, 203, 204, 211, 212, 213, 214);
				})
				.build();
		
		BuilderUser user2 = BuilderUser.builder(102, "Bob")
				.with(builder ->{
					builder.emailAddress = "bob@fastcampus.co.kr";
					builder.isVerified = true;
					builder.friendUserId = Arrays.asList(212, 213, 214);
				})
				.build();
		
		BuilderUser user3 = BuilderUser.builder(103, "Charlie")
				.with(builder ->{
					builder.emailAddress = "charlie@fastcampus.co.kr";
					builder.isVerified = true;
					builder.friendUserId = Arrays.asList(201, 202, 203, 204, 211, 212);
				})
				.build();
		
		List<BuilderUser> users = Arrays.asList(user1, user2, user3);
		EmailSender emailSender = new EmailSender();
		EmailProvider verifyYourEmailAddressEmailProvider = new VerifyYourEmailAddressEmailProvider();
		EmailProvider makeMoreFriendEmailProvider = new MakeMoreFriendEmailProvider();
		
		emailSender.setEmailProvider(verifyYourEmailAddressEmailProvider);
		users.stream()
			.filter( user -> !user.isVerified())
			.forEach(user -> emailSender.sendEmail(user));
		
		emailSender.setEmailProvider(makeMoreFriendEmailProvider);
		users.stream()
			.filter( user -> user.getFriendUserId().size() < 5)
			.forEach(user -> emailSender.sendEmail(user));
		
		emailSender.setEmailProvider( builderUser -> "Play With Friends email for : " + builderUser.getName());
		users.stream()
		.filter( user -> user.getFriendUserId().size() > 5)
		.forEach(user -> emailSender.sendEmail(user));
		
	}

}
