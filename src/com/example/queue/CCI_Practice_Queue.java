package com.example.queue;

import java.nio.channels.IllegalSelectorException;

public class CCI_Practice_Queue {
	public static void main(String[] args) {
		CCI_Practice_Queue c = new CCI_Practice_Queue();
		Queue q = c.new Queue(4);
		q.enqueue(11);
		q.enqueue(12);
		q.enqueue(13);
		q.enqueue(14);
		q.enqueue(15);
		q.print();
		System.out.println("d: " + q.dequeue());
		q.enqueue(16);
		System.out.println("d: " + q.dequeue());
		System.out.println("d: " + q.dequeue());
		q.enqueue(17);
		q.print();
	}
	
	class Queue {
		int front, back, effSize, size;
		int arr[];
		
		public Queue(int size) {
			this.size = size;
			this.arr = new int[size];
		}
		
		boolean enqueue(int ele) {
			if(effSize == size) {
				return false;
			} else {
				arr[back%size] = ele;
				back++;
				effSize++;
				return true;
			}
		}
		
		int dequeue() {
			if(effSize == 0) {
				throw new IllegalSelectorException();
			} else {
				int ele = arr[front%size];
				front++;
				effSize--;
				return ele;
			}
		}
		
		void print() {
			int count = effSize;
			int start = front;
			while(count != 0 ) {
				System.out.print(arr[start%size] + ", ");
				start++;
				count--;
			}
			System.out.println();
		}
	}
}
