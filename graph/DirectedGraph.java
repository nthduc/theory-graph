package graph;

public class DirectedGraph extends AGraph {

	/*Loop counts as 2 here*/
	public DirectedGraph(int num) {
		super(num);
	}

	@Override
	public void addEdge(int p1, int p2) {
		if (p1 < 0 || p1 >= this.maxVertex || p2 < 0 | p2 >= this.maxVertex)
			return;
		this.adjMatrix[p1][p2]++;
	}

	@Override
	public void removeEdge(int p1, int p2) {
		if (p1 < 0 || p1 >= this.maxVertex || p2 < 0 | p2 >= this.maxVertex)
			return;
		if (this.adjMatrix[p1][p2] > 0) {
			this.adjMatrix[p1][p2]--;
		}
	}

	@Override
	public int deg(int point) {
		if (point < 0 || point >= this.maxVertex)
			return Integer.MIN_VALUE;
		return degIn(point) + degOut(point);
	}

	private int degOut(int point) {
		int result = 0;
		for (int i = 0; i < this.maxVertex; i++)
			result += this.adjMatrix[point][i];
		return result;
	}

	private int degIn(int point) {
		int result = 0;
		for (int i = 0; i < this.maxVertex; i++)
			result += this.adjMatrix[i][point];
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

}
