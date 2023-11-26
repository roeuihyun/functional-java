package com.functional.java.model;

public class Suv extends Car{

	public Suv(String name, String brand) {
		
		super(name, brand);
		
	}

	@Override
	protected void drive() {
		
		System.out.println("Driving a Suv : " + name + " , & brand : " + brand);
		
	}

}
