package com.example.linkedlist.CCI;

public class Demo {
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		
		list.add("two");
		list.insert("one");
		list.add("three");
		
		list.print();
		
		list.remove("two");
		list.add("four");
		list.add("five");
		list.remove("FOUR");
		System.out.println("remove 'FOUR'?: " + list.remove("FOUR"));
		
		list.print();
	}
}

class LinkedList {

	class Node {
		String value;
		Node next;
		Node(String value, Node next) {
			this.value = value;
			this.next = next;
		}
	}

	Node head;
	LinkedList() {
		this.head  = new Node(null, null);
	}
	
	boolean insert(String ele) {
		Node node = new Node(ele, head.next);
		this.head.next = node;
		return true;
	}
	
	boolean add(String ele) {
		Node itr = this.head;
		while(itr.next != null) {
			itr = itr.next;
		}
		itr.next = new Node(ele, null);
		return true;
	}
	
	boolean remove(String ele) {
		Node itr = this.head.next;
		Node pre = this.head;
		while(itr != null) {
			if(itr.value.equals(ele))
				break;
			else {
				pre = itr;
				itr = itr.next;
			}
		}
		if(itr == null) 
			return false;
		else {
			pre.next = itr.next;
			return true;
		}
	}
	
	void print() {
		Node itr = this.head.next;
		while(itr != null) {
			System.out.print(itr.value + ", ");
			itr = itr.next;
		}
		System.out.println();
	}
	
}
