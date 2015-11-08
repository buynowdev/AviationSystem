package com.zhao.aviationsystem;

import java.util.Scanner;

/**
 * 录入类
 * 实现录入的功能
 * @author zhao
 *
 */
public class Write {
	static Scanner sc;
	public static void write(){
		sc=new Scanner(System.in);
		while(true){
			switch (opt()) {
			case 1:
				addUserInfo();//添加用户信息
				break;
			case 2:
				addFlightInfo();//添加航班信息
			case 0:
				return ;
			default:
				System.err.println("输入错误 请重试!");
			}
		}
	}
	/**
	 * 添加航班信息
	 */
	private static void addFlightInfo() {
		String  str="y";
		/**
		 * 通过循环加入航班信息 输入N 或 n 时结束录入
		 */
		while(!(str.equals("N")&&str.equals("n"))){
			System.out.println("请输入航班名称:");
			String id=sc.nextLine();
			System.out.println("请输入航班荷载人数");
			int amount=sc.nextInt();
			System.out.println("请输入出发城市:");
			String origin=sc.nextLine();
			System.out.println("请输入目的地:");
			String destination=sc.nextLine();
			System.out.println("请输入起飞日期和时间:");
			System.out.println("年:");
			int year=sc.nextInt();
			System.out.println("月");
			int month=sc.nextInt();
			System.out.println("日");
			int day=sc.nextInt();
			System.out.println("时");
			int hour=sc.nextInt();
			System.out.println("分");
			int minute=sc.nextInt();
			
			Time time=new Time(year, month, day, hour, minute);
			Flight flight=Flight.newInstance(id, amount, origin, destination, time);
			if(Flight.allFlight.containsKey(flight.getId())){
				System.err.println("航班加入重复!");
			}else{
				Flight.allFlight.put(flight.getId(), flight);
				System.out.println("加入"+flight);
				System.out.println("录入成功!");
			}
			System.out.println("是否继续添加航班信息?(结束录入输入N/n");
			str=sc.nextLine();
		}
	}
	/**
	 * 添加乘客信息
	 */
	private static void addUserInfo() {
		
	}
	/**
	 * 选项菜单
	 * @return 选项值
	 */
	public static int opt(){
		int opt;
		System.out.println("1.添加用户信息;");
		System.out.println("2.添加航班信息;");
		System.out.println("0.返回;");
		opt=sc.nextInt();
		return opt;
	}
	public static void main(String[] args) {
		write();
	}
}
