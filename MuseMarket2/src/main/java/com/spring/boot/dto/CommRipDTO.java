package com.spring.boot.dto;

public class CommRipDTO {

	//댓글
	private int crNo;
	private String crContent;
	private String insert_time;
	
	//공통
	private int commuNo;
	private int userNo;
	private String userId;
	private String userPwd;
	
	//커뮤니티
	private String cmSubject;
	private String cmContent;
	private String ipAddr;
	private String created;
	private int hitCount;
	
	public int getCrNo() {
		return crNo;
	}
	public void setCrNo(int crNo) {
		this.crNo = crNo;
	}
	public String getCrContent() {
		return crContent;
	}
	public void setCrContent(String crContent) {
		this.crContent = crContent;
	}
	public String getInsert_time() {
		return insert_time;
	}
	public void setInsert_time(String insert_time) {
		this.insert_time = insert_time;
	}
	public int getCommuNo() {
		return commuNo;
	}
	public void setCommuNo(int commuNo) {
		this.commuNo = commuNo;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
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
	public String getCmSubject() {
		return cmSubject;
	}
	public void setCmSubject(String cmSubject) {
		this.cmSubject = cmSubject;
	}
	public String getCmContent() {
		return cmContent;
	}
	public void setCmContent(String cmContent) {
		this.cmContent = cmContent;
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
