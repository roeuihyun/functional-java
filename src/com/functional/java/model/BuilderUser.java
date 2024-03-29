package com.functional.java.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class BuilderUser {

	private int id;
	private String name;
	private String emailAddress;
	private boolean isVerified;
	private List<Integer> friendUserId;
	private String flatMapEmailAddress;
	private LocalDateTime createdAt;
	
	public BuilderUser (Builder builder) {
		this.id = builder.id;
		this.name = builder.name;
		this.emailAddress = builder.emailAddress;
		this.isVerified = builder.isVerified;
		this.friendUserId = builder.friendUserId;
		this.flatMapEmailAddress = builder.flatMapEmailAddress;
		this.createdAt = builder.createdAt;
	}
	
	public static Builder builder(int id, String name) {
		return new Builder(id,name);
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}
	
	public Optional<String> getFlatMapEmailAddress() {
		return Optional.ofNullable(flatMapEmailAddress);
	}
	
	public boolean isVerified() {
		return isVerified;
	}
	
	public List<Integer> getFriendUserId() {
		return friendUserId;
	}
	
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	
	public static class Builder {
		private int id;
		private String name;
//		private String emailAddress;
//		private boolean isVerified;
//		private List<Integer> friendUserId = new ArrayList<>();
//		private String flatMapEmailAddress;
//		private LocalDateTime createdAt;
		public String emailAddress;
		public boolean isVerified;
		public List<Integer> friendUserId = new ArrayList<>();
		public String flatMapEmailAddress;
		public LocalDateTime createdAt;
		
		private Builder(int id, String name) {
			this.id = id;
			this.name = name;
		}
		
//		public Builder withEmailAddress(String emailAddress) {
//			this.emailAddress = emailAddress;
//			return this;
//		}
//		
//		public Builder withVerified(boolean isVerified) {
//			this.isVerified = isVerified;
//			return this;
//		}
//		
//		public Builder withCreatedAt(LocalDateTime createdAt) {
//			this.createdAt = createdAt;
//			return this;
//		}
//		
//		public Builder withFriendUserIds(List<Integer> friendUserId) {
//			this.friendUserId = friendUserId;
//			return this;
//		}
		
		public Builder with(Consumer<Builder> consumer) {
			consumer.accept(this);
			return this;
		}
		
		public BuilderUser build() {
			return new BuilderUser(this);
		}
		
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", " + (name != null ? "name=" + name + ", " : "")
				+ (emailAddress != null ? "emailAddress=" + emailAddress + ", " : "") + "isVerified=" + isVerified
				+ ", " + (friendUserId != null ? "friendUserId=" + friendUserId : "") + "]";
	}
	
}