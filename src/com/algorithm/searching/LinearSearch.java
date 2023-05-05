package com.algorithm.searching;

public class LinearSearch {
	
	public static void main(String[] args) {
		int[] arr = new int[] {3,6,1,55,22,99,44,88,12};
		linearSearch(arr, 44);
	}

	private static void linearSearch(int[] arr, int element) {
		boolean found = false;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == element) {
				found = true;
				System.out.println("Element " + element + " found at position : " + i);
				break;
			}
		}
		if(!found) {
			System.out.println("Element " + element + " not found.");
		}
	}

}
