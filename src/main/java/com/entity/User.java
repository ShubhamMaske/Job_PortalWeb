package com.entity;

public class User {
	
	private int id;
	private String name;
	private String email;
	private String pasword;
	private String qualification;
	private String role;
	
	public User(String name, String email, String pasword, String qualification, String role) {
		super();
		this.name = name;
		this.email = email;
		this.pasword = pasword;
		this.qualification = qualification;
		this.role = role;
	}
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPasword() {
		return pasword;
	}
	public void setPasword(String pasword) {
		this.pasword = pasword;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

}
