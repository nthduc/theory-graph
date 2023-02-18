package tuan1;

import java.util.ArrayList;

public class DirectedGraph extends Graph{

	private ArrayList<Integer>[] adjList; // danh sách kề của đồ thị

	public DirectedGraph(int V) {
	    super(V);
	    adjList = new ArrayList[V];
	    for (int i = 0; i < V; i++) {
	        adjList[i] = new ArrayList<>();
	    }
	}
	@Override
	// Thêm cung (u, v) vào đồ thị
	public void addEdge(int u, int v) {
	    adjList[u].add(v);
	    adjMatrix[u][v] = 1;
	}
	@Override
	// Xóa cung (u, v) khỏi đồ thị
	public void removeEdge(int u, int v) {
	    adjList[u].remove(Integer.valueOf(v));
	    adjMatrix[u][v] = 0;
	}
	@Override
	// In danh sách cung của đồ thị
	public void printEdges() {
	    for (int u = 0; u < V; u++) {
	        for (int v : adjList[u]) {
	            System.out.println(u + " -> " + v);
	        }
	    }
	}
	
	// Tính bậc vào của đỉnh v
	public int inDegree(int v) {
	    int count = 0;
	    for (int u = 0; u < V; u++) {
	        for (int w : adjList[u]) {
	            if (w == v) {
	                count++;
	            }
	        }
	    }
	    return count;
	}

	// Tính bậc ra của đỉnh v
	public int outDegree(int v) {
	    return adjList[v].size();
	}
	@Override
	// Tính số cung của đồ thị
	public int numEdges() {
	    int count = 0;
	    for (int u = 0; u < V; u++) {
	        count += adjList[u].size();
	    }
	    return count;
	}

	@Override
	public int degree(int v) {
	    int inDegree = 0;
	    int outDegree = 0;
	    for (int i = 0; i < V; i++) {
	        if (adjMatrix[i][v] > 0) {
	            inDegree++;
	        }
	        if (adjMatrix[v][i] > 0) {
	            outDegree++;
	        }
	    }
	    return inDegree + outDegree;
	}
	//in ra danh sách các cung của đồ thị.
	public void printListEdges() {
	    int n = adjMatrix.length;

	    for (int i = 0; i < n; i++) {
	        for (int j = 0; j < n; j++) {
	            int weight = adjMatrix[i][j];
	            if (weight != 0) {
	                System.out.println("(" + i + ", " + j + ", " + weight + ")");
	            }
	        }
	    }
	}



}
