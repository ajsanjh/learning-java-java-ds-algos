package io.demo.linkedlist;

public class LinkedList {

	private Node head;
	
	private class Node {
		private Integer data;
		private Node next;
		private Node(Integer data, Node next) {
			super();
			this.data = data;
			this.next = next;
		}
	}
	
	public LinkedList() {
		this.head = new Node(null, null);
	}

	public boolean insert(Integer item) {
		Node insert = new Node(item, head.next);
		head.next = insert;
		return true;
	}
	
	public boolean add(Integer item) {
		Node add = new Node(item, null);
		Node itr = this.head;
		while(itr.next != null) {
			itr = itr.next;
		}
		itr.next = add;
		return true;
	}
	
	public Integer pop() {
		Node last = this.head;
		Node sLast = null;
		while(last.next != null) {
			sLast = last;
			last = last.next;
		}
		sLast.next = null;
		return last.data;
	}
	
	public boolean remove(Integer item) {
		Node last = this.head.next;
		Node prev = this.head;
		while(last != null) {
			if(last.data.equals(item)) {
				prev.next = last.next;
				return true;
			}
			prev = last;
			last = last.next;
		}
		return false;
	}
	
	public void reverse() {
		Node itr = this.head;
		Node o = null;
		while(itr.next != null) {
			
			itr = itr.next;
		}
	}
	
	
	public void print() {
		Node itr = this.head.next;
		while(itr != null) {
			System.out.print(itr.data + "  ");
			itr = itr.next;
		}
	}
	
	
	
	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.insert(1);
		ll.add(2);
		ll.add(3);
		ll.add(4);
		ll.insert(0);
		ll.remove(2);
		System.out.println("Last one: " + ll.pop());                           
		
		ll.print();
		
		System.out.println("\nDone !!");
	}
	
	
}
