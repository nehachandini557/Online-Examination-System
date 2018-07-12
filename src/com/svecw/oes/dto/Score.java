package com.svecw.oes.dto;

public class Score {
	
	private String userId;
	private int testId;
	private int questionId;
	private int optionSelected;
	
	public Score(String userId, int testId, int questionId, int optionSelected) {
		super();
		this.userId = userId;
		this.testId = testId;
		this.questionId = questionId;
		this.optionSelected = optionSelected;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getTestId() {
		return testId;
	}
	public void setTestId(int testId) {
		this.testId = testId;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public int getOptionSelected() {
		return optionSelected;
	}
	public void setOptionSelected(int optionSelected) {
		this.optionSelected = optionSelected;
	}
	@Override
	public String toString() {
		return "Score [userId=" + userId + ", testId=" + testId + ", questionId=" + questionId + ", optionSelected="
				+ optionSelected + "]";
	}
	
	
	

}
