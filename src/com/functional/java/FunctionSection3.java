package com.functional.java;

import java.util.function.BiFunction;

public class FunctionSection3 {

	public static void main(String[] args) {
		
		BiFunction<Integer,Integer,Integer> add = (Integer x, Integer y) -> {
			return x + y;
		};
		int result = add.apply(10,20);
		System.out.println(result);

	}

}
