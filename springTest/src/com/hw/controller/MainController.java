package com.hw.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hw.frame.Biz;
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
	Biz<Member, String> member;

	@RequestMapping("/test.do")

	public String test(HttpServletResponse res) throws Exception {
		// JSONArray ja = new JSONArray();
		List<Member> list = null;
		list = member.get();				
		for (Member u : list) {
			// JSONArray data = new JSONArray();
			System.out.println(u.toString());
			// data.add(Float.parseFloat(u.getLongitude()));
			// data.add(Float.parseFloat(u.getLatitude()));
			// ja.add(data);
		}
		res.setCharacterEncoding("EUC-KR");
//		res.setContentType("application/json");
//		 PrintWriter out = res.getWriter();
		// out.write(ja.toJSONString());
//		 out.close();
		System.out.println("test¡æ∑·");
		return "test";
	}
	
	@RequestMapping("/start.do")

	public String start(HttpServletResponse res) throws Exception {
		
		return "index";
	}
	
}
