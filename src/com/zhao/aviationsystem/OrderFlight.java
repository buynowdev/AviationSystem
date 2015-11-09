package com.zhao.aviationsystem;

import java.util.Scanner;

/**
 * 订票类
 * @author zhao
 *
 */
public class OrderFlight {
	static Scanner sc;
	static {
		sc=new Scanner(System.in);
	}
	public static void orderFlight(){
		while(true){
			int uId;
			System.out.println("=====订票=====");
			User.disAllUser();
			System.out.println("请输入要订票的用户id:");
			uId=sc.nextInt();
			if(User.allUser.containsKey(uId)){
				User user=User.allUser.get(uId);
				String opt="y";
				while(true){
					String opt2="y";
					Query.queryAllFlight();
					System.out.println("请选择航线,输入其名称");
					String fId=sc.next();
					user.orderFlight(fId);
					System.out.println("是否继续,退出输入N或n");
					opt2=sc.next();
					if(opt2.equals("n")||opt2.equals("N")){
						break;
					}
				}
				System.out.println("是否继续,退出输入N或n");
				opt=sc.next();
				if(opt.equals("n")||opt.equals("N")){
					break;
				}
				
			}
		}
		
	}
}
