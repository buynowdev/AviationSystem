package com.zhao.aviationsystem;

import java.util.Scanner;

/**
 * 主类
 * @author zhao
 *
 */
public class Main {
	static Scanner sc;
	static {
		sc=new Scanner(System.in);
	}
	public static void main(String[] args) {
		
		mainMenu();
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
				/*
				 * 退出前加入保持数据
				 * 使用Object流将用户表和飞机表全部保存到文件
				 */
				return ;
			default:
				break;
			}
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
