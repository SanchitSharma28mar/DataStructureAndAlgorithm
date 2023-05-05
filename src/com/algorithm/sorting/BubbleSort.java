package com.algorithm.sorting;

public class BubbleSort {
	public static void main(String[] args) {
//		int[] array = {1,2,3,4,5,6,7,8,9};
//		int[] array = {9,2,4,2,4,6,7,5,9};
		int[] array = {12,54,65,7,23,9};//{7,2,91,77,3};
		System.out.println("Before sorting:");
		printArray(array);
		bubbleSort(array);
		bubbleSortAdaptive(array);
		bubbleSortTraditional(array);
		System.out.println("After sorting:");
		printArray(array);
	}
	private static void printArray(int[] array) {
		for(int i=0; i<array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	/**
	 * Largest element bubbles up to the end of he array with each pass of outer loop.
	 * Array is divided into sorted and unsorted array.
	 * 		Unsorted array on the left and sorted on the right.
	 * With each pass(i.e. iteration of the outer loop) of unsorted array
	 * 		largest element moves to the last index of unsorted array
	 * 		and next iteration is done till the index previous to the index the largest element had moved.
	 * The comparison and swap, if needed, happens using only inner loop
	 * 		Every adjacent element is compared.
	 * Stable algorithm
	 * Not adaptive by default.
	 * 		Adaptive means that sorting should end in 1st pass if array already sorted.
	 * Worst - O(n*2)
	 * Best - O(n*2)
	 */
	private static void bubbleSort(int[] array) {
		int n = array.length;
		for(int i=0; i<n; i++) {
			System.out.println("Number of pass "+(i+1));
			for(int j=0; j<n-1-i; j++) {
				//Only check the jth and the next element.
				if(array[j] > array[j+1]) {
					int temp = array[j+1];
					array[j+1] = array[j];
					array[j] = temp;
				}
			}
		}
	}
	private static void bubbleSortAdaptive(int[] array) {
		int n = array.length;
		boolean isSorted = true;
		for(int i=0; i<n; i++) {
			System.out.println("Number of pass "+(i+1));
			for(int j=0; j<n-1-i; j++) {
				//Only check the jth and the next element.
				if(array[j] > array[j+1]) {
					int temp = array[j+1];
					array[j+1] = array[j];
					array[j] = temp;
					isSorted = false;
				}
			}
			if(isSorted) {
				return;
			}
		}
	}
	/**
	 * Smallest element bubbles up to front of the array with each pass of the outer loop
	 */
	private static void bubbleSortTraditional(int[] array) {
		for(int i=0; i<array.length; i++) {
			for(int j=i+1; j<array.length; j++) {
				if(array[i] > array[j]) {
					int temp = array[j];
					array[j] = array[i];
					array[i] = temp;
				}
			}
		}
	}

}
