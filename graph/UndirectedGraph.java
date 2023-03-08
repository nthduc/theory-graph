package graph;

public class UndirectedGraph extends AGraph {

	/*Loop counts as 2 here*/
	public UndirectedGraph(int num) {
		super(num);
	}

	@Override
	public void addEdge(int p1, int p2) {
		if (p1 < 0 || p1 >= this.maxVertex || p2 < 0 | p2 >= this.maxVertex)
			return;
		this.adjMatrix[p1][p2]++;
		this.adjMatrix[p2][p1]++;
	}

	@Override
	public void removeEdge(int p1, int p2) {
		if (p1 < 0 || p1 >= this.maxVertex || p2 < 0 | p2 >= this.maxVertex)
			return;
		if (this.adjMatrix[p1][p2] > 0 && this.adjMatrix[p2][p1] > 0) {
			this.adjMatrix[p1][p2]--;
			this.adjMatrix[p2][p1]--;
		}
	}

	@Override
	public int deg(int point) {
		if (point < 0 || point >= this.maxVertex)
			return -10;
		int result = 0;
		for (int i = 0; i < this.maxVertex; i++)
			result += this.adjMatrix[point][i];
		return result;
	}

	@Override
	public void printEdgeList() {
		for (int row = 0; row < this.adjMatrix.length; row++)
			for (int column = row; column < this.adjMatrix[row].length; column++)
				if (this.adjMatrix[row][column] > 0)
					for (int k = 0; k < this.adjMatrix[row][column]; k++)
						System.out.printf("(%d, %d) ", row, column);
		System.out.println();
	}

	@Override
	public int numEdges() {
		int result = 0;
		for (int row = 0; row < this.adjMatrix.length; row++)
			for (int column = 0; column < this.adjMatrix[row].length; column++)
				result += this.adjMatrix[row][column];
		return result / 2;
	}
	
	public boolean isBipartiteGraph() {
		for (int row = 0; row < this.adjMatrix.length; row++)
			for (int column = 0; column < this.adjMatrix[row].length; column++)
				if (this.adjMatrix[row][column] == 2)
					return false;
		throw new NoSuchMethodError("This method is NOT completed");
	}

}
