package com.functional.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateSection1 {
	
	public static void main(String args[]) {
		
		Predicate<Integer> isPositive = x -> x > 0;
//		System.out.println(isPositive.test(10));
//		System.out.println(isPositive.test(-10));
		List<Integer> inputsList = Arrays.asList(-3,-2,-1,0,1,2,3);
		filter(inputsList,isPositive);
		System.out.println("positive numbers : " + filter(inputsList,isPositive));
		System.out.println("non-positive numbers : " + filter(inputsList,isPositive.negate()));
		System.out.println("positive numbers with 0 : " + filter(inputsList,isPositive.or(x -> x == 0)));
		System.out.println("positive numbers with over 2 >= condition : " + filter(inputsList,isPositive.and(x -> x >= 2)));
		
	}
	
	public static <T> List<T> filter(List<T> inputs, Predicate<T> condition){
		
		List<T> output = new ArrayList<T>();
		for(T input : inputs) {
			if(condition.test(input)) output.add(input);
		}
		return output;
		
	}

}
