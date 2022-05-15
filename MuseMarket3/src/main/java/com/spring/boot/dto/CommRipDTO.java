package com.spring.boot.dto;

public class CommRipDTO {

	private int crNo;
	private int commuNo;
	private String userId;
	private String crContent;
	private String delete_yn;
	private String insert_time;
	private String update_time;
	private String delete_time;
	
	public int getCrNo() {
		return crNo;
	}
	public void setCrNo(int crNo) {
		this.crNo = crNo;
	}
	public int getCommuNo() {
		return commuNo;
	}
	public void setCommuNo(int commuNo) {
		this.commuNo = commuNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getCrContent() {
		return crContent;
	}
	public void setCrContent(String crContent) {
		this.crContent = crContent;
	}
	public String getDelete_yn() {
		return delete_yn;
	}
	public void setDelete_yn(String delete_yn) {
		this.delete_yn = delete_yn;
	}
	public String getInsert_time() {
		return insert_time;
	}
	public void setInsert_time(String insert_time) {
		this.insert_time = insert_time;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}
	public String getDelete_time() {
		return delete_time;
	}
	public void setDelete_time(String delete_time) {
		this.delete_time = delete_time;
	}
	
}
