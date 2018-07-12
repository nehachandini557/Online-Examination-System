package com.svecw.oes.dto;

public class Report {
	
	
	private int score;
	private String testName;
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
	@Override
	public String toString() {
		return "Report [score=" + score + ", testName=" + testName + "]";
	}

}
