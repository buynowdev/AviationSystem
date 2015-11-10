package com.zhao.aviationsystem;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class Text implements Serializable {
	public static void main(String[] args) {
		FileOutputStream fos;
		ObjectOutputStream oos;
		try {
			fos=new FileOutputStream("log.txt");
			oos=new ObjectOutputStream(fos);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
