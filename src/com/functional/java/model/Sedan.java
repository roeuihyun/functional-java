package com.functional.java.model;

public class Sedan extends Car{

	public Sedan(String name, String brand) {
		
		super(name, brand);
		
	}

	@Override
	protected void drive() {
		
		System.out.println("Driving a Sedan : " + name + " , & brand : " + brand);
		
	}

}
