package tuan1;

public class Main {
	public static void main(String[] args) {
		// Khởi tạo đồ thị có 5 đỉnh
		UnDirectedGraph g = new UnDirectedGraph(5);
		// Thêm các cạnh vào đồ thị
		g.addEdge(0, 1);
		g.addEdge(0, 4);
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(1, 4);
		g.addEdge(2, 3);
		g.addEdge(3, 4);
		// In ma trận kề của đồ thị
		g.printAdjMatrix();
		// In danh sách các cạnh của đồ thị
		g.printListEdges();
		// In bậc của mỗi đỉnh
		for (int i = 0; i < 5; i++) {
			System.out.println("Bậc của đỉnh " + i + " là " + g.degree(i));
		}
		// In số cạnh của đồ thị
		System.out.println("Số cạnh: " + g.numEdges());
		
		
		
		// Khởi tạo đồ thị có 5 đỉnh
	    DirectedGraph g2 = new DirectedGraph(5);
	    // Thêm các cạnh vào đồ thị
	    g2.addEdge(0, 1);
	    g2.addEdge(0, 4);
	    g2.addEdge(1, 2);
	    g2.addEdge(1, 3);
	    g2.addEdge(2, 3);
	    g2.addEdge(3, 4);
	    // In ma trận kề của đồ thị
	    g2.printAdjMatrix();
	    // In danh sách các cạnh của đồ thị
	    g2.printListEdges();
	    // In bậc vào và ra của mỗi đỉnh
	    for (int i = 0; i < 5; i++) {
	        System.out.println("Đỉnh bậc trong " + i + " là " + g2.inDegree(i));
	        System.out.println("Đỉnh bậc ngoài " + i + " là " + g2.outDegree(i));
	    }
	    // In số cạnh của đồ thị
	    System.out.println("Số cạnh: " + g.numEdges());

	}
}