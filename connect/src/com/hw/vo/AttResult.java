package com.hw.vo;

public class AttResult {

  String id;
  String result;
  int count;
  int percent;
   
   
 
public AttResult() {
	super();
}



public AttResult(String id, String result, int count, int percent) {
	super();
	this.id = id;
	this.result = result;
	this.count = count;
	this.percent = percent;
}



public String getId() {
	return id;
}



public void setId(String id) {
	this.id = id;
}



public String getResult() {
	return result;
}



public void setResult(String result) {
	this.result = result;
}



public int getCount() {
	return count;
}



public void setCount(int count) {
	this.count = count;
}



public int getPercent() {
	return percent;
}



public void setPercent(int percent) {
	this.percent = percent;
}



  
	
}
