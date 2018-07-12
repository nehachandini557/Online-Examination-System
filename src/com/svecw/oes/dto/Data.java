package com.svecw.oes.dto;

public class Data {
	private boolean isImage;
	private String text;
	public boolean isImage() {
		return isImage;
	}
	public void setImage(boolean isImage) {
		this.isImage = isImage;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	@Override
	public String toString() {
		return "Data [isImage=" + isImage + ", text=" + text + "]";
	}
	

	
}
