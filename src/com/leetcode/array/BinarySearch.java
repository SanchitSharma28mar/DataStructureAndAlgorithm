package com.leetcode.array;

/**
 * LeetCode: 704
 *
 * Binary Search always is applied on a sorted array
 */
public class BinarySearch {
	public static void main(String[] args) {
		int[] arr = new int[] {3, 5, 7, 8, 12, 15, 17};
		int index1 = binarySeach(arr, 4);
		System.out.println("Index1 = " + index1);
		int index2 = binarySeach(arr, 15);
		System.out.println("Index2 = " + index2);
	}

	private static int binarySeach(int[] arr, int element) {
		int low = 0;
		int high = arr.length - 1;
		while(low <= high) {
			int mid = (low + high)/2;
			if(arr[mid] == element) {
				return mid;
			}
			if(arr[mid] < element) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}
}
