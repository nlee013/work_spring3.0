package com.spring.boot.dto;

public class QaUploadDTO {

	private int qa_upNo;
	private String userId;
	private String userPwd;
	private String qSubject;
	private String qContent;
	private String ipAddr;
	private String created;
	private int hitCount;
	
	public int getQa_upNo() {
		return qa_upNo;
	}
	public void setQa_upNo(int qa_upNo) {
		this.qa_upNo = qa_upNo;
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
	public String getqSubject() {
		return qSubject;
	}
	public void setqSubject(String qSubject) {
		this.qSubject = qSubject;
	}
	public String getqContent() {
		return qContent;
	}
	public void setqContent(String qContent) {
		this.qContent = qContent;
	}
	public String getIpAddr() {
		return ipAddr;
	}
	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	public int getHitCount() {
		return hitCount;
	}
	public void setHitCount(int hitCount) {
		this.hitCount = hitCount;
	}
	
	
	
	
	
}
