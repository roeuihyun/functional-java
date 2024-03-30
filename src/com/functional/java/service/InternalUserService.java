package com.functional.java.service;

import com.functional.java.model.BuilderUser;

public class InternalUserService extends AbstractUserService{

	@Override
	protected boolean validateUser(BuilderUser builderUser) {
		
		System.out.println("Validating Internal User : " + builderUser.getName());
		return true;
		
	}

	@Override
	protected void writeToDB(BuilderUser builderUser) {
		
		System.out.println("Writing user : " + builderUser.getName() + " to Internal DB");
		
	}

}
