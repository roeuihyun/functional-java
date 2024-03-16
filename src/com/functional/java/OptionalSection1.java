package com.functional.java;

import java.util.Optional;

import com.functional.java.model.User;

public class OptionalSection1 {
	
	public static void main(String[] args) {
		
		User user1 = new User()
				.setId(101)
				.setName("Alice")
//				.setEmailAddress("alice@gmail.com")
				.setVerified(true)
				;

		User user2 = new User()
				.setId(101)
				.setName("Alice")
				.setEmailAddress("alice@gmail.com")
				.setVerified(true)
				;
//		System.out.println(userEquals(user1, user2));
		
		String someEmail = "some@email.com";
		String defaultEmail = "default@email.com";
		String nullEmail = null;
		
		Optional<String> maybeEmail1 = Optional.of(someEmail);
		Optional<String> maybeEmail2 = Optional.empty();
		Optional<String> maybeEmail3 = Optional.ofNullable(someEmail);
		Optional<String> maybeEmail4 = Optional.ofNullable(nullEmail);
		
		String email1 = maybeEmail1.get();
		System.out.println("email1 : " + email1);
		
		String email2 = maybeEmail2.isPresent()? maybeEmail2.get():maybeEmail2.orElse(defaultEmail);
		System.out.println("email2 : " + email2);
		
		String email3 = maybeEmail3.get();
		System.out.println("email3 : " + email3);
		
		String email4 = maybeEmail4.orElseGet( ()-> defaultEmail );
		System.out.println("email4 : " + email4);
		
		String email5 = maybeEmail4.orElseThrow(()-> new RuntimeException("11111111111111"));
		System.out.println("email5 : " + email5);
		
	}
	
	public static boolean userEquals (User u1, User u2) {
		return u1.getId() == u2.getId() 
				&& u1.getName().equals(u2.getName()) 
				&& u1.getEmailAddress().equals(u2.getEmailAddress()) 
				&& u1.isVerified() == u2.isVerified()
				;
	}

}
