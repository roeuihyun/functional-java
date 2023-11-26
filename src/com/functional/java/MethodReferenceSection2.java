package com.functional.java;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;

import com.functional.java.model.User;

public class MethodReferenceSection2 {

	public static void main(String[] args) {
		// 1. ClassName::staticMethodName
		// 클래스의 static method를 지정할 때
		// 2. objectName::instanceMethodName
		// 선언된 객체의 instance method를 지정할 때
		// 3. ClassName::instanceMethodName
		// 객체의 instance method를 지정할 때
		// 4. ClassName::new
		// 클래스의 constructor를 지정할 때
		
		// 3. ClassName::instanceMethodName
		// 객체의 instance method를 지정할 때
		// 해당 클래스의 인스턴스를 매개변수(parameter)로 넘겨 메서드를 실행해주는 함
		Function<String,Integer> strLength = String::length;
		System.out.println("strLength.apply(\"hello world\") : " + strLength.apply("hello world"));
		
		// 3. ClassName::instanceMethodName
		// 객체의 instance method를 지정할 때
		// 해당 클래스의 인스턴스를 매개변수(parameter)로 넘겨 메서드를 실행해주는 함
		BiPredicate<String,String> strEquals = String::equals;
		System.out.println("strEquals.test(\"hello\", \"world\") : " + strEquals.test("hello", "world"));
		
		List<User> users = new ArrayList<User>();
		users.add(new User(5,"Alice"));
		users.add(new User(3,"Rachel"));
		users.add(new User(1,"Charlie"));
		users.add(new User(7,"Bob"));
		
		Function<User,Object> getterId = User::getId;
		printUserField(users,getterId);
		
		Function<User,Object> getterName = User::getName;
		printUserField(users,getterName);

	}
	
	private static void printUserField(List<User> users, Function<User,Object> getter) {
		for(User user : users) {
			System.out.println("getter.apply(user) : " + getter.apply(user));
		}
	}

}
