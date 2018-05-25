package com.hw.controller;

import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hw.frame.Biz;
import com.hw.vo.Car_status;
import com.hw.vo.Member;

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
	//리셋 패스워드
	@RequestMapping("/reset.do")
	public void resest(HttpServletResponse res, Member member) throws Exception{
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
	//차량 상태 업데이트
	@RequestMapping("/status_update.do")
	public void status_update(HttpServletResponse res, Car_status car_status) throws Exception{
		
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
}
