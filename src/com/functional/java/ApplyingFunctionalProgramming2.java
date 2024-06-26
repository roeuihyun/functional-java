package com.functional.java;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ApplyingFunctionalProgramming2 {
	
	public static void main(String[] args) {
		
		if(true || returnFalse()) {
			System.out.println("true");
		}
		
		if(returnTrue() || returnFalse()) {
			System.out.println("true");
		}
		
		if(or(returnTrue() , returnFalse())) {
			System.out.println("true");
		}
		
		if(lazyOr(()-> returnTrue() , ()->returnFalse())) {
			System.out.println("true");
		}
		
		Stream<Integer> integerStream = Stream.of(3, -2, 5, 8 , -3, 10)
				.filter( x -> x > 0 )
				.peek( x -> System.out.println("peeking : " + x))
				.filter( x -> x % 2 == 0);
		System.out.println("Before collect");
		List<Integer> numbers = integerStream.collect(Collectors.toList());
		System.out.println("After collect : " + numbers);
				
		
	}
	
	public static boolean or (boolean x, boolean y) {
		System.out.println("or!!!!");
		return x || y;
	}
	
	public static boolean lazyOr (Supplier<Boolean> x , Supplier<Boolean> y) {
		System.out.println("lazyOr!!!!");
		return x.get() || y.get();
	}
	
	public static boolean returnTrue() {
		System.out.println("Returning true");
		return true;
	}

	public static boolean returnFalse() {
		System.out.println("Returning false");
		return false;
	}

}
