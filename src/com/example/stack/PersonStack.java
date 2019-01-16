package com.example.stack;

/**
 * A proper stack with objects
 * 
 * @author AJ
 *
 */
public class PersonStack {

	public final int size;
	private int top = -1;
	
	private final Person[] stack;
	
	public PersonStack(int size) {
		this.size = size;
		this.stack = new Person[this.size];
	}
	
	
	public boolean push(Person person) {
		if(!this.isFull()) {
			this.stack[++this.top] = person;
			return true;
		} else {
			return false;
		}
		
	}
	
	public Person pop() {
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
