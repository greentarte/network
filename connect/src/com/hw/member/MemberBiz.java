package com.hw.member;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hw.frame.BizforMember;
import com.hw.frame.DaoforMember;
import com.hw.vo.UnitInfo;
import com.hw.vo.Member;
import com.hw.vo.AttInfo;
import com.hw.vo.AttResult;
import com.hw.vo.DateInfo;



@Service("memberBiz")
public class MemberBiz implements BizforMember<Member, String, UnitInfo, AttInfo, AttResult, DateInfo> {

	@Resource(name="memberDao")
	DaoforMember<Member, String, UnitInfo, AttInfo, AttResult,DateInfo> dao;

	
	@Transactional
	@Override
	public String get(String s) {
		return dao.select(s);
	}


	@Transactional
	@Override
	public int register(Member t) {
		return dao.insertMember(t);
	}


	@Override
	public List<UnitInfo> getAll() {
		return dao.selectAll();
	}


	@Override
	public int register9(AttInfo a) {
		return dao.insertData9(a);
	}


	@Override
	public int modify2(AttInfo a) {
		return dao.updateData2(a);
		
	}


	@Override
	public int modify6(AttInfo a) {
	   return dao.updateData6(a);
	}


	@Override
	public String getName(String s) {
		return dao.selectName(s);
	}


	@Override
	public AttInfo getTime(AttInfo a) {
		return dao.selectTime(a);
	}


	@Override
	public int modifyResult(AttInfo a) {
		return dao.updateResult(a);
		
	}


	@Override
	public List<AttInfo> getAttData(AttInfo a) {
		return dao.selectAttData(a);
	}


	@Override
	public List<AttResult> getResult() {
		return dao.selectResult();
	}


	@Override
	public List<String> getId() {
		return dao.selectId();
	}


	@Override
	public List<AttResult> getPesonal(String s) {
		return dao.selectPersonal(s);
	}


	@Override
	public List<AttResult> getMyView(AttInfo a) {
		return dao.selectMyView(a);
	}


	@Override
	public AttResult getTotal(String s) {
		return dao.selectTotal(s);
	}


	@Override
	public DateInfo getDateInfo(UnitInfo u) {
		return dao.selectDateInfo(u);
	}
	

}





