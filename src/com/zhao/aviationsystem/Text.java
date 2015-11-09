package com.zhao.aviationsystem;

import java.util.TreeMap;

public class Text {
	public static void main(String[] args) {
		TreeMap map=new TreeMap();
		Flight flight=Flight.newInstance("A388", 350, "长沙", "三亚", new Time(2015, 11, 11, 11, 11));
		System.out.println(map.containsKey(flight.getId()));
	}
}
