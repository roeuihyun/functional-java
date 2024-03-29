package com.functional.java.service;

import com.functional.java.model.User;

public class EmailService {
	
	public void sendPlayWithFriendsEmail(User user) {
		System.out.println("Sending Play With Friends email to : " + user.getEmailAddress());
	}
	
	public void sendMakeMoreFriendsEmail(User user) {
		System.out.println("Please Make More Friends email to : " + user.getEmailAddress());
	}

}
