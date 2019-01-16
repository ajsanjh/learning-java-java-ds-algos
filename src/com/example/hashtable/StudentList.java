package com.example.hashtable;
class StudentList {  // our linked list
	Node head;
	
	class Node {
		private Student data;
		private Node next;
		Node(Student data, Node next){
			this.data = data; this.next = next;
		}
	}
	
	StudentList(){
		this.head = new Node(null, null);
	}
	
	public boolean insert(Student data) {
		if(this.head.next == null) {
			this.head.next = new Node(data, null);
		} else {
			Node n = new Node(data, this.head.next);
			this.head.next = n;
		}
		return true;
	}
	
	public boolean add(Student data) {
		Node itr = this.head.next;
		Node backup = this.head.next;
		while(itr != null) {
			backup = itr;
			itr = itr.next;
		}
		backup.next = new Node(data, null);
		return true;
	}
	
	
	public boolean haveRollno(String rollno) {
		Node itr = this.head.next;
		while(itr != null) {
			if(rollno.equals(itr.data.getRoll_no())) {
				return true;
			} 
			itr = itr.next;
		}
		return false;
	}
	
	
	public Student fetchData(String rollno) {
		Node itr = this.head.next;
		while(itr != null) {
			if(itr.data.getRoll_no().equals(rollno)) {
				return itr.data;
			}
			itr = itr.next;
		}
		return null;
	}
	
	public boolean deleteData(String rollno) {
		Node itr = this.head.next;
		Node back = this.head;
		while(itr != null) {
			if(itr.data.getRoll_no().equals(rollno)) {
				back.next = itr.next;
				return true;
			}
			itr = itr.next;
			back = back.next;
		}
		return false;
	}
	
	
	
	public void print()	{
		Node itr = this.head.next;
		System.out.println(">>> Printing StudentList Contents: ");
		while(itr != null) {
			System.out.println(">>>  " + itr.data);
			itr = itr.next;
		}
		System.out.println("Exit printing.");
	}
	
}