package com.hw.Car_status;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hw.frame.Dao;
import com.hw.mapper.Car_statusMapper;
import com.hw.vo.Car_status;

@Repository("car_statusDao")
public class Car_statusDao implements Dao<Car_status, String> {

	@Autowired
	Car_statusMapper mapper;
	// ¸â¹ö ¸ÊÆÛ¸¦ ÂüÁ¶ÇÏ°Ú´Ù mybatis

	@Override
	public void insert(Car_status m) {
		mapper.insert(m);
	}

	@Override
	public void delete(String s) {
		mapper.delete(s);
	}

	@Override
	public void update(Car_status m) {
		mapper.update(m);
	}

	@Override
	public Car_status select(String s) {
		return mapper.select(s);
	}

	@Override
	public List<Car_status> select() {
		return mapper.selectall();
	}

}
