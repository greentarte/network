package com.hw.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hw.frame.Dao;
import com.hw.mapper.MemberMapper;
import com.hw.vo.Member;

@Repository("memberDao")
public class MemberDao implements Dao<Member, String> {

	@Autowired
	MemberMapper mapper;
	// ¸â¹ö ¸ÊÆÛ¸¦ ÂüÁ¶ÇÏ°Ú´Ù mybatis

	@Override
	public void insert(Member m) {
		mapper.insert(m);
	}

	@Override
	public void delete(String s) {
		mapper.delete(s);
	}

	@Override
	public void update(Member m) {
		mapper.update(m);
	}

	@Override
	public Member select(String s) {
		return mapper.select(s);
	}

	@Override
	public List<Member> select() {
		return mapper.selectall();
	}

}
