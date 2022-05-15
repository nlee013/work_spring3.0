package com.spring.boot.dto;

public class QaContactDTO {

	private int qa_conNo;
	private String userId;
	private String userPwd;
	private String userEmail;
	private String cSubject;
	private String message;
	private String created;
	
	public int getQa_conNo() {
		return qa_conNo;
	}
	public void setQa_conNo(int qa_conNo) {
		this.qa_conNo = qa_conNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getcSubject() {
		return cSubject;
	}
	public void setcSubject(String cSubject) {
		this.cSubject = cSubject;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	
	
	
}
