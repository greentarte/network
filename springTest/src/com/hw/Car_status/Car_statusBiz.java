package com.hw.Car_status;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hw.frame.Biz;
import com.hw.frame.Dao;
import com.hw.vo.Car_status;

//	Biz�� ���׸� ���¿� ù��° �Ű��������� VO��ü,  �ι�° �Ű������� Primary Key���� ���¿� �°� �����ؼ� ����
@Service("car_statusBiz")
public class Car_statusBiz implements Biz<Car_status, String> {

	// Resource�� AutoWired�� ����� ���
	@Resource(name = "car_statusDao")
	Dao<Car_status, String> dao;

	@Transactional // �ڵ� Ʈ������ ó�� �����Ͱ� �ٲ�
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
