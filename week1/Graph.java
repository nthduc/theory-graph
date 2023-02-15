package week1;

import java.util.ArrayList;
import java.util.Arrays;

public class Graph {
	private int V;
	private ArrayList<Integer>[] adjList; // danh sách kề
	private int[][] adjMatrix; // ma trận kề

	public Graph(int V) {
		this.V = V;
		adjList = new ArrayList[V];
		for (int i = 0; i < V; i++) {
			adjList[i] = new ArrayList<>();
		}
		adjMatrix = new int[V][V];
	}

	public void addEdge(int u, int v) {
		adjList[u].add(v);
		adjList[v].add(u);
		adjMatrix[u][v] = 1;
		adjMatrix[v][u] = 1;
	}

	public void removeEdge(int u, int v) {
		adjList[u].remove(Integer.valueOf(v));
		adjList[v].remove(Integer.valueOf(u));
		adjMatrix[u][v] = 0;
		adjMatrix[v][u] = 0;
	}

	public int inDegree(int v) { // nửa bậc trong cho đồ thị có hướng
		int degree = 0;
		for (int i = 0; i < V; i++) {
			degree += adjMatrix[i][v];
		}
		return degree;
	}

	public int outDegree(int v) { // nửa bậc ngoài cho đồ thị có hướng
		return adjList[v].size();
	}

	public int degree(int v) { // bậc cho đồ thị vô hướng
		return adjList[v].size();
	}

	public int numEdges() { // số cạnh/cung của đồ thị
		int count = 0;
		for (int i = 0; i < V; i++) {
			for (int j = i + 1; j < V; j++) {
				count += adjMatrix[i][j];
			}
		}
		return count;
	}

	public boolean isBipartite() { // kiểm tra đồ thị vô hướng có phải là lưỡng phân hay không
		int[] color = new int[V];
		Arrays.fill(color, -1);
		for (int i = 0; i < V; i++) {
			if (color[i] == -1) {
				if (!isBipartiteUtil(i, color)) {
					return false;
				}
			}
		}
		return true;
	}

	private boolean isBipartiteUtil(int v, int[] color) {
		color[v] = 1;
		for (int u : adjList[v]) {
			if (color[u] == -1) {
				color[u] = 1 - color[v];
				if (!isBipartiteUtil(u, color)) {
					return false;
				}
			} else if (color[u] == color[v]) {
				return false;
			}
		}
		return true;
	}

	public void printAdjList() { // in danh sách kề
		for (int i = 0; i < V; i++) {
			System.out.print(i + ": ");
			for (int j = 0; j < adjList[i].size(); j++) {
				System.out.print(adjList[i].get(j) + " ");
			}
			System.out.println();
		}
	}
}
