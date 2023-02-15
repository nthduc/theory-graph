package week1;

public class Main {
	public static void main(String[] args) {
		Graph graph = new Graph(6);

		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(2, 3);
		graph.addEdge(2, 4);
		graph.addEdge(3, 4);
		graph.addEdge(3, 5);

		// In danh sách kề
		System.out.println("Danh sách kề:");
		graph.printAdjList();

		// In danh sách cạnh
		System.out.println("Danh sách cạnh:");
		graph.numEdges();

		// Tính nửa bậc vào và ra của mỗi đỉnh
		for (int i = 0; i < 5; i++) {
			System.out.println("Nửa bậc trong của đỉnh " + i + " là: " + graph.inDegree(i));
			System.out.println("Nửa bậc ngoài của đỉnh " + i + " là: " + graph.outDegree(i));
		}

		// Tính bậc của mỗi đỉnh
		for (int i = 0; i < 5; i++) {
			System.out.println("Bậc của đỉnh " + i + " là: " + graph.degree(i));
		}

		// Tính số cạnh của đồ thị
		System.out.println("Số cạnh của đồ thị là: " + graph.numEdges());

		// Kiểm tra xem đồ thị có phải là lưỡng phân không
		if (graph.isBipartite()) {
			System.out.println("Đồ thị là lưỡng phân");
		} else {
			System.out.println("Đồ thị không phải là lưỡng phân");
		}

		// Xóa một cạnh
		graph.removeEdge(1, 3);

		// In danh sách kề sau khi xóa cạnh
		System.out.println("Danh sách kề sau khi xóa cạnh:");
		graph.printAdjList();
	}
}
