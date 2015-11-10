package com.zhao.aviationsystem;

import java.io.Serializable;
import java.util.Iterator;
import java.util.TreeMap;

/**
 * 用户类
 * @author zhao
 *
 */
public class User implements Comparable<User>,Serializable{
	
	private static final long serialVersionUID = 1L;
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
	public boolean orderFlight(String id){
		Flight flight;
		if(!(Flight.containsKey(id))){
			System.err.println("无此航班");
			return false;
		}
		flight=Flight.getFlight(id);
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
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "姓名:"+this.name+"        ID:"+this.id ;
	}
	/**
	 * 显示该乘客所订的所有航班
	 */
	public void disAllFlight(){
		Iterator<String> it= allFlight.keySet().iterator();
		while(it.hasNext()){
			System.out.println(allFlight.get(it.next()));
		}
	}
	public static User getUser(int id){
		if(allUser.containsKey(id))
			return allUser.get(id);
		System.err.println("无该乘客");
		return null;
	}
	/**
	 * 显示一个用户的信息
	 * @param id
	 */
	public static void disUser(int id){
		User user=getUser(id);
		if(user!=null){
			System.out.println(user);
			System.out.println("该乘客订的飞机:");
			user.disAllFlight();
		}
	}
	/**
	 * 显示所有用户的信息 包括所订的飞机
	 */
	public static void disAllUser(){
		Iterator<Integer> it=allUser.keySet().iterator();
		while(it.hasNext()){
			User user=allUser.get(it.next());
			System.out.println(user);
			Iterator<String> it2=user.allFlight.keySet().iterator();
			System.out.print("    该用户订的飞机:");
			while(it2.hasNext()){
				System.out.print("["+user.allFlight.get(it2.next()).getId()+"]    ");
			}
			System.out.println();
		}
	}
	/**
	 * 删除一个用户
	 * @param id
	 * @return
	 */
	public static boolean deleteUser(int id){
		if(allUser.containsKey(id)){
			allUser.remove(id);
			System.out.println("删除成功!");
			return true;
		}
		System.err.println("错误:无此用户!");
		return false;
	}
	/**
	 * 退票
	 */
	public boolean deleteFlight(String id){
		if(Flight.allFlight.containsKey(id)){
			if(this.allFlight.containsKey(id)){
				this.allFlight.remove(id);
				Flight.allFlight.get(id).deleteUser(this);
				System.out.println("删除成功!");
				return true;
			}
			System.err.println("该用户未订该趟航班!");
			return false;
		}
		System.out.println("无该航班!");
		return false;
	}
}
