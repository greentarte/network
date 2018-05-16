package com.hw.vo;

public class DateInfo {

    int total;
	String start_date;
	String end_date;
	
	public DateInfo() {
		super();
	}

	public DateInfo(int total,String start_date, String end_date) {
		super();
		this.total = total;
		this.start_date = start_date;
		this.end_date = end_date;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
	
	
	
	
}
