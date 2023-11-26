package com.functional.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.functional.java.model.User;

public class ComparatorSection1 {

	public static void main(String[] args) {
		
		List<User> users = new ArrayList<User>();
		users.add(new User(5,"Alice"));
		users.add(new User(3,"Rachel"));
		users.add(new User(1,"Charlie"));
		users.add(new User(7,"Bob"));
		System.out.println(users);
		
		Comparator<User> idComparator = (u1,u2)-> u1.getId() - u2.getId();
		Collections.sort(users,idComparator);
		System.out.println(users);
		
		Collections.sort(users,(u1,u2)->u1.getName().compareTo(u2.getName()));
		
	}

}
