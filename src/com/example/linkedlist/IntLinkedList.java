package com.example.linkedlist;


/**
 * in this one, head does hold the first value. so it's not the exact impl
 * @author AJ
 *
 */
public class IntLinkedList {

	private Node head;		// our head node for IntLinkedList

	private class Node {	// since this node is not to be used outside pare, it's marked private.
		private int value;
		private Node link;	// this will point to the next node: it really is just nested node objects 
		Node(){}
		Node(int value, Node link) { this.value = value; this.link = link; }
	}


	public IntLinkedList(int item) {
		this.head = new Node();
		this.head.value = item;  // first node created with value
		this.head.link = null;	 // since this is also our last node; link is null
	}


	/**
	 * insert in front of the first node.
	 * @param item
	 * @return
	 */
	public boolean insertItem(int item) {
		Node n = new Node();
		n.value = item;
		n.link = this.head;
		this.head = n;
		return true;
	}



	/** 
	 * Delete the first match.
	 * @param item
	 * @return
	 */
	public boolean deleteFirst(int item) {
		boolean isDeleted = false;

		if(this.head.value == item) {
			this.head = head.link;
			isDeleted = true;
		} else {

			Node a = this.head;
			Node b = a.link;

			while(b != null) {
				if(b.value == item) {
					a.link = b.link; 
					isDeleted = true;
					break;
				} else {
					a = a.link; // which is also b here.
					b = b.link;
				}
			}
		}
		return isDeleted;
	}


	/**
	 * append at the end of the sequence.
	 * @param item
	 * @return
	 */
	public boolean addItem(int item) {
		Node n = this.head;
		while(n.link != null) {
			n = n.link;
		}
		Node x = new Node(item, null);
		n.link = x;
		return true;
	}

	
	/** 
	 * using bubble sort for sorting array.
	 */
	public void sortList() {
		Node a = this.head;
		int c = 0;

		while(a != null) {
			Node b = this.head;
			while(b.link != null){
				if(b.value < b.link.value) {
					c = b.value;
					b.value = b.link.value;
					b.link.value = c;
				}
				b = b.link;
			}
			a = a.link;
		}
		
		
	}
	
	

	public void printList() {
		Node n = this.head;
		while(n != null) {
			System.out.print(n.value + " ");
			n = n.link;
		}
		System.out.println();
	}


	public static void main(String[] args) {
		IntLinkedList i = new IntLinkedList(2);
		i.addItem(1);
		i.addItem(5);
		i.addItem(3);
		i.addItem(4);

//		i.deleteFirst(4);


		i.printList();
		
		i.sortList();
		i.printList();
	}

}
