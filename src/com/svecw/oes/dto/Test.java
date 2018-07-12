package com.svecw.oes.dto;

import java.util.Date;

public class Test {

	private int testId;
	private String name;
	private Date startDate;
	private Date endDate;
	private int duration;

	public int getTestId() {
		return testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Test(int testId, String name, Date startDate, Date endDate, int duration) {
		super();
		this.testId = testId;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.duration = duration;
	}

	public Test() {
		super();
	}

	@Override
	public String toString() {
		return "Test [testId=" + testId + ", Name=" + name + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", duration=" + duration + "]";
	}

}
