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
	Biz<Member, String> biz;

	@RequestMapping("/test.do")

	public String test(HttpServletResponse res) throws Exception {
		// JSONArray ja = new JSONArray();
		List<Member> list = null;
		list = biz.get();				
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
		System.out.println("test종료");
		return "test";
	}
	
	@RequestMapping("/start.do")

	public String start(HttpServletResponse res) throws Exception {
		
		return "index";
	}
	   //로그인 
	   @RequestMapping("/login.do")
	   public void login(HttpServletResponse res, Member member) throws Exception{
          res.setCharacterEncoding("UTF-8");
		  PrintWriter out = res.getWriter();	   
		  String email = member.getEmail();
	      String pwd = member.getPwd();
	      
	     System.out.println(email);
	      Member mem = biz.get(email);
	      System.out.println(mem.toString());
	      
	      
	      if(biz.get(email)!=null && mem.getEmail().equals(email)&&mem.getPwd().equals(pwd)) {
	    

	    	    out.println("1"+","+email);
	    	 
	      }
	      else {
	    	 out.println("0");
	      }  
	      
	      out.close();
	      
	     
	   }
	   
	   
	   //회원가입
	   @RequestMapping("/join.do")
	   public void join(HttpServletResponse res,Member member)throws Exception{

	      res.setCharacterEncoding("UTF-8");
	      PrintWriter out = res.getWriter();
	 
	        try{
	             biz.register(member);
	             out.println("1");     
	        } 
	        catch(Exception e)
	        {     
	             out.println("0");
	        }
	     
	        
	      out.close();
	      
	      
	   }
}
