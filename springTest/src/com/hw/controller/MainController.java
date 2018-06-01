package com.hw.controller;

import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hw.frame.Biz;
import com.hw.vo.Car_control;
import com.hw.vo.Car_status;
import com.hw.vo.Member;

import geocoding.GeocodingAPI;

@Controller
public class MainController {

	public MainController() {

	}

	@RequestMapping("/main.do")
	public String main() {
		return "main";
	}

	@Resource(name = "memberBiz")
	Biz<Member, String> biz;

	// 로그인
	@RequestMapping("/login.do")
	public void login(HttpServletResponse res, Member member) throws Exception {
		res.setCharacterEncoding("UTF-8");
		PrintWriter out = res.getWriter();
		String email = member.getEmail();
		String pwd = member.getPwd();

		System.out.println(email);
		Member mem = biz.get(email);
		System.out.println(mem.toString());

		if (biz.get(email) != null && mem.getEmail().equals(email) && mem.getPwd().equals(pwd)) {

			out.println("1" + "," + email);

		} else {
			out.println("0");
		}

		out.close();

	}

	// 회원가입
	@RequestMapping("/join.do")
	public void join(HttpServletResponse res, Member member) throws Exception {
		res.setCharacterEncoding("UTF-8");
		PrintWriter out = res.getWriter();
		System.out.println(member.toString());
		try {
			biz.register(member);
			out.println("1");
		} catch (Exception e) {
			e.printStackTrace();
			out.println("0");
		}

		out.close();

	}

	// 비밀번호 리셋
	@RequestMapping("/reset.do")
	public void resest(HttpServletResponse res, Member member) throws Exception {
		res.setCharacterEncoding("UTF-8");
		PrintWriter out = res.getWriter();
		System.out.println(member.toString());
		try {
			biz.modify(member);
			out.println("1");
		} catch (Exception e) {
			e.printStackTrace();
			out.println("0");
		}

		out.close();
	}

	@Resource(name = "car_statusBiz")
	Biz<Car_status, String> biz2;

	@RequestMapping("/status_update.do")
	public void status_update(HttpServletResponse res, Car_status car_status) throws Exception {

		res.setCharacterEncoding("UTF-8");
		PrintWriter out = res.getWriter();
		System.out.println(car_status.toString());
		try {
			biz2.modify(car_status);
			out.println("1");
		} catch (Exception e) {
			e.printStackTrace();
			out.println("0");
		}

		out.close();
	}

	@Resource(name = "car_controlBiz")
	Biz<Car_control, String> biz3;

	// 제어 테이블 값 받기
	@RequestMapping("/control_get.do")
	public void control_update(HttpServletResponse res, Car_control car_control) throws Exception {
		res.setCharacterEncoding("UTF-8");
		PrintWriter out = res.getWriter();
		try {
			String code = "GENSDE123";
			car_control = biz3.get(code); // 해당 코드를 가진 모델의 값을 받는다
			Car_status car_status = biz2.get(code); // 해당 코드를 가진 차량의 상태를 받는다

			// reverse Geocoding
			GeocodingAPI geocodingAPI = new GeocodingAPI();
			String addres = geocodingAPI.request(car_status.getLatitude(), car_status.getLongtitude());

			out.print(car_control.getSet_temp() + "/"); // 설정 온도 받기 //0
			out.print(car_control.getSet_cool() + "/"); // 1
			out.print(car_control.getSet_warm() + "/"); // 2
			out.print(car_status.getAvailable_distance() + "/"); // 차량상태의 이동가능거리 //3
			out.print(Math.round(car_status.getBattery_capacity()) + "/"); // 차량 상태의 현재 배터리양 //4
			out.print(car_status.getIndoor_temp() + "/"); // 차량 상태의 현재 실내 온도 //5
			out.print(car_control.getSet_charging_amount() + "/"); // 6
			out.print(car_control.getCharging_port() + "/"); // 7
			out.print(car_control.getCode() + "/"); // 8
			out.print(car_control.getSet_wind() + "/"); // 9
			out.print(addres); // 10
			out.flush();

		} catch (Exception e) {
			e.printStackTrace();

		}

		out.close();
	}

	@RequestMapping("/setTemp.do")
	public void phone_temp_get(HttpServletResponse res, Car_control car_control) throws Exception {
		res.setCharacterEncoding("UTF-8");
		PrintWriter out = res.getWriter();
		try {
			// String code = "GENSDE123";
			// 불러와서 모든 열의 값을 보내고 다시 전부 받는다.
			// biz3.get(code);
			// out.print(car_control.getSet_temp() + "/");
			// out.print(car_control.getSet_wind() + "/");
			// out.print(car_control.getSet_cool() + "/");
			// out.print(car_control.getSet_warm() + "/");
			// out.print(car_control.getSet_charging_amount() + "/");
			// out.print(car_control.getCharging_port() + "/");
			// out.print(car_control.getCode());
			// System.out.println(car_control.toString());
			out.println("success");
			// 다시 받아 등록하기
			System.out.println("DB에 등록하기 위한 값");
			System.out.println(car_control.toString());
			System.out.println("DB에 등록하기 위한 값끝");
			biz3.register(car_control);
			System.out.println("success");

		} catch (Exception e) {
			e.printStackTrace();

		}

	}
}
