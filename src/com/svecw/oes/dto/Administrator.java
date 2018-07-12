package com.svecw.oes.dto;

public class Administrator {
	private int adminId;
	 private String name;
	 private String password;
	 private String phoneNumber;
	 private String emailId;
	 
	 
	public Administrator(String name, String password, String phoneNumber, String emailId) {
	super();
	this.name = name;
	this.password = password;
	this.phoneNumber = phoneNumber;
	this.emailId = emailId;
	}
	public Administrator(int adminId,String password) {
		this.adminId = adminId;
		this.password=password;
	}
	@Override
	public String toString() {
	return "Administrators [adminId=" + adminId + ", name=" + name + ", password=" + password
	+ ", phoneNumber=" + phoneNumber + ", emailId=" + emailId + "]";
	}
	public int getAdminId() {
	return adminId;
	}
	public String getName() {
	return name;
	}
	public void setname(String name) {
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
	public String getEmailId() {
	return emailId;
	}
	public void setEmailId(String emailId) {
	this.emailId = emailId;
	}
	 
	 public Administrator() {
		// TODO Auto-generated constructor stub
	}
}
