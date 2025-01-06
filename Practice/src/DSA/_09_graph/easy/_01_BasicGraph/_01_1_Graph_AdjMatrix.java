package DSA._09_graph.easy._01_BasicGraph;

import java.util.Arrays;

public class _01_1_Graph_AdjMatrix {

	static class Graph {

		int[][] adjMatrix;

		Graph(int v) { // v : no of vertices
			adjMatrix = new int[v + 1][v + 1]; // Declaring matrix of length v * v, initialized 0 by default with 1
												// based indexing
		}

		void addEdge(int u, int v) {
			adjMatrix[u][v] = 1;
			adjMatrix[v][u] = 1; // if graph is undirected
		}

		public static void main(String args[]) {
			Graph g = new Graph(5);// 1,2,3,4,5

			g.addEdge(1, 2);// 1->2 && 2->1
			g.addEdge(1, 3);
			g.addEdge(3, 4);
			g.addEdge(2, 4);
			g.addEdge(2, 5);
			g.addEdge(4, 5);

			System.out.println(Arrays.deepToString(g.adjMatrix));
		}

	}

}
