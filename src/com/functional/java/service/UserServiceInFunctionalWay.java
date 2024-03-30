package com.functional.java.service;

import java.util.function.Consumer;
import java.util.function.Predicate;

import com.functional.java.model.BuilderUser;

public class UserServiceInFunctionalWay {
	
	private final Predicate<BuilderUser> validateUser;
	private final Consumer<BuilderUser> writeDB;
	
	public UserServiceInFunctionalWay(Predicate<BuilderUser> validateUser, Consumer<BuilderUser> writeDB) {
		this.validateUser = validateUser;
		this.writeDB = writeDB;
	}
	
	public void createUser(BuilderUser builderUser) {
		if(validateUser.test(builderUser)) {
			writeDB.accept(builderUser);
		}else {
			System.out.println("Cannot Create User");
		}
	}
	
	
}
