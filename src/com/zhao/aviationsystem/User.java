package com.zhao.aviationsystem;

import java.util.TreeMap;

/**
 * 用户类
 * @author zhao
 *
 */
public class User implements Comparable<User>{
	private String name;//用户姓名
	private int id;//用户id 不可重复
	public TreeMap<String,Flight> allFlight; //用户所定航班的班次
	@Override
	public int compareTo(User o) {
		return this.name.compareTo(o.getName());
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	
}
