package tuan1;

import java.util.ArrayList;

public class UnDirectedGraph extends Graph{

	private ArrayList<Integer>[] adjList; // danh sách kề của đồ thị

	public UnDirectedGraph(int V) {
        super(V);
        adjList = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adjList[i] = new ArrayList<>();
        }
    }
	@Override
	// Thêm cạnh (u, v) vào đồ thị
	public void addEdge(int u, int v) {
		adjList[u].add(v);
		adjList[v].add(u);
		adjMatrix[u][v] = 1;
		adjMatrix[v][u] = 1;
	}
	@Override
	// Xóa cạnh (u, v) khỏi đồ thị
	public void removeEdge(int u, int v) {
		adjList[u].remove(Integer.valueOf(v));
		adjList[v].remove(Integer.valueOf(u));
		adjMatrix[u][v] = 0;
		adjMatrix[v][u] = 0;
	}
	@Override
	// In danh sách cạnh/cung của đồ thị
	public void printEdges() {
		for (int u = 0; u < V; u++) {
			for (int v : adjList[u]) {
				if (v > u) {
					System.out.println(u + " - " + v);
				}
			}
		}
	}
	@Override
	// Tính bậc của đỉnh v
	public int degree(int v) {
		return adjList[v].size();
	}
	@Override
	// Tính số cạnh/cung của đồ thị
	public int numEdges() {
		int count = 0;
		for (int u = 0; u < V; u++) {
			count += adjList[u].size();
		}
		return count / 2;
	}
	
	@Override
	public void printListEdges() {
	    int n = this.adjMatrix.length;

	    for (int i = 0; i < n; i++) {
	        for (int j = i + 1; j < n; j++) { // chỉ duyệt các cạnh một lần, tránh in trùng
	            int socung = adjMatrix[i][j];
	            for (int k = 0; k <socung; k++) {
	                System.out.print("(" + i + "," + j + ")");
	            }
	        }
	    }
	}

}
