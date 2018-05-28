package com.hw.mapper;

import java.util.List;

import com.hw.vo.Car_control;

public interface Car_controlMapper {
	public void insert( Car_control obj);
	public void delete(String code);
	public void update( Car_control obj);
	public  Car_control select(String code);
	public List< Car_control> selectall();
}
