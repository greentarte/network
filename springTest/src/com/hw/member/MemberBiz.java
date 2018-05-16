package com.hw.member;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hw.frame.Biz;
import com.hw.frame.Dao;
import com.hw.vo.Member;

//	Biz�� ���׸� ���¿� ù��° �Ű��������� VO��ü,  �ι�° �Ű������� Primary Key���� ���¿� �°� �����ؼ� ����
@Service("memberBiz")
public class MemberBiz implements Biz<Member, String> {

	// Resource�� AutoWired�� ����� ���
	@Resource(name = "memberDao")
	Dao<Member, String> dao;

	@Transactional // �ڵ� Ʈ������ ó�� �����Ͱ� �ٲ�
	@Override
	public void register(Member m) {
		dao.insert(m);
	}

	@Transactional
	@Override
	public void remove(String s) {
		dao.delete(s);
	}

	@Transactional
	@Override
	public void modify(Member m) {
		dao.update(m);

	}

	@Override
	public Member get(String s) {
		
		return dao.select(s);
	}

	@Override
	public List<Member> get() {
		
		return dao.select();
	}

}
