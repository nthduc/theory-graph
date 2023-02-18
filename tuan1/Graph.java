package tuan1;

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
}

