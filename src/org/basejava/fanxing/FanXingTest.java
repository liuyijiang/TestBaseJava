package org.basejava.fanxing;

import java.util.ArrayList;
import java.util.List;

public class FanXingTest<T> {

	private T t;
	private List<T> list;
	
	public FanXingTest(T t){
		this.t = t;
		list = new ArrayList<T>();
	}
	
	public T createT(){
		return t;
	}
	
	public void add(T t){
		list.add(t);
	}
	
	public List<T> getList(){
		return list;
	}
	
}
