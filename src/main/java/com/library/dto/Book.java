 package com.library.dto;

public class Book {
	private int bid;
	private String title;
	private String author;
	private String language;
	private String year;
	private double price;
	private String status;
	@Override
	public String toString() {
		return "Book [bid=" + bid + ", title=" + title + ", author=" + author + ", language=" + language + ", year="
				+ year + ", price=" + price + ", status=" + status + "]";
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int id) {
		this.bid = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String d) {
		this.year = d;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	

}
