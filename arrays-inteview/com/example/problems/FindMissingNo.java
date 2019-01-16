package com.example.problems;

import java.util.Arrays;
import java.util.Random;

/**
 * find a missing no in array of 1 to 100
 * @author AJ
 *
 */
public class FindMissingNo {

	public static void main(String[] args) {
		int[] arr = new int[] {1,2,3,4,5,6};
		
		int l = 0;
		int a = 0;
		int middle = arr[a];
		for (int i = 0; i < arr.length; i++) {
			l++;
			if(l%2 == 0	) {
				middle = arr[++a];
			}
		}
		System.out.println(middle);
		
		
	}
	
	
}
