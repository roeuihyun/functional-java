package com.functional.java.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class User {

	private int id;
	private String name;
	private String emailAddress;
	private boolean isVerified;
	private List<Integer> friendUserId;
	private String flatMapEmailAddress;
	private LocalDateTime createdAt;
	
	public int getId() {
		return id;
	}
	
	public User setId(int id) {
		this.id = id;
		return this;
	}
	
	public String getName() {
		return name;
	}
	
	public User setName(String name) {
		this.name = name;
		return this;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}
	
	public User setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
		return this;
	}
	
	public Optional<String> getFlatMapEmailAddress() {
		return Optional.ofNullable(flatMapEmailAddress);
	}
	
	public User setFlatMapEmailAddress(String flatMapEmailAddress) {
		this.flatMapEmailAddress = flatMapEmailAddress;
		return this;
	}
	
	public boolean isVerified() {
		return isVerified;
	}
	
	public User setVerified(boolean isVerified) {
		this.isVerified = isVerified;
		return this;
	}
	
	public List<Integer> getFriendUserId() {
		return friendUserId;
	}
	
	public User setFriendUserId(List<Integer> friendUserId) {
		this.friendUserId = friendUserId;
		return this;
	}
	
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public User setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
		return this;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", " + (name != null ? "name=" + name + ", " : "")
				+ (emailAddress != null ? "emailAddress=" + emailAddress + ", " : "") + "isVerified=" + isVerified
				+ ", " + (friendUserId != null ? "friendUserId=" + friendUserId : "") + "]";
	}
	
}