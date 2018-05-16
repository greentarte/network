package com.hw.mapper;

import java.util.List;

import com.hw.vo.Member;
import com.hw.vo.UnitInfo;
import com.hw.vo.AttInfo;
import com.hw.vo.AttResult;
import com.hw.vo.DateInfo;


public interface MemberMapper {

	public String select(String id);
	
	public int insertMember(Member member);
	
	public List<UnitInfo> selectAll();
	
	public int insertData9(AttInfo att);
	
	public int updateData2(AttInfo att);
	
	public int updateData6(AttInfo att);
	
	public String selectName(String id);
	
	public AttInfo selectTime(AttInfo att);
	
	public int updateResult(AttInfo att);
	
	public List<AttInfo> selectAttData(AttInfo att);
	
	public List<AttResult> selectResult();
	
	public List<String> selectId();
	
	public List<AttResult> selectPersonal(String id);
	
	public List<AttResult> selectMyView(AttInfo att);
	
	public AttResult selectTotal(String id);
	
	public DateInfo selectDateInfo(UnitInfo unit);
	

}
