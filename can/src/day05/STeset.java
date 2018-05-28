package day05;

import gnu.io.NoSuchPortException;

public class STeset {

	public static void main(String[] args) {
		
		try {
			SerialManager sm = new SerialManager();
		} catch (NoSuchPortException e) {
			System.out.println("connection fail");
			e.printStackTrace();
		}
		

	}

}
