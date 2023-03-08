package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public abstract class AGraph {

	protected int maxVertex;
	protected byte[][] adjMatrix;

	public AGraph(int num) {
		this.adjMatrix = new byte[num][num];
		this.maxVertex = num;
	}

	public abstract void addEdge(int point1, int point2);

	public abstract void removeEdge(int point1, int point2);

	public abstract int deg(int point);

	public abstract void printEdgeList();

	public abstract int numEdges();

	public void printAdjMatrix() {
		for (int i = 0; i < adjMatrix.length; i++)
			System.out.println(Arrays.toString(adjMatrix[i]));
	}

	public boolean isSimpleGraph() {
		for (int r = 0; r < this.maxVertex; r++)
			for (int c = 0; c < this.maxVertex; c++)
				if (this.adjMatrix[r][c] > 1)
					return false;
		return true;
	}

	public void BFS(int startingPoint) {
		if (startingPoint < 0 || startingPoint >= this.maxVertex)
			return;
		
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] visited = new boolean[this.maxVertex];
		int v;
		//diem dau
		System.out.print("BFS :: " + startingPoint + " ");
		visited[startingPoint] = true;
		q.add(startingPoint);
		//vong lap check dg di
		while (!q.isEmpty()) {
			v = q.poll();
			for (int i = 0; i < this.maxVertex; i++) {
				if (this.adjMatrix[v][i] > 0 && !visited[i]) {
					System.out.print(i + " ");
					q.add(i);
					visited[i] = true;
				}
			}
		}
		System.out.println();
	}
	
	public void DFS(int startingPoint) {
		if (startingPoint < 0 || startingPoint >= this.maxVertex)
			return;
		
		Stack<Integer> s = new Stack<Integer>();
		boolean[] visited = new boolean[this.maxVertex];
		int vertex;
		System.out.print("DFS :: " + startingPoint + " ");
		visited[startingPoint] = true;
		s.push(startingPoint);
		boolean noEdge;
		while (!s.isEmpty()) {
			noEdge = true;
			vertex = s.peek();
			for (int i = 0; i < this.maxVertex; i++) {
				if (this.adjMatrix[vertex][i] > 0 && !visited[i]) {
					System.out.print(i + " ");
					visited[i] = true;
					s.push(i);
					noEdge = false;
				}
			}
			if (noEdge) {
				s.pop();
			}
		}
		System.out.println();
	}

	public boolean isConnectedGraph() {
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] visited = new boolean[this.maxVertex];
		int v;
		int vertexConnect = 1;
		//diem dau
		visited[0] = true;
		q.add(0);
		//vong lap check dg di
		while (!q.isEmpty()) {
			v = q.poll();
			for (int i = 0; i < this.maxVertex; i++) {
				if (this.adjMatrix[v][i] > 0 && !visited[i]) {
					q.add(i);
					visited[i] = true;
					vertexConnect++;
				}
			}
		}
		return vertexConnect == this.maxVertex;
	}
	
	public boolean hasPath(int point1, int point2) {
		if (point1 < 0 || point1 >= this.maxVertex || point2 < 0 | point2 >= this.maxVertex)
			return false;
		
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] visited = new boolean[this.maxVertex];
		int v;
		//diem dau
		visited[point1] = true;
		q.add(point1);
		//vong lap check dg di
		while (!q.isEmpty()) {
			v = q.poll();
			for (int i = 0; i < this.maxVertex; i++) {
				if (this.adjMatrix[v][i] > 0 && !visited[i]) {
					if (i == point2)
						return true;
					else {
						q.add(i);
						visited[i] = true;
					}
				}
			}
		}
		return false;
	}
}
