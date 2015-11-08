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
	
	public User(String name,int id) {
		this.name=name;
		this.id=id;
		allFlight=new TreeMap<String,Flight>();
	}
	/**
	 * 订购一趟航班
	 * 不可以重复买票
	 * 不可以订购满仓的航班
	 * @param flight
	 * @return 订购成功返回true 失败返回false
	 */
	public boolean addFlight(Flight flight){
		if(allFlight.containsKey(flight.getId())){
			System.err.println("请勿重复买票!");
			return false;
		}else{
			if(flight.addUser(this)){
				allFlight.put(flight.getId(), flight);
				return true;
			}else{
				return false;
			}
		}
	}
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
