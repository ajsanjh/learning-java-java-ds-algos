package com.example.stack;

import java.util.Arrays;

public class IntStackEg {

	public final int size;
	private int top = -1;
//	private int push;
//	private int pop;
	
	
	private final int[] values;
	
	public IntStackEg(int size) {
		this.size = size;
		this.values = new int[this.size];
	}
	
	
	public boolean push(int value) {
		if(!this.isFull()) {
			this.values[++this.top] = value;
			return true;
		} else {
			return false;
		}
		
	}
	
	public int pop() {
		if(isEmply())
			throw new IllegalStateException("Stack is empty. Cannot Pop");
		return this.values[top--];
	}
	
	public boolean isFull() {
		return (this.top + 1) >= this.size;
	}
	
	public boolean isEmply() {
		return this.top == -1;
	}
	
	
	
	@Override
	public String toString() {
		int[] arr = new int[top+1];
		for (int i = 0; i < top+1; i++) {
			arr[i] = this.values[i];
		}
		return Arrays.toString(arr);
	}
	
	
	public static void main(String[] args) {

		IntStackEg s = new IntStackEg(10);
		
		System.out.println(s.push(1));
		s.push(2);
		s.push(3);
		s.pop();
		s.pop();
		s.pop();
		System.out.println("Is Stack Empty ?: " + s.isEmply());
		s.pop();
		
		System.out.println(s);
		
	}
	
	
	
	
	
}
