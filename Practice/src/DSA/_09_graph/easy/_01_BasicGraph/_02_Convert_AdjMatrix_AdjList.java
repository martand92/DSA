package DSA._09_graph.easy._01_BasicGraph;

import java.util.Arrays;
import java.util.LinkedList;

//https://www.geeksforgeeks.org/convert-adjacency-matrix-to-adjacency-list-representation-of-graph/
public class _02_Convert_AdjMatrix_AdjList {

	int[][] adjMatrix;
	LinkedList<Integer> adjList[];

	_02_Convert_AdjMatrix_AdjList(int vertices) {

		adjMatrix = new int[vertices][vertices];
		adjList = new LinkedList[vertices];

		for (int i = 0; i < vertices; i++)
			adjList[i] = new LinkedList<Integer>();
	}

	public void addEdgeToMatrix(int u, int v) {
		adjMatrix[u][v] = 1;
	}

	public LinkedList<Integer>[] transformMatrixToList() {

		for (int i = 0; i < adjMatrix.length; i++) {
			for (int j = 0; j < adjMatrix[0].length; j++) {
				if (adjMatrix[i][j] == 1)
					adjList[i].add(j);
			}
		}

		return adjList;
	}

	public static void main(String[] args) {
		_02_Convert_AdjMatrix_AdjList graph = new _02_Convert_AdjMatrix_AdjList(3);

		graph.addEdgeToMatrix(0, 2);
		graph.addEdgeToMatrix(1, 2);
		graph.addEdgeToMatrix(2, 0);
		graph.addEdgeToMatrix(2, 1);

		System.out.println(Arrays.deepToString(graph.transformMatrixToList()));

	}

}
