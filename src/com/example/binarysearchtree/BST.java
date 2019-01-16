package com.example.binarysearchtree;


/**
 * It's a tree structure with a parent and each parent has children 
 * Rules:
 *  -- Each parent can have not more than 2 children
 *  -- Left child must have value less than parent
 *  -- Right child must have value greater than the parent.
 *  -- The less-more value relation only lies with single parent and children 
 *  	relationship and not grandparent and grand-children
 * 
 * Structure:
 * 	-- each node has 3 fields:
 * 		-- left field points to left child
 * 		-- right field points to right child
 * 		-- middle field holds the value.
 * 	and so on.....
 * 
 * 
 * @author AJ
 *
 */
class Person {
	String name;
	int age;
	Person(String name, int age) { this.name = name; this.age = age;}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	} 
}
public class BST {

	private class Node {
		private Node lc, rc;
		private Person data;
		private Node(Node lc, Person data, Node rc) {
			this.lc = lc; this.data = data; this.rc = rc;
		}
	}
	
	
	private Node root;
	
	public BST() {
		this.root = null;
	}
	
	public boolean insert(Person person) {
		Node node = new Node(null, person, null);
		if(this.root == null) {
			this.root = node;
			return true;
		} else {

			Node p = this.root;
			Node c = p;
			while(c != null) {
				p = c;
				if(person.name.compareTo(c.data.name) < 0) {
					c = p.lc;
				} else {
					c = p.rc;
				}
			}
			
			if(person.name.compareTo(p.data.name) < 0) {
				p.lc = node;
				
			} else {
				p.rc = node;
			}
			return true;
		}
	}
	

	public Node findNode( String key ) {
		Node c = this.root;
		while(c  != null) {
			if(key.compareTo(c.data.name) == 0) {
				break;
			} else if(key.compareTo(c.data.name) < 0 ) {
				c = c.lc;
			} else {
				c = c.rc;
			}
		}
		return c;
	}
	
	
	
	public void print(Node n) {
		Node p = n;
		if(p != null) {
			System.out.print(p.data + " ");
			print(p.lc);
			print(p.rc);
			System.out.println();
		}
		
	}
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		BST b = new BST();
		b.insert(new Person("ajay", 33));
		b.insert(new Person("renee", 30));
		b.insert(new Person("sunny", 35));
		b.insert(new Person("messi", 31));
		
		b.print(b.findNode("ajay"));
		
		
		System.out.println("done !!");
	}
	
	
}
