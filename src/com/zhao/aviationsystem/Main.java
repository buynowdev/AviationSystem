package com.zhao.aviationsystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * 主类
 * @author zhao
 *
 */
public class Main {
	static File fileUser=new File("./src/com/zhao/aviationsystem/User.log");
	static File fileFlight=new File("./src/com/zhao/aviationsystem/Flight.log");
	
	static Scanner sc;
	static {
		sc=new Scanner(System.in);
	}
	public static void main(String[] args) {
		/* 启动前读取数据
		 * 退出前加入保持数据
		 * 使用Object流将用户表和飞机表全部保存到文件
		 */
		read();
		mainMenu();
		save();
	}
	/**
	 * 主菜单调用各种功能函数
	 */
	public static void mainMenu(){
		int opt=1;
		while(opt!=0){
			opt=menuOpt();
			switch (opt) {
			case 1:
				Query.query();
				break;
			case 2:
				OrderFlight.orderFlight();
				break;
			case 3:
				DeleteFlight.deleteFlight();
				break;
			case 4:
				Write.write();
				break;
			case 5:
				System.err.println("需要管理员权限!");
				break;
			case 0:
				return ;
			default:
				break;
			}
		}
	}
	/**
	 * 保存数据
	 */
	public static void save(){
		FileOutputStream fosUser;
		FileOutputStream fosFlight;
		ObjectOutputStream oosUser;
		ObjectOutputStream oosFlight;
		try {
			fosUser=new FileOutputStream(fileUser);
			fosFlight=new FileOutputStream(fileFlight);
			oosUser=new ObjectOutputStream(fosUser);
			oosFlight=new ObjectOutputStream(fosFlight);
			oosUser.writeObject(User.allUser);
			oosFlight.writeObject(Flight.allFlight);
			oosFlight.flush();
			oosUser.flush();
			oosFlight.close();
			oosUser.close();
			fosUser.close();
			fosFlight.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * 读取数据
	 */
	public static void read(){
		FileInputStream fisUser;
		FileInputStream fisFlight;
		ObjectInputStream oisUser;
		ObjectInputStream oisFlight;
		try {
			fisUser=new FileInputStream(fileUser);
			oisUser=new ObjectInputStream(fisUser);
			@SuppressWarnings("unchecked")
			TreeMap<Integer,User> allUser=(TreeMap<Integer,User>)oisUser.readObject();
			if(allUser!=null){
				System.out.println("========乘客数据导入成功=======");
				User.allUser=allUser;
			}
			oisUser.close();
			fisUser.close();
			
			fisFlight=new FileInputStream(fileFlight);
			oisFlight=new ObjectInputStream(fisFlight);
			@SuppressWarnings("unchecked")
			TreeMap<String,Flight> allFlight=(TreeMap<String,Flight>)oisFlight.readObject();
			if(allFlight!=null){
				System.out.println("========航班数据导入成功=======");
				Flight.allFlight=allFlight;
			}
			oisFlight.close();
			fisFlight.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * 菜单选项
	 * @return 返回选项
	 */
	public static int menuOpt(){
		//选项
		int opt;
		System.out.println("****************");
		System.out.println("* 飞 机 订 票 系 统 * ");
		System.out.println("****************");
		System.out.println("*功能菜单:             *");
		System.out.println("*1.查询                  *");
		System.out.println("*2.订票                  *");
		System.out.println("*3.退票                  *");
		System.out.println("*4.录入                  *");
		System.out.println("*5.修改航班信息    *");
		System.out.println("*0.退出;                 *");
		System.out.println("****************");
		System.out.print("请输入选择:");
		opt=sc.nextInt();
		return opt;
	}
}

