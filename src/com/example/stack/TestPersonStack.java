package com.example.stack;

public class TestPersonStack {

	public static void main(String[] args) {
		
		Person p1 = new Person("ajay", "602");
		Person p2 = new Person("johny", "617");
		
		
		PersonStack stack = new PersonStack(2);
		
		stack.push(p1);
		stack.push(p2);
		System.out.println("P2 object pop: " + stack.pop());
		System.out.println("P1 object pop: " + stack.pop());
		
	}
	
	
	
}
