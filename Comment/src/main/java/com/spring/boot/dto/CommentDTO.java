package com.spring.boot.dto;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="tb_boards")
public class CommentDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int crNo;
	private int commuNo;
	private String userId;
	private String crContent;
	private String delete_yn;
	
	@CreationTimestamp
	private Timestamp insert_time;
	
	@UpdateTimestamp
	private Timestamp update_time;
	
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
	public Timestamp getInsert_time() {
		return insert_time;
	}
	public void setInsert_time(Timestamp insert_time) {
		this.insert_time = insert_time;
	}
	public Timestamp getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Timestamp update_time) {
		this.update_time = update_time;
	}
	
	
}
