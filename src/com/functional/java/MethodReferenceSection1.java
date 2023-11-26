package com.functional.java;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class MethodReferenceSection1 {

	public static void main(String[] args) {
		// 1. ClassName::staticMethodName
		// 클래스의 static method를 지정할 때
		// 2. objectName::instanceMethodName
		// 선언된 객체의 instance method를 지정할 때
		// 3. ClassName::instanceMethodName
		// 객체의 instance method를 지정할 때
		// 4. ClassName::new
		// 클래스의 constructor를 지정할 때
		
		int a = Integer.parseInt("15");
		System.out.println("a : " +a);
		
		// 1. ClassName::staticMethodName
		// 클래스의 static method를 지정할 때		
		Function<String,Integer> str2int = Integer::parseInt;
		System.out.println("str2int.apply(\"15\") : " + str2int.apply("15"));
		
		String str = "hello";
		boolean b = str.equals("world");
		System.out.println("b : " + b);
		
		// 2. objectName::instanceMethodName
		// 선언된 객체의 instance method를 지정할 때
		Predicate<String> equalsToHello = str::equals;
		System.out.println("equalsToHello.test(\"world\") : " + equalsToHello.test("world"));
		
		System.out.println("calculate(8, 5, (x,y)-> x + y : " +calculate(8, 5, (x,y)-> x + y));
		
		// 1. ClassName::staticMethodName
		// 클래스의 static method를 지정할 때	
		System.out.println("calculate(8, 5, MethodReferenceSection1::multiply) : " +calculate(8, 5, MethodReferenceSection1::multiply));
		
		// 2. objectName::instanceMethodName
		// 선언된 객체의 instance method를 지정할 때
		System.out.println("calculate(8, 5, new MethodReferenceSection1()::subtract) : " +calculate(8, 5, new MethodReferenceSection1()::subtract));
		
		new MethodReferenceSection1().myWrappingMethod();
		
	}
	
	private static int calculate(int x, int y, BiFunction<Integer,Integer,Integer> operator) {
		return operator.apply(x, y);
	}
	
	private static int multiply(int x, int y) {
		return x * y;
	}
	
	private int subtract(int x, int y) {
		return x - y;
	}
	
	private void myWrappingMethod() {
		System.out.println("new MethodReferenceSection1().myWrappingMethod() calculate(30, 40, this::subtract) : " + calculate(30, 40, this::subtract));
	}

}
