package demo;

import java.util.Arrays;

public class SelectionSort {


	public static void main(String[] args) {

		int[] arr = new int[] {4, 7, 2, 8, 2, 6, 5, 3};

		int n = arr.length;



		for (int i = 0; i < n-1; i++) {
			int minIdx = i;
			for (int j = i+1; j < n; j++) {
				if(arr[minIdx] > arr[j]) {
					minIdx = j;
				}
			}
			int temp = arr[minIdx];
			arr[minIdx] = arr[i];
			arr[i] = temp;
		}

		System.out.println(Arrays.toString(arr));





	}


}
