package com.datastructure.stack;

public class Problem_22_FindingSpans {
	public static int[] findingSpans(int[] input){
		int[] span = new int[input.length];
		for (int i = 0; i < input.length; i++) {
			int index = i-1;
			span[i] = 1;
			while(index >= 0 && input[index] <= input[i]){
	            span[i] = span[i] + span[index];
	            index = index - span[index];
			}
		}
		return span;
	}
	public static void main(String[] args) {
		int[] input = {100,65,70,110,80,90,120};
		for (int i = 0; i < input.length; i++) {
			System.out.print(input[i] + " ");
		}
		System.out.println();
		int[] output = findingSpans(input);
		for (int i = 0; i < output.length; i++) {
			System.out.print(output[i] + " ");
		}
	}
}
