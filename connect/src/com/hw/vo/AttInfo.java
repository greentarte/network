package com.hw.vo;

public class AttInfo {


	String id;
	String att_date;
	String month;
	String day;
	int unit;
	int time_nine;
	int time_two;
	int time_six;
	String result;
	
	public AttInfo() {
		super();
	}
	
	
	public AttInfo(String id, String att_date, String month,String day,int unit, int time_nine, int time_two, int time_six, String result) {
		super();
		this.id = id;
		this.att_date = att_date;
		this.month = month;
		this.day = day;
		this.unit = unit;
		this.time_nine = time_nine;
		this.time_two = time_two;
		this.time_six = time_six;
		this.result = result;
	}



	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAtt_date() {
		return att_date;
	}
	public void setAtt_date(String att_date) {
		this.att_date = att_date;
	}
	public int getUnit() {
		return unit;
	}
	public void setUnit(int unit) {
		this.unit = unit;
	}
	public int getTime_nine() {
		return time_nine;
	}
	public void setTime_nine(int time_nine) {
		this.time_nine = time_nine;
	}
	public int getTime_two() {
		return time_two;
	}
	public void setTime_two(int time_two) {
		this.time_two = time_two;
	}
	public int getTime_six() {
		return time_six;
	}
	public void setTime_six(int time_six) {
		this.time_six = time_six;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}


	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}
	
	

	
	
	
	
}
