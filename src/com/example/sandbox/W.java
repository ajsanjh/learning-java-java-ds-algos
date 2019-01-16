package com.example.sandbox;

import java.util.Arrays;

public class W {

	public static void main(String[] args) {
		
		String data1 = "ABCA";
		String data2 = "BCABA";	
		String data3 = "ABC";
		
		String s = execute(data1);
		System.out.println(s);
		
	}

	
	
	/**
	 * return the first recurring character from any string
	 */
	public static String execute(String s) {
		String result = null;
		
		
		char[] c = s.toCharArray();
		Arrays.sort(c);
		for (int i = 0; i < c.length-1; i++) {
			if(c[i] == c[i+1]) {
				result = Character.toString(c[i]);
			}
		}
		
		return result;
	}
	
	
	
	
}

