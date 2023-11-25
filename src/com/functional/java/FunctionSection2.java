package com.functional.java;

import java.util.function.Function;

public class FunctionSection2 {

	public static void main(String[] args) {
		
//		Function<Integer,Integer> myAdder = new Adder();
//		int result = myAdder.apply(5);
		Function<Integer,Integer> myAdder = x -> x + 10;
		int result = myAdder.apply(5);
		System.out.println(result);
		

	}

}
