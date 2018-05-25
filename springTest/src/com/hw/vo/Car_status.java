package com.hw.vo;


public class Car_status {
	String code;
	int available_distance;
	double battery_capacity;
	int indoor_temp;
	int outdoor_temp;
	int speed;
	int charging_status;
	int charging_after_distance;
	double consumption_after_charging;
	int monthly_distance;
	double monthly_battery_use;
	double monthly_fuel_efficiency;
	int cumulative_mileage;
	int charge_amount;
	float latitude;
	float longtitude;
	String model_name;
	String user_name;
	double charging_after_fuel_efficiency;

	
	

	public Car_status() {
	}



	public Car_status(String code, int available_distance, double battery_capacity, int indoor_temp, int outdoor_temp,
			int speed, int charging_status, int charging_after_distance, double consumption_after_charging,
			int monthly_distance, double monthly_battery_use, double monthly_fuel_efficiency, int cumulative_mileage,
			int charge_amount, float latitude, float longtitude, String model_name, String user_name,
			double charging_after_fuel_efficiency) {
		
		this.code = code;
		this.available_distance = available_distance;
		this.battery_capacity = battery_capacity;
		this.indoor_temp = indoor_temp;
		this.outdoor_temp = outdoor_temp;
		this.speed = speed;
		this.charging_status = charging_status;
		this.charging_after_distance = charging_after_distance;
		this.consumption_after_charging = consumption_after_charging;
		this.monthly_distance = monthly_distance;
		this.monthly_battery_use = monthly_battery_use;
		this.monthly_fuel_efficiency = monthly_fuel_efficiency;
		this.cumulative_mileage = cumulative_mileage;
		this.charge_amount = charge_amount;
		this.latitude = latitude;
		this.longtitude = longtitude;
		this.model_name = model_name;
		this.user_name = user_name;
		this.charging_after_fuel_efficiency = charging_after_fuel_efficiency;

	}



	public String getCode() {
		return code;
	}



	public void setCode(String code) {
		this.code = code;
	}



	public int getAvailable_distance() {
		return available_distance;
	}



	public void setAvailable_distance(int available_distance) {
		this.available_distance = available_distance;
	}



	public double getBattery_capacity() {
		return battery_capacity;
	}



	public void setBattery_capacity(double battery_capacity) {
		this.battery_capacity = battery_capacity;
	}



	public int getIndoor_temp() {
		return indoor_temp;
	}



	public void setIndoor_temp(int indoor_temp) {
		this.indoor_temp = indoor_temp;
	}



	public int getOutdoor_temp() {
		return outdoor_temp;
	}



	public void setOutdoor_temp(int outdoor_temp) {
		this.outdoor_temp = outdoor_temp;
	}



	public int getSpeed() {
		return speed;
	}



	public void setSpeed(int speed) {
		this.speed = speed;
	}



	public int getCharging_status() {
		return charging_status;
	}



	public void setCharging_status(int charging_status) {
		this.charging_status = charging_status;
	}



	public int getCharging_after_distance() {
		return charging_after_distance;
	}



	public void setCharging_after_distance(int charging_after_distance) {
		this.charging_after_distance = charging_after_distance;
	}



	public double getConsumption_after_charging() {
		return consumption_after_charging;
	}



	public void setConsumption_after_charging(double consumption_after_charging) {
		this.consumption_after_charging = consumption_after_charging;
	}



	public int getMonthly_distance() {
		return monthly_distance;
	}



	public void setMonthly_distance(int monthly_distance) {
		this.monthly_distance = monthly_distance;
	}



	public double getMonthly_battery_use() {
		return monthly_battery_use;
	}



	public void setMonthly_battery_use(double monthly_battery_use) {
		this.monthly_battery_use = monthly_battery_use;
	}



	public double getMonthly_fuel_efficiency() {
		return monthly_fuel_efficiency;
	}



	public void setMonthly_fuel_efficiency(double monthly_fuel_efficiency) {
		this.monthly_fuel_efficiency = monthly_fuel_efficiency;
	}



	public int getCumulative_mileage() {
		return cumulative_mileage;
	}



	public void setCumulative_mileage(int cumulative_mileage) {
		this.cumulative_mileage = cumulative_mileage;
	}



	public int getCharge_amount() {
		return charge_amount;
	}



	public void setCharge_amount(int charge_amount) {
		this.charge_amount = charge_amount;
	}



	public float getLatitude() {
		return latitude;
	}



	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}



	public float getLongtitude() {
		return longtitude;
	}



	public void setLongtitude(float longtitude) {
		this.longtitude = longtitude;
	}



	public String getModel_name() {
		return model_name;
	}



	public void setModel_name(String model_name) {
		this.model_name = model_name;
	}



	public String getUser_name() {
		return user_name;
	}



	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}



	public double getCharging_after_fuel_efficiency() {
		return charging_after_fuel_efficiency;
	}



	public void setCharging_after_fuel_efficiency(double charging_after_fuel_efficiency) {
		this.charging_after_fuel_efficiency = charging_after_fuel_efficiency;
	}



	@Override
	public String toString() {
		return "Car_status [code=" + code + ", available_distance=" + available_distance + ", battery_capacity="
				+ battery_capacity + ", indoor_temp=" + indoor_temp + ", outdoor_temp=" + outdoor_temp + ", speed="
				+ speed + ", charging_status=" + charging_status + ", charging_after_distance="
				+ charging_after_distance + ", consumption_after_charging=" + consumption_after_charging
				+ ", monthly_distance=" + monthly_distance + ", monthly_battery_use=" + monthly_battery_use
				+ ", monthly_fuel_efficiency=" + monthly_fuel_efficiency + ", cumulative_mileage=" + cumulative_mileage
				+ ", charge_amount=" + charge_amount + ", latitude=" + latitude + ", longtitude=" + longtitude
				+ ", model_name=" + model_name + ", user_name=" + user_name + ", charging_after_fuel_efficiency="
				+ charging_after_fuel_efficiency + "]";
	}
}
