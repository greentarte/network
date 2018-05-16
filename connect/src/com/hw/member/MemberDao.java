package com.hw.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hw.frame.DaoforMember;
import com.hw.mapper.MemberMapper;
import com.hw.vo.Member;
import com.hw.vo.UnitInfo;
import com.hw.vo.AttInfo;
import com.hw.vo.AttResult;
import com.hw.vo.DateInfo;


@Repository("memberDao")
public class MemberDao implements DaoforMember<Member, String, UnitInfo, AttInfo, AttResult,DateInfo> {

	@Autowired
	MemberMapper mapper;

	@Override
	public String select(String s) {
		return mapper.select(s);
	}

	@Override
	public int insertMember(Member t) {
		return mapper.insertMember(t);
	}

	@Override
	public List<UnitInfo> selectAll() {
		return mapper.selectAll();
	}

	@Override
	public int insertData9(AttInfo a) {
		return mapper.insertData9(a);
	}

	@Override
	public int updateData2(AttInfo a) {
		return mapper.updateData2(a);
		
	}

	@Override
	public int updateData6(AttInfo a) {
		return mapper.updateData6(a);
	}

	@Override
	public String selectName(String s) {
		return mapper.selectName(s);
	}

	@Override
	public AttInfo selectTime(AttInfo a) {
		return mapper.selectTime(a);
	}

	@Override
	public int updateResult(AttInfo a) {
		return mapper.updateResult(a);
	}

	@Override
	public List<AttInfo> selectAttData(AttInfo a) {
		return mapper.selectAttData(a);
	}

	@Override
	public List<AttResult> selectResult() {
	
		return mapper.selectResult();
	}

	@Override
	public List<String> selectId() {
		return mapper.selectId();
	}

	@Override
	public List<AttResult> selectPersonal(String s) {
		return mapper.selectPersonal(s);
	}

	@Override
	public List<AttResult> selectMyView(AttInfo a) {
		return mapper.selectMyView(a);
	}

	@Override
	public AttResult selectTotal(String s) {
		return mapper.selectTotal(s);
	}

	@Override
	public DateInfo selectDateInfo(UnitInfo u) {
		return mapper.selectDateInfo(u);
	}


	
	
}











