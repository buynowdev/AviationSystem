package com.zhao.aviationsystem;

import java.util.TreeMap;
import java.util.TreeSet;

/**
 * 航班类
 * @author zhao
 * @日期 2015-11-8 17:24
 * 用newInstance()方法来创建实例
 */
public class Flight implements Comparable<Flight> {
	public  static TreeMap<String,Flight> allFlight;//所有的航班
	public static TreeMap<Integer,User> allUser;//所有订该航班的乘客
	private String id;//航班的班次名称 
	private int amount;//该趟航班的荷载人数
	private int orderCount;//以被订的数量
	private String origin;//航班的起点
	private String destination;//航班的目的地
	private Time time;//航班时间
	static{//初始化allFlight和allUser
		allFlight = new TreeMap<String, Flight>();
	}
	/**
	 * 构造一个空的航班
	 */
	private Flight(String id,int amount,String origin,String destination,Time time) {
		this.id=id;
		this.amount=amount;
		this.origin=origin;
		this.destination=destination;
		this.time=time;
		orderCount=0;
		allUser=new TreeMap<Integer,User>();
	}
	
	/**
	 * 构造一个航班
	 * @param orderCount 已经被订的数量 
	 */
/*	private Flight(String id,int amount,String origin,String destination,Time time,int orderCount ){
		this.id=id;
		this.amount=amount;
		this.origin=origin;
		this.destination=destination;
		this.orderCount=orderCount;		
		this.time=time;
		allUser=new TreeMap<Integer,User>();
	}
*/	/**
	 * 新建一个航班实例
	 * @param id 航班班次
	 * @param amount 航班核定载客数量
	 * @param orderCount 已经被顶票数量
	 * @return 一个新的航班实例
	 */
/*	public static Flight NewInstance(String id,int amount,String origin,String destination,Time time,int orderCount){
		if(orderCount>amount){
			new OrderCountOutOfAmount();
			return null;
		}
		Flight flight= new Flight(id,amount,origin,destination,time,orderCount);
		Flight.allFlight.put(id, flight);//添加到图中
		return flight;
	}*/
	/**
	 * 新建一个航班实例<br/>
	 * 检测是否含有重复的航班名称
	 * @param id 航班班次
	 * @param amount 航班核定载客数量
	 * @return 一个新的航班实例
	 */
	public static Flight newInstance(String id,int amount,String origin,String destination,Time time){
		if(allFlight.containsKey(id)){
			System.err.println("航班名称重复 请重试!");
			return null;
		}
		Flight flight= new Flight(id,amount,origin,destination,time);
		Flight.allFlight.put(id, flight);
		return flight;
	}
	/**
	 * 以时间来对航班
	 */
	@Override
	public int compareTo(Flight o) {
		
		return this.time.compareTo(o.getTime());
	}
	/**
	 * 添加乘客 
	 * 添加成功返回true 
	 * 失败返回false
	 * @param user
	 */
	public boolean addUser(User user){
		/**
		 * 检测是否有重复的乘客
		 */
		if (!this.allUser.containsKey(user.getId())&&(orderCount<amount)) {
			allUser.put(user.getId(), user);
			orderCount++;
			return true;
		}else{
			System.err.println("该乘客已经订该趟航班!");
			return false;
		}
	}
	/**
	 * 减少乘客
	 */
	public void DeleteUser(User user){
		/**
		 * 检查是否有该乘客
		 */
		if(this.allUser.containsKey(user.getId())){
			allUser.remove(user.getId());
			orderCount--;
		}
	}
	/**
	 * 各种get 和set
	 * 起飞时间 可以修改
	 * @return
	 */
	
	public Time getTime() {
		return time;
	}
	
	public void setTime(Time time) {
		this.time = time;
	}
	
	public String getId() {
		return id;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public int getOrderCount() {
		return orderCount;
	}
	
	public String getOrigin() {
		return origin;
	}
	
	public String getDestination() {
		return destination;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "航班:"+this.id+"        起点:"+this.origin+"       目的地:"+this.destination+"       时间:"+time;
	}
}
