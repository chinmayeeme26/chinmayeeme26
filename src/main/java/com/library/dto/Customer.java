package com.library.dto;

public class Customer {
	private int cid;
	private String cname;
	private String mail;
	private long phone;
	private int age;
	private double due;
	private String password;
	
	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", cname=" + cname + ", mail=" + mail + ", phone=" + phone + ", age=" + age
				+ ", due=" + due + ", password=" + password + "]";
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getDue() {
		return due;
	}
	public void setDue(double d) {
		this.due = d;
	}
	

}
