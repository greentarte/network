package com.hw.mapper;

import java.util.List;

import com.hw.vo.Member;

public interface MemberMapper {
	public void insert(Member obj);
	public void delete(String email);
	public void update(Member obj);
	public Member select(String email);
	public List<Member> selectall();
}
