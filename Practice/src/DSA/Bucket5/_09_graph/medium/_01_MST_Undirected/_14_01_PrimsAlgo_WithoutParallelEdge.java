package DSA.Bucket5._09_graph.medium._01_MST_Undirected;

import java.util.*;

public class _14_01_PrimsAlgo_WithoutParallelEdge {

	static class Graph {

		int[][] adjMatrix;
		boolean[] visited;
		int[] keys;

		Graph(int v) {
			adjMatrix = new int[v][v];
			keys = new int[v];
			Arrays.fill(keys, Integer.MAX_VALUE);
			visited = new boolean[v];
		}

		// Adding Undirected Edge between src & dest
		public void addEdge(int srcVertex, int destVertex, int w) {
			if (srcVertex != destVertex) {
				adjMatrix[destVertex][srcVertex] = w;
				adjMatrix[srcVertex][destVertex] = w;
			}
		}

		// removing loops from vertices by clearing diagonal elements
		public void removeLoops() {
			for (int i = 0; i < adjMatrix.length; i++)
				adjMatrix[i][i] = 0;
		}

		// function to find MST of given vertex
		public int findMST(int vertex) {

			for (int count = 0; count < adjMatrix.length; count++) {

				visited[vertex] = true;

				// update adj vertices of current vertex with weight if its lesser
				for (int j = 0; j < adjMatrix[0].length; j++) {
					if (adjMatrix[vertex][j] != 0 && !visited[j] && adjMatrix[vertex][j] < keys[j])
						keys[j] = adjMatrix[vertex][j];
				}

				// Select next least weighted vertex which is not in mstSet
				int min = keys[0];
				for (int i = 1; i < keys.length; i++) {
					if (!visited[i] && keys[i] < min) {
						min = keys[i];
						vertex = i;
					}
				}
			}

			System.out.println(Arrays.toString(keys));

			int mstSum = 0;
			for (int key : keys) {
				if (key != Integer.MAX_VALUE)
					mstSum += key;
			}

			return mstSum;
		}
	}

	public static void main(String[] args) {

		Graph g = new Graph(6);
		g.addEdge(0, 1, 7);
		g.addEdge(0, 2, 8);
		g.addEdge(1, 2, 3);
		g.addEdge(1, 3, 6);
		g.addEdge(2, 3, 4);
		g.addEdge(2, 4, 3);
		g.addEdge(3, 4, 2);
		g.addEdge(4, 5, 2);
		g.addEdge(5, 3, 5);
		g.addEdge(5, 5, 1);// loop

		// Step 1:Remove loops from graph. In Adj Matrix, diagonal ele are loops
		g.removeLoops();

		// Step 2 : Find MST from starting vertex as 0
		System.out.println("Min Spanning Tree of given graph : " + g.findMST(0));
	}
}
