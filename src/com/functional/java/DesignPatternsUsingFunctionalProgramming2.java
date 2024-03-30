package com.functional.java;

import com.functional.java.model.BuilderUser;

public class DesignPatternsUsingFunctionalProgramming2 {
	
	// 생성 패턴 (Creational Patterns) - 오브젝트의 생성에 관련된 패턴
	// 구조 패턴 (Strutural Patterns) - 상속을 이용해 클래스/오브젝트를 조합하여 더 발전된 구조로 만드는 패턴
	// 행동 패턴 (Behavioral Patterns) - 필요한 작업을 여러 객체를 분해하여 객체간 결합도를 줄이게 해주는 패턴
	
	// Builder Pattern
	public static void main(String[] args) {
		
//		BuilderUser user = BuilderUser.builder(101, "alice")
//							.withEmailAddress("alice@fastcampus.co.kr")
//							.withVerified(true)
//							.build();
//		System.out.println("user : " + user);
		
		BuilderUser user = BuilderUser.builder(101, "alice")
				.with(builder ->{
					builder.emailAddress = "alice@fastcampus.co.kr";
					builder.isVerified = true;
				})
				.build();
		System.out.println("user : " + user);
	}

}
