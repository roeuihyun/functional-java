package com.functional.java.provider;

import com.functional.java.model.BuilderUser;

public class MakeMoreFriendEmailProvider implements EmailProvider{

	@Override
	public String getEmail(BuilderUser builderUser) {
		return "Make More Friends email for : " + builderUser.getName();
	}

}
