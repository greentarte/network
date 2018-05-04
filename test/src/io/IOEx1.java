package io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

public class IOEx1 {

	public static void main(String[] args) {
		byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
		byte[] outSrc=null;
		
		ByteArrayInputStream input =null;
		ByteArrayOutputStream output =null;
		
		input = new ByteArrayInputStream(inSrc);
		output = new ByteArrayOutputStream();
		
		int data =0;
		
		while((data=input.read()) !=-1) { //data가 없으면 -1 있으면
			output.write(data); //계속담고
		}
		
		outSrc=output.toByteArray(); //array로 변경하는 메소드
		
		System.out.println("Input Source : " + Arrays.toString(inSrc));
		System.out.println("Output Source : " +Arrays.toString(outSrc));
		
		

	}

}
