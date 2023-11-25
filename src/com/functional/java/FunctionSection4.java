package com.functional.java;

import com.functional.java.util.TriFunction;

public class FunctionSection4 {

	public static void main(String[] args) {
		
		TriFunction<Integer,Integer,Integer,Integer> add = (Integer x, Integer y, Integer z) -> {
			return x + y + z;
		};
		int result = add.apply(10,20,30);
		System.out.println(result);

	}

}
