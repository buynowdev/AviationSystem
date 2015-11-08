package com.zhao.aviationsystem;
/**
 * 时间类 记录时间
 * @author zhao
 *
 */
public class Time implements Comparable<Time> {
	private int year;
	private int month;
	private int day;
	private int hour;
	private int minute;
	private long count;//用来对比时间前后
	public Time(int year, int month, int day, int hour, int minute) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
		this.hour = hour;
		this.minute = minute;
		count=minute+(hour*60)+(hour*60*24)+(day*60*24*30)+(month*60*24*30*12)+((year-2000)*60*24*30*12*365);
	}
	
	public long getCount() {
		return count;
	}
	@Override
	public int compareTo(Time o) {
		int num=(int) (this.count-o.getCount());
		return num;
	}
	
}
