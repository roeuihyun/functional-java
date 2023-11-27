package com.functional.java;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;

import com.functional.java.model.OldUser;

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
		
		List<OldUser> OldUsers = new ArrayList<OldUser>();
		OldUsers.add(new OldUser(5,"Alice"));
		OldUsers.add(new OldUser(3,"Rachel"));
		OldUsers.add(new OldUser(1,"Charlie"));
		OldUsers.add(new OldUser(7,"Bob"));
		
		Function<OldUser,Object> getterId = OldUser::getId;
		printOldUserField(OldUsers,getterId);
		
		Function<OldUser,Object> getterName = OldUser::getName;
		printOldUserField(OldUsers,getterName);

	}
	
	private static void printOldUserField(List<OldUser> OldUsers, Function<OldUser,Object> getter) {
		for(OldUser OldUser : OldUsers) {
			System.out.println("getter.apply(OldUser) : " + getter.apply(OldUser));
		}
	}

}
