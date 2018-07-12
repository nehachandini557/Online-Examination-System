package com.svecw.oes.dto;

import java.util.List;

public class Question {
	
	private int questionId;
	private int difficultyId;
	private int subjectId;
	private int chapterId;
	private int answer;

	private String title;
	private Data description;
	private List<Data> options;
	
	private int selectedAnswer = 0;
	private boolean isMultiAnswered;

	public int getSelectedAnswer() {
		return selectedAnswer;
	}

	public void setSelectedAnswer(int selectedAnswer) {
		this.selectedAnswer = selectedAnswer;
	}

	public boolean isMultiAnswered() {
		return isMultiAnswered;
	}

	public void setMultiAnswered(boolean isMultiAnswered) {
		this.isMultiAnswered = isMultiAnswered;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public int getDifficultyId() {
		return difficultyId;
	}

	public void setDifficultyId(int difficultyId) {
		this.difficultyId = difficultyId;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public int getChapterId() {
		return chapterId;
	}

	public void setChapterId(int chapterId) {
		this.chapterId = chapterId;
	}

	public int getAnswer() {
		return answer;
	}

	public void setAnswer(int answer) {
		this.answer = answer;
	}

	public Data getDescription() {
		return description;
	}

	public void setDescription(Data description) {
		this.description = description;
	}

	public List<Data> getOptions() {
		return options;
	}

	public void setOptions(List<Data> options) {
		this.options = options;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", difficultyId=" + difficultyId + ", subjectId=" + subjectId
				+ ", chapterId=" + chapterId + ", answer=" + answer + ", title=" + title + ", description="
				+ description + ", options=" + options + ", selectedAnswer=" + selectedAnswer + ", isMultiAnswered="
				+ isMultiAnswered + "]";
	}

}
