package com.hw.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.json.JSONObject;
import org.json.simple.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.hw.frame.BizforMember;
import com.hw.vo.Member;
import com.hw.vo.UnitInfo;
import com.hw.vo.AttInfo;
import com.hw.vo.AttResult;
import com.hw.vo.DateInfo;

@Controller
public class MemberController {
      
   @Resource(name="memberBiz")
   BizforMember<Member,String,UnitInfo,AttInfo,AttResult,DateInfo> biz;

   
    
   //로그인 
   @RequestMapping("/login.do")
   public void login(HttpServletResponse res, Member member) throws Exception{
   
	  System.out.println(member.getId());
	   
	  res.setCharacterEncoding("UTF-8");
	  PrintWriter out = res.getWriter();	   
	   
	  String id = member.getId();
      String pwd = member.getPwd();
      String name = biz.getName(id);

      
      if(biz.get(id)!=null && biz.get(id).equals(pwd)) {
    
    
    	    out.println("1"+","+name);
    	 
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
             int result = biz.register(member);
             if(result==1) out.println("1");     
        } 
        catch(Exception e)
        {     
             out.println("0");
        }
     
        
      out.close();
      
      
   }
   
   

   SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
   Calendar c = Calendar.getInstance();
   String strToday = "";
   
   
   //출결 정보에 단위기간 insert하기 (9시)
   //단위기간 테이블에서 날짜 데이터 불러와서 오늘 날짜와 비교해서 오늘날짜의 단위기간 찾고.
   @RequestMapping("/insertData9.do")
   public void insertData9(HttpServletResponse res, AttInfo att) throws Exception{
      

      res.setCharacterEncoding("UTF-8");
      PrintWriter out = res.getWriter();    
  
      strToday = df.format(c.getTime());
      int unitInfo=0;

        
       //단위기간 구하기(unitInfo)
      List<UnitInfo> list = new ArrayList<>();
      list = biz.getAll();
      
      for(UnitInfo u : list) {
         
         if(strToday.compareTo(u.getEnd_date())==-1) {
            unitInfo = u.getUnit();
            break;
         }
         
      }
      
      
      //출결정보 테이블에 9시 출결 정보 insert
        att.setAtt_date(strToday);
        att.setMonth(strToday.substring(6,7));
        att.setDay(strToday.substring(8));
        att.setUnit(unitInfo);
        
       try{
            
    	   if( biz.register9(att)==1) out.println("1");     
    	   
       } 
       catch(Exception e)
       {     
            out.println("0");
       }
    
      
        out.close();

   }
   
   
   //2시 업뎃
   @RequestMapping("/updateData2.do")
   public void updateData2(HttpServletResponse res,AttInfo att) throws Exception{
      
	  res.setCharacterEncoding("UTF-8");
	  PrintWriter out = res.getWriter(); 
      
	  strToday = df.format(c.getTime());
	   
	 
      att.setAtt_date(strToday);
      
      int result = biz.modify2(att);
      if(result==1) 
    	  out.println("1");
      else
    	  out.println("0");
      

   }
   
   
   //6시 업뎃
   @RequestMapping("/updateData6.do")
   public void updateData6(HttpServletResponse res,AttInfo att) throws Exception{
      

	   
	  res.setCharacterEncoding("UTF-8");
	  PrintWriter out = res.getWriter(); 
	  
	  strToday = df.format(c.getTime());
      att.setAtt_date(strToday);
      

      biz.modify6(att);
      
      
    //최종 출석 결과 insert
      AttInfo time = biz.getTime(att);
      int nine = time.getTime_nine();
      int two = time.getTime_two();
      int six = time.getTime_six();
      String att_result="";
      
      if(nine==1) {
    	  if(two==1) {
    		  if(six==1) att_result = "출석"; 
    		  else att_result = "조퇴";
    	  }else {
    		  if(six==1)  att_result = "조퇴";
        	  else att_result = "결석";
    	  }
      }
      
      else {
    	  if(two==1) {
    		  if(six==1) att_result = "지각";
    		  else att_result = "조퇴";
    	  }else {
    		  if(six==1) att_result ="결석";
        	  else att_result = "결석";
    	  }
      }
      
      
     att.setResult(att_result);
      
     
     int result = biz.modifyResult(att);
     if(result==1) 
  	   out.println("1");
     else
  	   out.println("0");
     
     
     out.close();
     

   }
   
   
   
