package tuan2;

import java.util.LinkedList;
import java.util.Queue;

public abstract class Graph {
	protected int V; // số đỉnh của đồ thị
	protected int[][] adjMatrix; // ma trận kề của đồ thị

	public Graph(int V) {
		this.V = V;
		adjMatrix = new int[V][V];
	}

//	public abstract void addEdge(int u, int v);
//	public abstract void removeEdge(int u, int v);
//	public abstract void printListEdges();
//	public abstract int degree(int n);
//	public abstract int numOfEdges();

	// Thêm cạnh (u, v) vào đồ thị
    public abstract void addEdge(int u, int v);

    // Xóa cạnh (u, v) khỏi đồ thị
    public abstract void removeEdge(int u, int v);

    // In danh sách cạnh/cung của đồ thị
    public abstract void printEdges();

    // Tính bậc của đỉnh v
    public abstract int degree(int v);

    // Tính số cạnh/cung của đồ thị
    public abstract int numEdges();
    
    // in ra danh sách cung của đồ thị
    public abstract void printListEdges();

    // In ma trận kề của đồ thị
    public void printAdjMatrix() {
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    // kiểm tra có phải là đơn đồ thị hay không
    public boolean isSimpleGraph() {
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (adjMatrix[i][j] > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    

 // Duyệt đồ thị theo chiều rộng (BFS)
    public void BFS(int startVertex) {
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<Integer>();
        visited[startVertex] = true;
        queue.add(startVertex);

        while (queue.size() != 0) {
            startVertex = queue.poll();
            System.out.print(startVertex + " ");

            for (int i = 0; i < V; i++) {
                if (adjMatrix[startVertex][i] != 0 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
    
    

    // Duyệt đồ thị theo chiều sâu (DFS)
    public void DFS(int startVertex) {
        boolean[] visited = new boolean[V];
        DFSUtil(startVertex, visited);
    }

    private void DFSUtil(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");

        for (int i = 0; i < V; i++) {
            if (adjMatrix[v][i] != 0 && !visited[i]) {
                DFSUtil(i, visited);
            }
        }
    }
    // kiểm tra đường đi từ đỉnh x đến đỉnh y cho trước hay không
    public boolean hasPathBFS(int x, int y) {
        Queue<Integer> queue = new LinkedList<Integer>();
        boolean[] visited = new boolean[V];
        queue.add(x);
        visited[x] = true;
        while (!queue.isEmpty()) {
            int v = queue.poll();
            if (v == y) {
                return true;
            }
            for (int i = 0; i < V; i++) {
                if (adjMatrix[v][i] != 0 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
        return false;
    }


}

