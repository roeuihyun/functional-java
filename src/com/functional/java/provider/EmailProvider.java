package com.functional.java.provider;

import com.functional.java.model.BuilderUser;

public interface EmailProvider {

	String getEmail(BuilderUser builderUser);
	
}
