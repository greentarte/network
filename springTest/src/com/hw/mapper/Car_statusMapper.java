package com.hw.mapper;

import java.util.List;

import com.hw.vo.Car_status;

public interface Car_statusMapper {
	public void insert(Car_status obj);
	public void delete(String email);
	public void update(Car_status obj);
	public Car_status select(String email);
	public List<Car_status> selectall();
}
