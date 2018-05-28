package com.hw.car_control;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hw.frame.Biz;
import com.hw.frame.Dao;
import com.hw.vo.Car_control;

//	Biz�� ���׸� ���¿� ù��° �Ű��������� VO��ü,  �ι�° �Ű������� Primary Key���� ���¿� �°� �����ؼ� ����
@Service("car_controlBiz")
public class Car_controlBiz implements Biz<Car_control, String> {

	// Resource�� AutoWired�� ����� ���
	@Resource(name = "car_controlDao")
	Dao<Car_control, String> dao;

	@Transactional // �ڵ� Ʈ������ ó�� �����Ͱ� �ٲ�
	@Override
	public void register(Car_control m) {
		dao.insert(m);
	}

	@Transactional
	@Override
	public void remove(String s) {
		dao.delete(s);
	}

	@Transactional
	@Override
	public void modify(Car_control m) {
		dao.update(m);

	}

	@Override
	public Car_control get(String s) {
		return dao.select(s);
	}

	@Override
	public List<Car_control> get() {

		return dao.select();
	}

}
