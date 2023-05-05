package com.datastructure.stack;

import com.datastructure.stack.impl.FixedSizeArrayStack;
import com.datastructure.stack.impl.StackFullException;
import com.datastructure.stack.impl.StackOfStacks;

public class Problem_29_StackOfStacks {
	
	public static void main(String[] args) throws StackFullException {
		StackOfStacks sos = new StackOfStacks(2);
		sos.push(1);
		sos.push(2);
		sos.push(3);
		sos.push(4);
		sos.push(5);
		sos.push(6);
		for (FixedSizeArrayStack stack : sos.getListOfStacks()) {
			System.out.println(stack);
		}
	}
}
