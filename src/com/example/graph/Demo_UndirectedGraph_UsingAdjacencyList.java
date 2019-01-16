package com.example.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Demo_UndirectedGraph_UsingAdjacencyList {
	public static void main(String[] args) {
		ListGraph graph = new ListGraph(5);
		
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(2, 3);
		graph.addEdge(2, 4);
		graph.addEdge(3, 2);
		graph.addEdge(3, 4);
		graph.addEdge(3, 5);
		
		System.out.println(graph.getNeighbours(1));
		System.out.println(graph.getNeighbours(2));
		System.out.println(graph.getNeighbours(3));
		
	}
}

class ListGraph {

	private Map<Integer, ArrayList<Integer>> adjListMap;
	
	public ListGraph(int toatlVertices) {
		this.adjListMap = new HashMap<>();
		for(int i = 1; i < toatlVertices; i++) {
			this.adjListMap.put(i, new ArrayList<>());
		}
	}
	
	public boolean addEdge(int v, int w) {
		if(v > adjListMap.size() || w > adjListMap.size())
			return false;
		adjListMap.get(v).add(w);
		adjListMap.get(w).add(v);
		return true;
	}
	
	public ArrayList<Integer> getNeighbours(int v) {
		if(!adjListMap.containsKey(v))
			return null;
		
		return new ArrayList<>(adjListMap.get(v));
	}
	
	
}
