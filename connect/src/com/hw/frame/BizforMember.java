package com.hw.frame;

import java.util.List;

//기능이 정의되어 있음
public interface BizforMember<T,S,U,A,R,D> {

	public S get(S s);
	public int register(T t);
	public List<U> getAll();
	public int register9(A a);
	public int modify2(A a);
	public int modify6(A a);
	public S getName(S s);
	public A getTime(A a);
	public int modifyResult(A a);
	public List<A> getAttData(A a);
	public List<R> getResult();
	public List<S> getId();
	public List<R> getPesonal(S s);
	public List<R> getMyView(A a);
	public R getTotal(S s);
	public D getDateInfo(U u);
	
}
