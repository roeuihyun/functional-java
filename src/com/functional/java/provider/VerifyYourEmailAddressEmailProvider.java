package com.functional.java.provider;

import com.functional.java.model.BuilderUser;

public class VerifyYourEmailAddressEmailProvider implements EmailProvider{

	@Override
	public String getEmail(BuilderUser builderUser) {
		return "Verify Your Email Address email for " + builderUser.getName();
	}

}
