package com.example.stack;

public class CCI_Practice_IntStack {

	public static void main(String[] args) {
		CCI_Practice_IntStack c = new CCI_Practice_IntStack();
		
		Stack s = c.new Stack(10);
		
		s.push(0);
		s.push(1);
		s.push(2);
		s.pop();
		s.push(3);
		s.printS();
	}
	
	
	class Stack {
		int[] arr;
		final int size;
		int index;
		Stack(int size) {
			this.size = size;
			this.index = -1;
			this.arr = new int[this.size];
		}
		void push(int element) {
			this.arr[++index] = element;
		}
		int pop() {
			return this.arr[--index];
		}
		void printS() {
			for (int i = 0; i <= index; i++) {
				System.out.print(arr[i] + ", ");
			}
		}
	}
	
	
}
