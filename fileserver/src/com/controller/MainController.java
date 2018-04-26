package com.controller;

import java.io.FileOutputStream;
import java.sql.Connection;

import org.apache.tiles.autotag.core.runtime.annotation.Parameter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class MainController {
	Connection conn;

	@RequestMapping("/main.do")
	public String main() {
		return "main";
	}
	@RequestMapping(value="/FileMultiPartController", method=RequestMethod.POST)
	public void FileMultiPartController(@RequestParam MultipartFile mf) {
		String filename = mf.getOriginalFilename();
	      byte[] data;
	      try(FileOutputStream fos = new FileOutputStream("c:/"+filename)){
	         data = mf.getBytes();
	         fos.write(data);
	      } catch (Exception e) {   
	         e.printStackTrace();
	      } 
	}
	

	// @RequestMapping("/chart1.do")
	// public String chart1(Model m) {
	// m.addAttribute("center", "chart1");
	// return "main";
	// }

	// @RequestMapping("/chart1impl.do")
	// @ResponseBody // data를 output로 보내겠다는 의미
	// public void chart1impl(HttpServletResponse res) throws Exception {
	//
	// Statement stmt = conn.createStatement(); ResultSet rs =
	// stmt.executeQuery("SELECT Year, Month, COUNT(*) " + "FROM airline_delay " +
	// "WHERE delayYear=2006 " + "AND Month IN (1,2,3,4) " + "AND ArrDelay > 0 " +
	// "GROUP BY Year, Month"); JSONArray ja = new JSONArray(); while (rs.next()) {
	// JSONArray data = new JSONArray(); // []안에 []를 생성 data.add(rs.getInt(2) +
	// "월"); data.add(rs.getInt(3)); // ["1월", 20000] ja.add(data); }
	// res.setCharacterEncoding("EUC-KR"); res.setContentType("application/json");
	// PrintWriter out = res.getWriter();
	//
	// out.print(ja.toJSONString()); out.close();
	//
	//
	// }

}
