package com.functional.java;

import java.util.function.Supplier;

public class SupplierSection1 {

	public static void main(String[] args) {
		
		Supplier<String> myStringSupplier = () -> "Hello world";
//		System.out.println(myStringSupplier.get());
		printSupplier(myStringSupplier,3);
		
		Supplier<Double> myRandomDoubleSupplier = () -> Math.random();
//		System.out.println(myRandomDoubleSupplier.get());
		printSupplier(myRandomDoubleSupplier,3);
		
	}
	
	private static void printSupplier(Supplier<?> supplier, int count) {
		for( int i = 0; i < count; i++ ) {
			System.out.println(supplier.get());
		}
	}

}
