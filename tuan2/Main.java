package tuan2;

public class Main {
	public static void main(String[] args) {
	    // Khởi tạo đồ thị
	    UnDirectedGraph graph = new UnDirectedGraph(6);
	    graph.addEdge(0, 1);
	    graph.addEdge(0, 2);
	    graph.addEdge(1, 3);
	    graph.addEdge(2, 3);
	    graph.addEdge(2, 4);
	    graph.addEdge(3, 5);
	    
	    // Kiểm tra xem đồ thị có phải là đơn đồ thị hay không
	    boolean isSimple = graph.isSimpleGraph();
	    System.out.println("Có phải đơn đồ thị không? " + isSimple);
	    
	    // Duyệt đồ thị theo chiều rộng (BFS)
	    System.out.println("BFS:");
	    graph.BFS(0);
	    System.out.println();
	    // Duyệt đồ thị theo chiều sâu (DFS)
	    System.out.println("DFS:");
	    graph.DFS(0);
	    System.out.println();
	    // Kiểm tra đường đi từ đỉnh x đến đỉnh y cho trước
	    int x = 0;
	    int y = 5;
	    boolean hasPath = graph.hasPathBFS(x, y);
	    System.out.println("Có đường đi từ đỉnh " + x + " đến đỉnh " + y + "? " + hasPath);
	}

}