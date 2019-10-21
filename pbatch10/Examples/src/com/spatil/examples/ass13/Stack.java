package com.spatil.examples.ass13;

public class Stack {

	private int[] stk;
	private int top;

	public Stack(int size) {
		stk = new int[size];
		top = -1;
	}

	private boolean isFull() {
		return top == stk.length - 1;
	}

	private boolean isEmpty() {
		return top == -1;
	}

	public void push(int data) {
		if (!isFull())
			stk[++top] = data;
		else
			System.err.println("Stack is full. Can't push more elements....");
	}

	public int pop() {
		int data = -1;

		if (!isEmpty()) {
			data = stk[top];
			top--;
		} else {
			System.err.println("Stack is empty. Can't pop more elements....");
		}
		return data;
	}

}
