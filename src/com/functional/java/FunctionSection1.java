package com.functional.java;

import java.util.function.Function;

import com.functional.java.util.Adder;

public class FunctionSection1 {

	public static void main(String[] args) {
		
		Function<Integer,Integer> myAdder = new Adder();
		int result = myAdder.apply(5);
		System.out.println(result);
		

	}

}