   //달력조회에 필요한 출결 데이터 가져오기
   @RequestMapping("/extractData.do")
   public void extractData(HttpServletResponse res,AttInfo att) throws Exception{
      
	   res.setCharacterEncoding("UTF-8");
	   PrintWriter out = res.getWriter(); 
	 
	   
	   String result="";
	   
	   List<AttInfo> list = new ArrayList<>();
	   list = biz.getAttData(att);
	 
	   for(AttInfo a : list) {
	         
	      result += a.getDay()+a.getResult();
	      result += " ";
	         
	    }
	   
	   out.println(result);
	   out.close();
	   
   }
   
   
   //출결 정보 페이지 (id값 넘겨줘야함)
   @RequestMapping("/webview.do")	
   public ModelAndView webview(HttpServletResponse res,AttInfo att,UnitInfo unit) throws Exception{

      ModelAndView m = new ModelAndView();
      m.setViewName("android");
	   
	  res.setCharacterEncoding("UTF-8");
      PrintWriter out = res.getWriter();    
  
      strToday = df.format(c.getTime());
      int unitInfo=0;

        
       //단위기간 구하기(unitInfo)
      List<UnitInfo> list = new ArrayList<>();
      list = biz.getAll();
      
      for(UnitInfo u : list) {
         
         if(strToday.compareTo(u.getEnd_date())==-1) {
            unitInfo = u.getUnit();
            break;
         }
         
      }
      
     //지각,조퇴,결석,출석 정보 받기   
      
     unit.setUnit(unitInfo);
     
     DateInfo di = biz.getDateInfo(unit);
     
     m.addObject("start",  di.getStart_date());
     m.addObject("end",  di.getEnd_date());
     m.addObject("sum", di.getTotal());
     
     System.out.println(di.getTotal());
     
      
     att.setUnit(unitInfo);
     List<AttResult> list2 = new ArrayList<>();
     list2 = biz.getMyView(att);
     
     m.addObject("unit",unitInfo);
     m.addObject("chul",0);
     m.addObject("gyul",0);
     m.addObject("jo",0);
     m.addObject("ji",0);
  

     for(AttResult a : list2) {
    	 
    	if(a.getResult().equals("출석")) {
    		m.addObject("chul",a.getCount());
    	}
    	else if(a.getResult().equals("결석")) {
    		 m.addObject("gyul",a.getCount());
    		
    	}
    	else if(a.getResult().equals("조퇴")) {
    		 m.addObject("jo",a.getCount());
    	}
    	else if(a.getResult().equals("지각")) {
    		  m.addObject("ji",a.getCount());
    		
    	}
    	 
     }
     
     
     //전체 퍼센트 넘겨주기
     int percent = biz.getTotal(att.getId()).getPercent();
     m.addObject("total", percent);
 
      
      return m;
	  
	 
	  
	   
   }
   
   
   //관리자_출결 정보 페이지
   @RequestMapping("/webview2.do")
   @ResponseBody		
   public void webview2(HttpServletResponse res,AttInfo att) throws Exception{
      
	 // System.out.println(att.getId());
	  
	  List<AttResult> list = new ArrayList<>();
	  list = biz.getResult();
	  String name="";

	 
	  JSONArray ja = new JSONArray();
	  
	  for(AttResult ar : list){
		  name = biz.getName(ar.getId());
		
		  JSONObject jo = new JSONObject();
		  jo.put("name",name);
		  jo.put("y",ar.getPercent());		  
		  jo.put("drilldown",name);		  
		  
		  ja.add(jo);
		  
	  }
	  

		res.setCharacterEncoding("UTF-8");
		res.setContentType("application/json");
		PrintWriter out = res.getWriter();
		out.print(ja.toJSONString());
		out.close();
	  
		System.out.println(ja.toJSONString());
	  
	  
	  
   }
   
   
   @RequestMapping("/webview3.do")
   @ResponseBody		
   public void webview3(HttpServletResponse res,AttInfo att) throws Exception{
      

	   List<String> list = new ArrayList<>();
	   List<AttResult> list2 = new ArrayList<>();
	   list = biz.getId();
	   String name="";
	   
	   JSONArray ja = new JSONArray();
	   
	   
	   for(String s : list) {
		   
		   JSONObject jo = new JSONObject();
		   name = biz.getName(s);
		   jo.put("name",name);
		   jo.put("id", name);
		   
		   list2 =  biz.getPesonal(s);
		   JSONArray ja_sub = new JSONArray();
		   for(AttResult r : list2) {
			   JSONArray ja_sub2 = new JSONArray();
			   ja_sub2.add(r.getResult());
			   ja_sub2.add(r.getCount());
			   
			   ja_sub.add(ja_sub2);
			   
		   }
		   
		   jo.put("data", ja_sub);
		   
		   ja.add(jo);
		   
	   }
	   
	   
	    res.setCharacterEncoding("UTF-8");
		res.setContentType("application/json");
		PrintWriter out = res.getWriter();
		out.print(ja.toJSONString());
		out.close();
	  
		System.out.println(ja.toJSONString());
	   
	 
	  
	  
	  
   }
   
   
   
   
   
   
   
   
   
   
   
   
   
}


