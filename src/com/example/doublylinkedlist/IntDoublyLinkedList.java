package com.example.doublylinkedlist;

public class IntDoublyLinkedList {


	Node head = null;
//	Node tail = null;
	
	
	private class Node {
		Node prev, next;
		int value;
		Node(){}
		Node(Node prev, int value,  Node next) {
			this.prev = prev; this.value = value; this.next = next;
		}
	}

	public IntDoublyLinkedList(int item) {
		this.head = new Node(null, item, null);
	}


	public boolean insertItem(int item) {
		Node a = new Node(null, item, this.head);
		this.head = a;
		return true;
	}

	public boolean addItem(int item) {
		Node itr = this.head;

		while(itr.next != null)
			itr = itr.next;

		itr.next = new Node(itr, item, null);
		return true;
	}


	public boolean deleteFirst(int item) {
		boolean isDel = false;
		if(this.head.value == item) {
			this.head = this.head.next;
			this.head.prev = null;
			isDel = true;
		} else {

			Node a = this.head;
			Node b = a.next;
			while(b != null) {
				if(b.value == item) {
					a.next = b.next;
					isDel = true;
					break;
				} else {
					a = a.next;
					b = b.next;
				}
			}
		}

		return isDel;
	}



	public void printList() {
		Node a = this.head;
		while(a != null) {
			System.out.print(a.value + " ");
			a = a.next;
		}
		System.out.println();
	}




	public static void main(String[] args) {
		System.out.println("Start !!");
		IntDoublyLinkedList d = new IntDoublyLinkedList(3);
		d.insertItem(2);
		d.insertItem(1);
		d.addItem(4);
		d.addItem(5);


		d.deleteFirst(3);
		
		d.printList();



		System.out.println("Done !!");
	}


}
