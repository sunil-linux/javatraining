package com.spatil.examples.ass13;

public class StackTest {

	public static void main(String[] args) {

		int size = 5;

		Stack stack = new Stack(size);
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);

		for (int i = 0; i < size + 1; i++) {
			System.out.println("Pop:" + stack.pop());
		}

		// stack.push(60);

	}
}
