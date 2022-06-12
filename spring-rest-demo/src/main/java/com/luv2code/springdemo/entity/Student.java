package com.luv2code.springdemo.entity;

public class Student {
	
	private String firstName;
	private String lsstName;
	
	public Student() {
		
	}

	public Student(String firstName, String lsstName) {
		this.firstName = firstName;
		this.lsstName = lsstName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLsstName() {
		return lsstName;
	}

	public void setLsstName(String lsstName) {
		this.lsstName = lsstName;
	}

}
