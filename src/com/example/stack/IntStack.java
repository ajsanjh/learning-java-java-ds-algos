package com.example.stack;

/**
 * A proper stack with primitive type: rarely used.
 * 
 * @author AJ
 *
 */
public class IntStack {

	public final int size;
	private int top = -1;
	
	private final int[] stack;
	
	public IntStack(int size) {
		this.size = size;
		this.stack = new int[this.size];
	}
	
	
	public boolean push(int value) {
		if(!this.isFull()) {
			this.stack[++this.top] = value;
			return true;
		} else {
			return false;
		}
		
	}
	
	public int pop() {
		if(isEmply())
			throw new IllegalStateException("Stack is empty. Cannot Pop");
		return this.stack[top--];
	}
	
	public boolean isFull() {
		return (this.top + 1) >= this.size;
	}
	
	public boolean isEmply() {
		return this.top == -1;
	}
}
