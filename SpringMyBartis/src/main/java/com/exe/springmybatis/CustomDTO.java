package com.exe.springmybatis;

//import lombok.Data;
import lombok.Getter;
import lombok.Setter;

//@Data
public class CustomDTO {

	private @Getter @Setter int id;
	private @Getter @Setter String name;
	private @Getter @Setter int age;
	/*
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	*/
}
