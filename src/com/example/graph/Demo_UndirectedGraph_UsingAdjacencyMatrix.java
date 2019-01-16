package com.example.graph;

public class Demo_UndirectedGraph_UsingAdjacencyMatrix {
	public static void main(String[] args) {
		MatrixGraph graph = new MatrixGraph(3);
		
	}
}


class MatrixGraph {
	
	private int vertices;
	private int[][] adj;
	
	public MatrixGraph(int vertices) {
		if(vertices <= 0) throw new IllegalArgumentException();
		this.vertices = vertices;
		this.adj = new int[vertices][vertices];
	}

	
	
	
}