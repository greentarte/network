package com.hw.vo;

public class Car_control {
	int seq;
	int set_temp;
	int set_wind; // 0~4
	int set_cool; // 0 off 1 on
	int set_warm;
	int set_charging_amount;
	int charging_port;
	String code;
	String set_date;

	public int getCharging_port() {
		return charging_port;
	}

	public void setCharging_port(int charging_port) {
		this.charging_port = charging_port;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public int getSet_temp() {
		return set_temp;
	}

	public void setSet_temp(int set_temp) {
		this.set_temp = set_temp;
	}

	public int getSet_wind() {
		return set_wind;
	}

	public void setSet_wind(int set_wind) {
		this.set_wind = set_wind;
	}

	public int getSet_cool() {
		return set_cool;
	}

	public void setSet_cool(int set_cool) {
		this.set_cool = set_cool;
	}

	public int getSet_warm() {
		return set_warm;
	}

	public void setSet_warm(int set_warm) {
		this.set_warm = set_warm;
	}

	public int getSet_charging_amount() {
		return set_charging_amount;
	}

	public void setSet_charging_amount(int set_charging_amount) {
		this.set_charging_amount = set_charging_amount;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSet_date() {
		return set_date;
	}

	public void setSet_date(String set_date) {
		this.set_date = set_date;
	}

	@Override
	public String toString() {
		return "Car_control [seq=" + seq + ", set_temp=" + set_temp + ", set_wind=" + set_wind + ", set_cool="
				+ set_cool + ", set_warm=" + set_warm + ", set_charging_amount=" + set_charging_amount
				+ ", set_charging_port=" + charging_port + ", code=" + code + ", set_date=" + set_date + "]";
	}

}
