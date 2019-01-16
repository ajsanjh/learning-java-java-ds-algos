package com.example.queue;

import java.util.Arrays;


/**
 *  a non marry go around queue: not a good implementation.
 * @author AJ
 *
 */
public class IntQueueR {
	
	private int front;  // always zero here.
	private int back;
	private final int size;
	
	private int[] q;
	
	
	IntQueueR(int size) {
		this.size = size;
		q = new int[this.size];
	}
	
	public boolean enqueue(int value) {
		if(!isFull()) {
			q[back++] = value;
			return true;
		} else {
			return false;
		}
	}
	
	public int dequeue() {
		if(isEmpty())
			throw new IllegalStateException("Queue is empty. Can't dequeue.");
		int item = q[front];
		this.back--;
		int[] arr = new int[this.size];
		for (int i = 0; i < back; i++) {
			arr[i] = this.q[i+1];
		}
		this.q = arr;
		return item;
	}
	
	
	public boolean isFull() {
		return this.back == this.size;
	}
	
	public boolean isEmpty() {
		return back == front;
	}
	
	@Override
	public String toString() {
		int[] arr = new int[back];
		for (int i = 0; i < back; i++) {
			arr[i] = this.q[i];
		}
		return Arrays.toString(arr);
	}
	
	public static void main(String[] args) {
		IntQueueR iq = new IntQueueR(3);
		
		iq.enqueue(1);
		System.out.println("dequeue at index 0: " + iq.dequeue());
		System.out.println("is empty: " + iq.isEmpty());
		
		iq.enqueue(1);
		iq.enqueue(2);
//		iq.enqueue(3);
		
		System.out.println("dequeue: " + iq.dequeue());
		iq.enqueue(4);
		iq.enqueue(5);
		iq.enqueue(6);  // returns false;
		
		
		
		System.out.println(iq.toString());
	}
	
	
	
//
//	private int front;
//	private int back;
//	private int size;
//	private int total;
//	
//	private int[] q;
//	
//
//	public IntQueue(int size) {
//		this.size = size;
//		q = new int[this.size];
//	}
//	
//	public boolean enqueue(int item) {
//		if(isFull())
//			return false;
//		else {
//			total++;
//			q[back++] = item;
//			return true;
//		}
//	}
//	
//	public int dequeue() {
//		int item = q[front++];
//		total--;
//		return item;
//	}
//	
//	
//	
//	public boolean isFull()	{
//		return size == total;
//	}
//	
	
	
}
