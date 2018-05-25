package com.hw.Car_status;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hw.frame.Biz;
import com.hw.frame.Dao;
import com.hw.vo.Car_status;

//	Biz의 제네릭 형태에 첫번째 매개변수에는 VO객체,  두번째 매개변수는 Primary Key값의 형태에 맞게 선택해서 정함
@Service("car_statusBiz")
public class Car_statusBiz implements Biz<Car_status, String> {

	// Resource가 AutoWired와 비슷한 기능
	@Resource(name = "car_statusDao")
	Dao<Car_status, String> dao;

	@Transactional // 자동 트렌젝션 처리 데이터가 바뀔때
	@Override
	public void register(Car_status m) {
		dao.insert(m);
	}

	@Transactional
	@Override
	public void remove(String s) {
		dao.delete(s);
	}

	@Transactional
	@Override
	public void modify(Car_status m) {
		dao.update(m);

	}

	@Override
	public Car_status get(String s) {
		
		return dao.select(s);
	}

	@Override
	public List<Car_status> get() {
		
		return dao.select();
	}

}
