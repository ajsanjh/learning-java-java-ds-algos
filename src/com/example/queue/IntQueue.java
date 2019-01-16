package com.example.queue;

/**
 * a proper queue in a round robin fashion 
 * @author AJ
 *
 */
public class IntQueue {
	private final int size;
	private int front;
	private int back;
	private int effectiveSize;
	
	private int[] q;
	
	public IntQueue(int size) {
		this.size = size;
		this.q = new int[this.size];
	}
	
	
	public boolean enqueue(int item) {
		if(!isFull()) {
			this.q[back] = item;
			this.effectiveSize++;
			this.back = (this.back + 1) % this.size;
			return true;
		} else {
			return false;
		}
	}
	
	public int dequeue() {
		if(isEmpty()) {
			throw new IllegalStateException("Queue is empty. Can't dequeue");
		} else {
			int item = this.q[front];
			this.effectiveSize--;
			this.front = (this.front + 1) % this.size;
			return item;
		}
	}
	
	public boolean isFull()	{
		return this.effectiveSize == this.size;
	}
	
	public boolean isEmpty() {
		return effectiveSize == 0;
	}
	
	public void showAll() {
		int f = this.front;
		if(!isEmpty()) {
			for (int i = 0; i < this.effectiveSize; i++) {
				System.out.print(this.q[f] + (i < this.effectiveSize-1? ",":""));
				f = (f+1) % this.size;
			}
		}
	}
	
	
	/**
	 * delete this
	 * @param args
	 */
	public static void main(String[] args) {
		IntQueue q = new IntQueue(4);
		
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.dequeue();
		q.enqueue(4);
		q.dequeue();
		q.enqueue(5);
		q.showAll();
	}
}
