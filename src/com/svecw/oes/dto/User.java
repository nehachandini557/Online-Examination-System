package com.svecw.oes.dto;

public class User {
		private String userId;
		private int score;
		public int getScore() {
			return score;
		}

		public void setScore(int score) {
			this.score = score;
		}
		private String name;
		private String password;
		private String phoneNumber;
		private String emailId;
		public String getUserId() {
			return userId;
		}
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getPhoneNumber() {
			return phoneNumber;
		}
		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}
		public void setUserId(String userId) {
			this.userId = userId;
		}
		public String getEmailId() {
			return emailId;
		}
		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}
		public User( String userId,String name, String password, String phoneNumber, String emailId) {
			super();
			this.userId = userId;
			this.name = name;
			this.password = password;
			this.phoneNumber = phoneNumber;
			this.emailId = emailId;
		}
		public User(String userId, String password) {
			this.userId = userId;
			this.password = password;
		}
		public User(String userId) {
			super();
			this.userId = userId;
		}

		public User() {
			super();
		}
		@Override
		public String toString() {
			return "User [userId=" + userId + ", name=" + name + ", password=" + password + ", phoneNumber="
					+ phoneNumber + ", emailId=" + emailId + "]";
		}
		
		
}
