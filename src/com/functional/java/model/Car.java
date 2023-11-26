package com.functional.java.model;

public abstract class Car {
	
	protected String name;
	protected String brand;
	
	protected Car(String name, String brand) {
		super();
		this.name = name;
		this.brand = brand;
	}
	
	protected abstract void drive();

	@Override
	public String toString() {
		return "Car [" + (name != null ? "name=" + name + ", " : "") + (brand != null ? "brand=" + brand : "") + "]";
	}
	
}
