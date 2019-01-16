package demo;

import java.util.Arrays;

public class BubbleSort {

	
	
	public static void main(String[] args) {
		
		int[] arr = new int[] {4, 7, 2, 8, 2, 6, 5, 3};

		
		for (int i = 0; i < arr.length; i++) {
			boolean bf = true;
			System.out.println("pass: " + (i+1));
			for (int j = 1; j < arr.length; j++) {
				if(arr[j-1] > arr[j]) {
					int x = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = x;
					bf = false;
				}
			}
			if(bf) break;
		}
		
		System.out.println(Arrays.toString(arr));
		
		
	}
	
	
	
	
	
	
	
}
