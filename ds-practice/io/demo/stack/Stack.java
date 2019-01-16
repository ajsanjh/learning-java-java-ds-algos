package io.demo.stack;

public class Stack {

	
	private int[] stack;
	private int top = -1;
	
	public Stack(int size) {
		this.stack = new int[size];
	}
	
	public boolean push(int item) {
		stack[++top] = item;
		return true;
	}
	
	
	public int pop() {
		return stack[--top];
	}

	public void print() {
		System.out.print("[");
		for(int i = 0; i < top + 1; i++) {
			System.out.print(this.stack[i]+ " ");
		}
		System.out.print("]");
	}
	
	
	
	
	public static void main(String[] args) {
		Stack stack = new Stack(5);
		stack.push(1);
		stack.push(2);
		stack.pop();
		stack.push(3);
		stack.print();
	}
	
	
	
}
