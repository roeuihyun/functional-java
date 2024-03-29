package com.functional.java;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class ApplyingFunctionalProgramming1 {
	
	public static void main(String[] args) {
		
		Supplier<String> supplier = getStringSupplier();
		System.out.println("supplier.get() : " + supplier.get());
		
		BiFunction<Integer, Integer, Integer> addBiFunction = (x,y) -> x + y;
		Function<Integer, Function<Integer,Integer>> addFunction = x -> y -> x + y;
		
		System.out.println("addBiFunction.apply(3, 10) : " + addBiFunction.apply(3, 10));
		System.out.println("addFunction.apply(3).apply(10) : " + addFunction.apply(3).apply(10));
		
	}
	
	public static Supplier<String> getStringSupplier(){
		
		String hello = "Hello";
		Supplier<String> supplier = () -> {
			String world = "World";
			return hello + world;
		};
		return supplier;
		
	}

}
