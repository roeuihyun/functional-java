package com.functional.java;

import java.util.Optional;

import com.functional.java.model.User;

public class OptionalSection2 {
	
	public static void main(String[] args) {
	
		Optional<User> maybeUserFalse = Optional.ofNullable(maybeUser(false));
		maybeUserFalse.ifPresent(user -> System.out.println("maybeUserFalse : " + user));
		
		Optional<User> maybeUserTrue = Optional.ofNullable(maybeUser(true));
		maybeUserTrue.ifPresent(user -> System.out.println("maybeUserTrue : " + user));
		
		Optional<Integer> maybeUserIdFalse = Optional.ofNullable(maybeUser(false))
				.map(user -> user.getId());
		maybeUserIdFalse.ifPresent(id -> System.out.println("maybeUserIdFalse : " + id));
		
		Optional<Integer> maybeUserIdTrue = Optional.ofNullable(maybeUser(true))
				.map(user -> user.getId());
		maybeUserIdTrue.ifPresent(id -> System.out.println("maybeUserIdTrue : " + id));
		
		String userNameFalse = Optional.ofNullable(maybeUser(false))
				.map(User::getName)
				.map(name -> "user name is : " + name )
				.orElse("name is empty ");
		System.out.println("userNameFalse : " + userNameFalse);
		
		String userNameTrue = Optional.ofNullable(maybeUser(true))
				.map(User::getName)
				.map(name -> "user name is : " + name )
				.orElse("name is empty ");
		System.out.println("userNameTrue : " + userNameTrue);
		
		Optional<String> maybeFlatMapEmailFalse = Optional.ofNullable(maybeUser(false))
				.flatMap(User::getFlatMapEmailAddress);
		maybeFlatMapEmailFalse.ifPresent(System.out::println);
		
		Optional<String> maybeFlatMapEmailTrue = Optional.ofNullable(maybeUser(true))
				.flatMap(User::getFlatMapEmailAddress);
		maybeFlatMapEmailTrue.ifPresent(System.out::println);
		
	}
	
	public static User maybeUser(boolean returnUser) {
		if(returnUser) {
			return new User()
					.setId(101)
					.setName("Alice")
					.setEmailAddress("alice@gmail.com")
					.setVerified(true)
					.setFlatMapEmailAddress("alice@gmail.com")
					;
		}
		
		return null;
		
	}

}
