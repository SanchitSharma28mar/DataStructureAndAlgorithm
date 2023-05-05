package com.algorithm.sorting;

/**
 * Input array is divided into unsorted and sorted array.
 * EVery iteration/pass, selects the lowest element from unsorted array
 * and puts them at the end of sorted array.
 */
public class SelectionSort {
	public static void main(String[] args) {
//		int[] array = {1,2,3,4,5,6,7,8,9};
//		int[] array = {9,2,4,2,4,6,7,5,9};
		int[] array = {12,54,65,7,23,9};//{7,2,91,77,3};
		System.out.println("Before sorting:");
		printArray(array);
		selectionSort(array);
		System.out.println("After sorting:");
		printArray(array);
	}
	private static void selectionSort(int[] array) {
		for(int i=0; i<array.length; i++) {
			System.out.println("Current element to consider-"+array[i]);
			int minIndex = i;
			System.out.println("Min="+array[minIndex]+" at index="+minIndex);
			for(int j=i+1; j<array.length; j++) {
				if(array[j] < array[minIndex]) {
					minIndex = j;
					System.out.println("New Min="+array[minIndex]+" at index="+minIndex);
				}
			}
			System.out.println("Swap min="+array[minIndex]+" which is at index="+minIndex+
					" and array element="+array[i]+" which is at index="+i);
			int temp = array[i];
			array[i] = array[minIndex];
			array[minIndex] = temp;
		}
	}
	private static void printArray(int[] array) {
		for(int i=0; i<array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}
