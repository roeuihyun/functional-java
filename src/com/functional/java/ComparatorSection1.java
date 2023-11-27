package com.functional.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.functional.java.model.OldUser;

public class ComparatorSection1 {

	public static void main(String[] args) {
		
		List<OldUser> users = new ArrayList<OldUser>();
		users.add(new OldUser(5,"Alice"));
		users.add(new OldUser(3,"Rachel"));
		users.add(new OldUser(1,"Charlie"));
		users.add(new OldUser(7,"Bob"));
		System.out.println(users);
		
		Comparator<OldUser> idComparator = (u1,u2)-> u1.getId() - u2.getId();
		Collections.sort(users,idComparator);
		System.out.println(users);
		
		Collections.sort(users,(u1,u2)->u1.getName().compareTo(u2.getName()));
		
	}

}
