package com.example.binarysearchtree;

public class BSTSelf {

	
	public static void main(String[] args) {
		BST2 bst = new BST2(6);
		
		bst.insert(3);
		bst.insert(4);
		
		bst.print(bst.root);
		
		System.out.println("done !!");
	}
	
}


class BST2 {
	
	Node root;

	class Node {
		int value;
		Node lc, rc;
		Node(int value, Node lc, Node rc) {
			this.value = value; this.lc = lc; this.rc = rc;
		}
	}
	
	
	BST2(int value) {
		this.root = new Node(value, null, null);
	}
	
	
	public boolean insert(int value) {
		Node n = this.root;
		while(true) {
			if(value < n.value) {
				if(n.lc == null) {
					n.lc = new Node(value, null, null);
					break;
				} else {
					n = n.lc;
				}
			} else {
				if(n.rc == null) {
					n.rc = new Node(value, null, null);
					break;
				} else {
					n = n.rc;
				}
			}
		}
		return true;
	}
	
	
	public void print(Node n) {
		Node p = n;
		if(p != null) {
			System.out.print(Integer.valueOf(p.value) + " ");
//			print(p.lc);
//			print(p.rc);
			System.out.println();
		}
	}
	
}



