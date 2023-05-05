package com.algorithm.sorting;

public class InsertionSort {
	public static void main(String[] args) {
		int[] array = {9,2,4,2,4,6,7,5,9};//{12,54,65,7,23,9};//{7,2,91,77,3};
		System.out.println("Before sorting:");
		printArray(array);
		insertionSort(array);
		System.out.println("After sorting:");
		printArray(array);
	}
	/**
	 * Array is divided into unsorted and sorted subarrays.
	 * Steps:
	 * 1. 1st element from unsorted subarray is picked up and 
	 *    kept in the sorted subarray at the right place.
	 */
	private static void insertionSort(int[] array) {
		for(int i=1; i<array.length; i++) {
			int j = i-1;
			int t = array[i];
			while(j>=0 && array[j] > t) {
				array[j+1] = array[j];
				j--;
			}
			array[j+1] = t;
		}
	}

	private static void printArray(int[] array) {
		for(int i=0; i<array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}
