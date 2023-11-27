package com.functional.java.model;

public class OldUser {
	
	private int id;
	private String name;
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public OldUser(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "OldUser [id=" + id + ", " + (name != null ? "name=" + name : "") + "]";
	}
	
}
