package com.functional.java.model;

public class Van extends Car{

	public Van(String name, String brand) {
		
		super(name, brand);
		
	}

	@Override
	protected void drive() {
		
		System.out.println("Driving a Van : " + name + " , & brand : " + brand);
		
	}

}
