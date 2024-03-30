package com.functional.java.service;

import com.functional.java.model.BuilderUser;

public abstract class AbstractUserService {
	
	protected abstract boolean validateUser(BuilderUser builderUser);
	
	protected abstract void writeToDB(BuilderUser builderUser);
	
	public void createUser(BuilderUser builderUser) {
		
		if(validateUser(builderUser)) {
			writeToDB(builderUser);
		}else {
			System.out.println("Cannot Create User");
		}
		
	}

}
