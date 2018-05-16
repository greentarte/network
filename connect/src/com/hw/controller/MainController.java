package com.hw.controller;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.print.attribute.standard.MediaSize.Other;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hw.frame.Biz;
import com.hw.vo.Correlation;

import com.hw.vo.AirlineDeley;

@Controller
public class MainController {
		
/*	Connection conn;
	
	public MainController() {
		try {
			Class.forName("org.apache.hive.jdbc.HiveDriver");
			conn = DriverManager.getConnection("jdbc:hive2://192.168.111.100:10000/default", "root", "111111");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	*/
	@RequestMapping("/main.do")
	public String main() {
		return "main";
	}

/*	@RequestMapping("/chart1.do")
	public String chart1(Model m) {
		m.addAttribute("center", "chart1");
		return "main";
	}

	@RequestMapping("/chart2.do")
	public String chart2(Model m) {
		m.addAttribute("center", "chart2");
		return "main";
	}

	@RequestMapping("/chart3.do")
	public String chart3(Model m) {
		m.addAttribute("center", "chart3");
		return "main";
	}

	@RequestMapping("/chart4.do")
	public String chart4(Model m) {
		m.addAttribute("center", "chart4");
		return "main";
	}

	@RequestMapping("/chart5.do")
	public String chart5(Model m) {
		m.addAttribute("center", "chart5");
		return "main";
	}
	//Ajax가 요청되면 ok라는 문자 뿌림
	@RequestMapping("/chart1impl.do")
	@ResponseBody													//output으로 값 쏘겠다
	public void chart1impl(HttpServletResponse res) throws Exception {
		
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select Year, Month, count(*) " + 
				"from airline_delay " + 
				"where delayYear = 2006 " + 
				"and Month in (1,2,3,4) " + 
				"and ArrDelay > 0 " + 
				"group by Year, Month ");

		JSONArray ja = new JSONArray();
		while (rs.next()) {
			JSONArray data = new JSONArray();
			// [] 이게 하나 만들어짐
			data.add(rs.getInt(2)+"월");
			data.add(rs.getInt(3));
			ja.add(data);	// 배열 안의 배열 모양이 된다. chart1의 data와 일치
		}
		
		res.setCharacterEncoding("EUC-KR");
		res.setContentType("application/json");
		PrintWriter out = res.getWriter();
		
		out.print(ja.toJSONString());
		out.close();
	}
	//Ajax가 요청되면 ok라는 문자 뿌림
	@RequestMapping("/chart2impl.do")
	@ResponseBody													//output으로 값 쏘겠다
	public void chart2impl(HttpServletResponse res) throws Exception {
		
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select Year, Month, count(*) " + 
				"from airline_delay " + 
				"where delayYear = 2006 " + 
				"and Month in (1,2,3,4) " + 
				"and ArrDelay > 0 " + 
				"group by Year, Month ");

		JSONArray ja = new JSONArray();
		while (rs.next()) {
			JSONObject data = new JSONObject();
			// [] 이게 하나 만들어짐
			data.put("name", rs.getInt(2)+"월");
			data.put("y", rs.getInt(3));
			ja.add(data);	// 배열 안의 배열 모양이 된다. chart1의 data와 일치
		}
		
		res.setCharacterEncoding("EUC-KR");
		res.setContentType("application/json");
		PrintWriter out = res.getWriter();

		out.print(ja.toJSONString());
		out.close();
	}
	//Ajax가 요청되면 ok라는 문자 뿌림
	@RequestMapping("/chart3impl.do")
	@ResponseBody													//output으로 값 쏘겠다
	public void chart3impl(HttpServletResponse res) throws Exception {
		
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select C.LocalName, sum(A.Cnt) "
				+ "from RealInfo_Cold_SiGunGu A "
				+ "join SiGunGu_LocalCode B on (A.SiGunGuLocalCode = B.SiGunGuLocalCode) "
				+ "join SiDo_LocalCode C on (B.HighSiDoLocalCode  = C.SiDoLocalCode) "
				+ "group by C.LocalName ");

		JSONArray ja = new JSONArray();
		while (rs.next()) {
			JSONObject data = new JSONObject();
			// [] 이게 하나 만들어짐
			data.put("name", rs.getString(1));
			data.put("y", rs.getInt(2));
			ja.add(data);	// 배열 안의 배열 모양이 된다. chart1의 data와 일치
		}
		
		res.setCharacterEncoding("EUC-KR");
		res.setContentType("application/json");
		PrintWriter out = res.getWriter();

		out.print(ja.toJSONString());
		out.close();
	}
	
	
	@Resource(name="correlationBiz")	
	Biz<Correlation,String> biz;
	//Ajax가 요청되면 ok라는 문자 뿌림
	@RequestMapping("/chart4impl.do")
	@ResponseBody													//output으로 값 쏘겠다
	public void chart4impl(HttpServletResponse res) throws Exception {
		
		List<Correlation> list = null;
		list = biz.get();
		JSONArray gu = new JSONArray();
		for(int i = 0; i < list.size(); i++) {
			JSONObject obj = new JSONObject();
			gu.add(list.get(i).getMain());
		}
		
		res.setCharacterEncoding("EUC-KR");
		res.setContentType("application/json");
		PrintWriter out = res.getWriter();
		System.out.println(gu.toJSONString());
		out.print(gu.toJSONString());
		out.close();
	}
	
	@Resource(name="correlationBiz")	
	Biz<Correlation,String> biz2;
	//Ajax가 요청되면 ok라는 문자 뿌림
	@RequestMapping("/chart4impl2.do")
	@ResponseBody													//output으로 값 쏘겠다
	public void chart4impl2(HttpServletResponse res) throws Exception {
		
		List<Correlation> list = null;
		list = biz2.get();
		JSONArray obj_arr = new JSONArray();
		
		for(int i = 0; i < list.size(); i++) {
			obj_arr.add(list.get(i).getScore());
		}
		res.setCharacterEncoding("EUC-KR");
		res.setContentType("application/json");
		PrintWriter out = res.getWriter();
		System.out.println(obj_arr.toJSONString());
		out.print(obj_arr.toJSONString());
		out.close();
	}

	@Resource(name="correlationBiz")	
	Biz<Correlation,String> biz3;
	//Ajax가 요청되면 ok라는 문자 뿌림
	@RequestMapping("/chart4impl3.do")
	@ResponseBody													//output으로 값 쏘겠다
	public void chart4impl3(HttpServletResponse res) throws Exception {
		
		List<Correlation> list = null;
		list = biz3.get();
		JSONArray obj_arr = new JSONArray();
		
		for(int i = 0; i < list.size(); i++) {
			obj_arr.add(list.get(i).getTotal_area());
		}
		res.setCharacterEncoding("EUC-KR");
		res.setContentType("application/json");
		PrintWriter out = res.getWriter();
		System.out.println(obj_arr.toJSONString());
		out.print(obj_arr.toJSONString());
		out.close();
	}

	static JSONArray ja = new JSONArray();				//가장 큰 배열 [ ]
	static JSONObject jo = new JSONObject();			//각각 연도별 객체  { }
	static JSONArray jo_sub = new JSONArray();			//각각 연도 안의 data  [ ]
	
	// Ajax가 요청되면 ok라는 문자 뿌림
	@RequestMapping("/chart5impl.do")
	@ResponseBody // output으로 값 쏘겠다
	public void chart5impl(HttpServletResponse res) throws Exception {
		RConnection rconn = null;
		try {
			// Rserve::Rserve(args="--RS-enable-remote")
			//리모트를 틀어 놓고 그 경로로 들어가기
//			rconn = new RConnection("70.12.114.130");
			rconn = new RConnection();
		} catch (RserveException e) {
			System.out.println("R Connection Error");
		}
		System.out.println("R Connection OK");
		try {
			//eval : R의 문장을 실행하겠다
			
			rconn.setStringEncoding("utf8");
			rconn.eval("source('C:/rproject/day09/r2.R',encoding='UTF-8')");
			RList list = rconn.eval("hive_conn()").asList();
			System.out.println(list.size());		//열의 개수
			double year [] = list.at(0).asDoubles();
			double month [] = list.at(1).asDoubles();
			double count [] = list.at(2).asDoubles();
//			
			ArrayList<AirlineDeley> air_array = new ArrayList<AirlineDeley>();
			
			for(int i = 0; i < year.length; i++) {
				AirlineDeley air_bean = new AirlineDeley((int)year[i], (int)month[i], (int)count[i]);
				air_array.add(air_bean);
			}
			
			boolean check = false;
			int yearInt = 0;
			for(int i = 0; i < air_array.size(); i++) {
				if(yearInt != air_array.get(i).getYear()) {
					if(check == true) {
						//2006있고 이제 막 2007될 때
						//푸쉬 및 초기화
						jsonInit();
					}
					yearInt = air_array.get(i).getYear();
					jo.put("name", yearInt);
					jo_sub.add(air_array.get(i).getCount());
					check = true;
				}else {
					jo_sub.add(air_array.get(i).getCount());
				}
				if(i+1 == air_array.size()) {
					//2006있고 이제 막 2007될 때
					//푸쉬 및 초기화
					jsonInit();
				}
			}
			res.setCharacterEncoding("EUC-KR");
			res.setContentType("application/json");
			PrintWriter out = res.getWriter();
			System.out.println(ja.toJSONString());
			out.print(ja.toJSONString());
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}	
	
	private static void jsonInit() {
		jo.put("data", jo_sub.clone());
		ja.add(jo.clone());
		jo_sub.clear();
		jo.clear();
	}*/
}



