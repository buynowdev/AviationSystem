package com.zhao.aviationsystem;

import java.io.Serializable;
import java.util.TreeMap;

/**
 * 保存类
 * @author zhao
 *
 */
public class Save implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TreeMap allUser;
	private TreeMap allFlight;
	
	public TreeMap getAllUser() {
		return allUser;
	}

	public void setAllUser(TreeMap allUser) {
		this.allUser = allUser;
	}

	public TreeMap getAllFlight() {
		return allFlight;
	}

	public void setAllFlight(TreeMap allFlight) {
		this.allFlight = allFlight;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Save(){
		this.allFlight=Flight.allFlight;
		this.allUser=User.allUser;
	}
}
