package com.zhao.aviationsystem;

import java.util.TreeMap;

/**
 * 用户类
 * @author zhao
 *
 */
public class User implements Comparable<User>{
	public static TreeMap<Integer,User> allUser;
	private String name;//用户姓名
	private int id;//用户id 不可重复
	public TreeMap<String,Flight> allFlight; //用户所定航班的班次
	
	static {
		allUser= new TreeMap<Integer,User>();//初始化用户列表
	}
	private User(String name,int id) {
		this.name=name;
		this.id=id;
		allFlight=new TreeMap<String,Flight>();
	}
	/**
	 * 添加用户
	 * 并检测是否有重复的id
	 * 如果未重复加入用户列表
	 * @param name 用户姓名
	 * @param id 用户id
	 * @return 用户实例
	 */
	public static User newInstance(String name,int id){
		if(allUser.containsKey(id)){
			System.err.println("用户添加失败,用户id重复;");
			return null;
		}else{
			User user=new User(name,id);
			allUser.put(id, user);
			System.out.println("添加用户成功!");
			return user;
		}
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
