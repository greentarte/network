package com.hw.vo;

public class UnitInfo {

   int unit;
   int total;
   String start_date;
   String end_date;
   
   
 
public UnitInfo() {
	super();
}



public UnitInfo(int unit, int total, String start_date, String end_date) {
	super();
	this.unit = unit;
	this.total = total;
	this.start_date = start_date;
	this.end_date = end_date;
}


public int getUnit() {
	return unit;
}
public void setUnit(int unit) {
	this.unit = unit;
}
public int getTotal() {
	return total;
}
public void setTotal(int total) {
	this.total = total;
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
	
  
	
}
