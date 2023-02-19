package com.gt.models;

public class AjaxResponse {
	private String message;
	private String additionalInfo;

	public AjaxResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AjaxResponse(String message, String additionalInfo) {
		super();
		this.message = message;
		this.additionalInfo = additionalInfo;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getadditionalInfo() {
		return additionalInfo;
	}

	public void setadditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	

	

}
