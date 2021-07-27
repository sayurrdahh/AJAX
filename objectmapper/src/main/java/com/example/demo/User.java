package com.example.demo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

	private String name;
	private int age;
	
	@JsonProperty("phone_number")
	private String phoneNumber;
	
	public User() {
		this.name = null;
		this.age = 0;
	}
	
	public User(String name, int age, String phoneNumber) {
		this.name = name;
		this.age = age;
		this.phoneNumber = phoneNumber;
	}

	//get 빼고 이름지어야한다. (getDefaultUser x)
	public User defaultUser() {
		return new User("default",0,"default");
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}

	//get메소드만 추가함
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", phoneNumber=" + phoneNumber + "]";
	}

	
}
