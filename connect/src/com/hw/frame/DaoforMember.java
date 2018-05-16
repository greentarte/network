package com.hw.frame;

import java.util.List;

import com.hw.vo.AttInfo;
import com.hw.vo.AttResult;
import com.hw.vo.DateInfo;
import com.hw.vo.UnitInfo;


public interface DaoforMember<T,S,U,A,R,D> {

	public S select(S s);
	
	public int  insertMember(T t);

	public List<U> selectAll();
	
	public int insertData9(A a);
	
	public int updateData2(A a);
	
	public int updateData6(A a);
	
	public S selectName(S s);
	
	public A selectTime(A a);
	
	public int updateResult(A a);
	
	public List<A> selectAttData(A a);
	
	public List<R> selectResult();
	
	public List<S> selectId();
	
	public List<R> selectPersonal(S s);
	
	public List<R> selectMyView(A a);
	
	public R selectTotal(S s);
	
	public D selectDateInfo(U u);
}
