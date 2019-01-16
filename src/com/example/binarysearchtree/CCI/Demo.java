package com.example.binarysearchtree.CCI;

public class Demo {
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();

		bst.insert(55);
		bst.insert(45);
		bst.insert(50);
		bst.insert(46);
		bst.insert(60);
		bst.insert(70);
		bst.insert(59);
		bst.insert(71);
		bst.insert(69);
		

		System.out.println("Contains: " + bst.contains(71));

		bst.print();
		
		System.out.println();
		System.out.println("LCA: " + bst.getLca(59, 71));
	}
}

class BinarySearchTree {
	Node root;
	BinarySearchTree() {
		this.root = null;
	}

	class Node {
		int value;
		Node left, right;
		Node(int value, Node left, Node right) {
			this.value = value;
			this.left = left; 
			this.right = right;
		}
	}

	boolean insert(int value) {
		if(this.root == null) {
			this.root = new Node(value, null, null);
			return true;
		} else {
			return insert(value, this.root);
		}
	}

	private boolean insert(int value, Node node) {
		if(value == node.value) 
			return false;
		if(value < node.value) {
			if(node.left == null) {
				node.left = new Node(value, null, null);
			} else {
				insert(value, node.left);
			}
		} else {
			if(node.right == null) {
				node.right = new Node(value, null, null);
			} else {
				insert(value, node.right);
			}
		}
		return true;
	}

	boolean contains(int value) {
		if(root == null) 
			return false;
		else 
			return contains(value, root);
	}

	boolean contains(int value, Node node) {
		if(node.value == value) 
			return true;
		else if(value < node.value) {
			if(node.left == null) 
				return false;
			else
				return contains(value, node.left);
		} else {
			if(node.right == null) 
				return false;
			else 
				return contains(value, node.right);
		}
	}

	void print() {
		print(this.root);
	}

	private void print(Node node) {
		if(node.left != null) {
			print(node.left);
		}
		System.out.print(node.value + " ");
		if(node.right != null) {
			print(node.right);
		}
	}

	
	int getLca(int first, int second) {
		return getLca(root, first, second);
	}
	
	private int getLca(Node lca, int first, int second) {
		if(first == lca.value || second == lca.value)
			return lca.value;
		
		if((first < lca.value && second > lca.value) 
				|| (first > lca.value && second < lca.value)) {
			return lca.value;
		}
		
		if(first < lca.value && second < lca.value) {
			return getLca(lca.left, first, second);
		}
		if(first > lca.value && second > lca.value) {
			return getLca(lca.right, first, second);
		}
		
		throw new RuntimeException("get lca exception");
	}

	//	boolean add(int value) {
	//		if(this.root == null) {
	//			this.root = new Node(value, null, null);
	//			return true;
	//		} else {
	//			Node itr = null;
	//			Node child = this.root;
	//			while(child != null) {
	//				itr = child;
	//				if(value < itr.value) {
	//					child = itr.left;
	//				}
	//				else
	//					child = itr.right;
	//			}
	//			if(value < itr.value) {
	//				itr.left = new Node(value, null, null);
	//			} else {
	//				itr.right = new Node(value, null, null);
	//			}
	//			return true;
	//		}
	//	}

}
