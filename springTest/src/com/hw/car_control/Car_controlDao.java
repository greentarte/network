package com.hw.car_control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hw.frame.Dao;
import com.hw.mapper.Car_controlMapper;
import com.hw.vo.Car_control;

@Repository("car_controlDao")
public class Car_controlDao implements Dao<Car_control, String> {

	@Autowired
	Car_controlMapper mapper;
	// ¸â¹ö ¸ÊÆÛ¸¦ ÂüÁ¶ÇÏ°Ú´Ù mybatis

	@Override
	public void insert(Car_control m) {
		mapper.insert(m);
	}

	@Override
	public void delete(String s) {
		mapper.delete(s);
	}

	@Override
	public void update(Car_control m) {
		mapper.update(m);
	}

	@Override
	public Car_control select(String s) {
		return mapper.select(s);
	}

	@Override
	public List<Car_control> select() {
		return mapper.selectall();
	}

}
