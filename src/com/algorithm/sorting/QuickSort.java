package com.algorithm.sorting;

public class QuickSort {

	public static void main(String[] args) {
		int[] array = {9,2,4,2,4,6,7,5,9};//{12,54,65,7,23,9};//{7,2,91,77,3};
		System.out.println("Before sorting:");
		printArray(array);
		quickSort(array, 0, array.length-1);
		System.out.println("After sorting:");
		printArray(array);
	}
	private static void quickSort(int[] array, int low, int high) {
		if(low<high) {
			int partitionIndex = partition(array, low, high);
//			System.out.println("partitionIndex="+partitionIndex);
			quickSort(array, low, partitionIndex-1); // Sort left subarray
			quickSort(array, partitionIndex+1, high); // Sort right subarray
		}
	}
	/**
	 * Steps:
	 *  1. i = low index+1 i.e. first index of the subarray.
	 *  2. j = high i.e. last index of the subarray.
	 *  3. pivot=array[low]
	 *  4. i++ until array[i] > pivot
	 *  5. j-- until array[j] <= pivot
	 *  6. swap(array[i], array[j])
	 *  7. Repeat 4,5,6 till j<=i
	 *  8. swap(array[j], pivot)
	 *  
	 *  Return value is the final index of the pivot which will be used to further divide the array.
	 */
	private static int partition(int[] array, int low, int high) {
		int i = low+1;
		int j = high;
		int pivot = array[low];
//		System.out.println("Pivot element="+pivot);
		while(i<j) {
			while(array[i] < pivot && i<high) {
				i++;
			}
			while(array[j] > pivot) {
				j--;
			}
			if(j>i) {
				swap(array, i, j);
			}
			if(i>=j) {
				swap(array, low, j);
			}
		}
		return j;
	}
	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	private static void printArray(int[] array) {
		for(int i=0; i<array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}
