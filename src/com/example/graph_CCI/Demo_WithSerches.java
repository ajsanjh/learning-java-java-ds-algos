package com.example.graph_CCI;

import java.util.ArrayList;
import java.util.List;

public class Demo_WithSerches {
	public static void main(String[] args) {
		Graph graph = new Graph();
		
	}
}

class Graph {
	class Node {
		int id;
		List<Node> adj = new ArrayList<>();
		boolean visited = false;
		public Node(int id) {
			this.id = id;
		}
	}
	List<Node> nodes = new ArrayList<>();

	boolean contains(int id) {
		return this.nodes.stream().anyMatch(i -> i.id == id);
	}

	boolean addNode(int id) {
		if(contains(id))
			return false;
		this.nodes.add(new Node(id));
		return true;
	}


	boolean addEdge(final int source, final int dest) {
		if(!contains(source) || !contains(dest)) {
			return false;
		} else {
			final Node sn = this.nodes.stream().filter(i -> i.id == source).findFirst().get();
			final Node dn = this.nodes.stream().filter(i -> i.id == dest).findFirst().get();
			if(!sn.adj.stream().allMatch(i -> i == dn))
				sn.adj.add(dn);
			if(!dn.adj.stream().allMatch(i -> i == sn)) 
				dn.adj.add(sn);
			return true;
		}
	}

}	




