package com.algorithm.sorting;

public class MergeSort {
	public static void main(String[] args) {
		int[] array = {9,2,4,2,4,6,7,5,9};//{12,54,65,7,23,9};//{7,2,91,77,3};
		System.out.println("Before sorting:");
		printArray(array);
		mergeSort(array, 0, array.length-1);
		System.out.println("After sorting:");
		printArray(array);
	}
	private static void printArray(int[] array) {
		for(int i=0; i<array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	private static void mergeSort(int[] array, int low, int high) {
		if(low<high) {
			int mid = (low+high)/2;
			mergeSort(array, low, mid);
			mergeSort(array, mid+1, high);
			merge(array, low, mid, high);
//			System.out.println("Array after every merge");
			System.out.println("MergeSort Low="+low+" high="+high+" mid="+mid);
//			printArray(array);
		}
	}
	private static void merge(int[] array, int low, int mid, int high) {
		System.out.println("Merge Low="+low+" high="+high+" mid="+mid);
		int i = low;
		int j = mid+1;
		int k = low;
		int[] temp = new int[low+high+1];
		while(i <= mid && j <= high) {
			if(array[i] < array[j]) {
				temp[k++]=array[i++];
			} else if(array[i] > array[j]) {
				temp[k++]=array[j++];
			} else if(array[i] == array[j]) {
				temp[k++]=array[i++];
				temp[k++]=array[j++];
			}
		}
		while(i <= mid) {
			temp[k++] = array[i++];
		}
		while(j <= high) {
			temp[k++] = array[j++];
		}
		for(int l=low; l<=high; l++) {
			array[l] = temp[l];
		}
		printArray(temp);
	}
}
