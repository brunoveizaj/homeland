package com.homeland.ui.models;

import java.io.Serializable;



public class EntityCounter implements Serializable{


	private static final long serialVersionUID = 1L;

	Class<?> T;
	long totalCnt;
	long todayCnt;
	
	
	public EntityCounter() {}
	
	public EntityCounter(Class<?> t, long totalCnt, long todayCnt) {
		super();
		T = t;
		this.totalCnt = totalCnt;
		this.todayCnt = todayCnt;
	}


	public Class<?> getT() {
		return T;
	}
	public void setT(Class<?> t) {
		T = t;
	}
	public long getTotalCnt() {
		return totalCnt;
	}
	public void setTotalCnt(long totalCnt) {
		this.totalCnt = totalCnt;
	}
	public long getTodayCnt() {
		return todayCnt;
	}
	public void setTodayCnt(long todayCnt) {
		this.todayCnt = todayCnt;
	}
	
	
	
	
}
