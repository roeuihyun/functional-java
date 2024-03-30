package com.functional.java.service;

import com.functional.java.model.BuilderUser;

public class UserService extends AbstractUserService{

	@Override
	protected boolean validateUser(BuilderUser builderUser) {
		
		System.out.println("Validating User : " + builderUser.getName());
		return builderUser.getName() != null && builderUser.getEmailAddress() != null;
		
	}

	@Override
	protected void writeToDB(BuilderUser builderUser) {
		
		System.out.println("Writing user : " + builderUser.getName() + " to DB");
		
	}

}
