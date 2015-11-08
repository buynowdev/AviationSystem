package com.zhao.aviationsystem;

public class Text {
	public static void main(String[] args) {
		Flight flight=Flight.newInstance("A388", 350, "长沙", "三亚", new Time(2015, 11, 11, 11, 11));
		System.out.println(flight);
	}
}
