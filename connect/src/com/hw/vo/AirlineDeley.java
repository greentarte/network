package com.hw.vo;

public class AirlineDeley {
	private int year;
	private int month;
	private int count;
	
	
	public AirlineDeley(int year, int month, int count) {
		super();
		this.year = year;
		this.month = month;
		this.count = count;
	}
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
}
