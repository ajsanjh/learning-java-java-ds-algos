package demo;

import java.util.Arrays;

public class MergeSort {


	public static void main(String[] args) {
		int[] arr = {3,1,2,5,6};
		new Sort().sort(arr);
		
		System.out.println(Arrays.toString(arr));
	}

	private static class Sort {
		private void sort(int[] arr) {
			this.sort(arr, 0, arr.length-1);
		}

		private void sort(int[] arr, int leftIndex, int rightIndex) {
			
			if(leftIndex < rightIndex) {
				
				//find middle index
				int middleIndex = (leftIndex + rightIndex)/2;
				
				// recurse over sort to do sort and merge
				sort(arr, leftIndex, middleIndex);
				sort(arr, middleIndex+1, rightIndex);
				
				// merge
				merge(arr, leftIndex, middleIndex, rightIndex);
			}
		}

		private void merge(int[] arr, int leftIndex, int middleIndex, int rightIndex) {

			int leftArrayLength = middleIndex - leftIndex + 1;
			int rightArrayLength = rightIndex - middleIndex;
			
			int[] leftArray = new int[leftArrayLength];
			int[] rightArray = new int[rightArrayLength];
			
			for (int i = 0; i < leftArrayLength; i++) {
				leftArray[i] = arr[leftIndex + i];
			}
			for (int i = 0; i < rightArrayLength; i++) {
				rightArray[i] = arr[middleIndex + i + 1];
			}
			
			int i = 0, j = 0, k = leftIndex;
			
			while(i < leftArrayLength && j < rightArrayLength) {
				arr[k++] = leftArray[i] <= rightArray[j] ?
						leftArray[i++] : rightArray[j++];
			}
			
			while(i < leftArrayLength) {
				arr[k++] = leftArray[i++];
			}
			while(j < rightArrayLength) {
				arr[k++] = rightArray[j++];
			}
		}
	}
}

