package com.svecw.oes.dto;

public class Enrollment {
	private String uids;
	private int test;
	public String getUids() {
		return uids;
	}
	public void setUids(String uids) {
		this.uids = uids;
	}
	public int getTest() {
		return test;
	}
	public void setTest(int test) {
		this.test = test;
	}
	public Enrollment(String uids, int test) {
		this.uids = uids;
		this.test = test;
	}
	public Enrollment(){
	}
	

	}
	
