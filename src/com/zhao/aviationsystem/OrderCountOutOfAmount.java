package com.zhao.aviationsystem;
/**
 * 自己构建一个异常类 当机票的航班订票数超过额定载客量时抛出异常
 * @author zhao
 *
 */
public class OrderCountOutOfAmount extends Exception {
	public OrderCountOutOfAmount() {
		// TODO Auto-generated constructor stub
		super("航班票量不足");
		System.err.println("机票数量不足 ");
	}
}
