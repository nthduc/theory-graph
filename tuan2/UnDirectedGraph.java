package tuan2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
	// đồ thị có liên thông không
	public boolean isConnected() {
	    // Khởi tạo một danh sách các đỉnh chưa được duyệt
	    List<Integer> unvisited = new ArrayList<Integer>();
	    for (int i = 0; i < adjMatrix.length; i++) {
	        unvisited.add(i);
	    }

	    // Khởi tạo một stack để lưu trữ các đỉnh được duyệt
	    Stack<Integer> stack = new Stack<Integer>();

	    // Lấy đỉnh bắt đầu và đánh dấu nó là đã duyệt
	    int startVertex = 0;
	    unvisited.remove((Integer) startVertex);
	    stack.push(startVertex);

	    // Duyệt đồ thị
	    while (!stack.empty()) {
	        int vertex = stack.pop();
	        for (int neighbor : adjMatrix[vertex]) {
	            if (unvisited.contains(neighbor)) {
	                // Đánh dấu đỉnh kề là đã duyệt và thêm vào stack
	                unvisited.remove((Integer) neighbor);
	                stack.push(neighbor);
	            }
	        }
	    }

	    // Nếu tất cả các đỉnh đã được duyệt, thì đồ thị là liên thông
	    return unvisited.isEmpty();
	}


}
