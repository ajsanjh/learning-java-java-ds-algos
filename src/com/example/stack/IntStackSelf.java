package com.example.stack;


class IntStack2 {
	
	public int size;
	public int top;
	private int[] stack;
	
	public IntStack2(int size) {
		this.stack = new int[size];
		this.size = size;
		this.top = -1;
	}
	

	public boolean push(int item) {
		if(top == (size - 1)) {
			return false;
		} else {
			this.stack[++top] = item;
			return true;
		}
	}
	
	
	public int pop() {
		if(top == -1) {
			throw new IllegalStateException("Stack is empty. Cannot pop!");
		} else {
			return this.stack[top--];
		}
	}

	
	public void printStack() {
		for(int i = 0; i <= top; i++) {
			System.out.print(this.stack[i]+ " ");
		}
		System.out.println();
	}
	
}


public class IntStackSelf {
	public static void main(String[] args) {
		IntStack2 i = new IntStack2(5);
		i.push(1);
		i.push(2);
		i.push(3);
		i.push(4);
		i.push(5);
		System.out.println("pop 5 : " +i.pop());
		i.push(6);
		
		i.printStack();
		System.out.println("Done !!");
	}
}