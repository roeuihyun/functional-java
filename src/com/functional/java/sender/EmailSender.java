package com.functional.java.sender;

import com.functional.java.model.BuilderUser;
import com.functional.java.provider.EmailProvider;

public class EmailSender {
	
	private EmailProvider emailProvider;
	
	public EmailSender setEmailProvider(EmailProvider emailProvider) {
		this.emailProvider = emailProvider;
		return this;
	}
	
	public void sendEmail(BuilderUser builderUser) {
		String email = emailProvider.getEmail(builderUser);
		System.out.println("Sending email : " + email);
	}

}
