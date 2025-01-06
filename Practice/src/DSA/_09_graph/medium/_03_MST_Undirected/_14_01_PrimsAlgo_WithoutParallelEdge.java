package DSA._09_graph.medium._03_MST_Undirected;

import java.util.*;

public class _14_01_PrimsAlgo_WithoutParallelEdge {

	static class Graph {

		int[][] adjMatrix;

		// Set that are part of MST
		ArrayList<Integer> mstSet = new ArrayList<Integer>();

		// Set holds least weighted vertices
		int[] keys;

		Graph(int v) {
			adjMatrix = new int[v][v];
			keys = new int[v];
			Arrays.fill(keys, Integer.MAX_VALUE);
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

		// Consider adj vertex of this vertex only if its less weighted
		public void findAdjVertices(int vertex) {

			for (int j = 0; j < adjMatrix[0].length; j++) {

				if (adjMatrix[vertex][j] != 0 && !mstSet.contains(j) && adjMatrix[vertex][j] < keys[j])
					keys[j] = adjMatrix[vertex][j];

			}
		}

		// function to find MST of given vertex
		public ArrayList<Integer> findMST(int vertex) {

			while (mstSet.size() != adjMatrix.length) {

				mstSet.add(vertex);

				// find adj vertices
				findAdjVertices(vertex);

				// Select next least weighted vertex which is not in mstSet
				int min = keys[0];

				for (int i = 1; i < keys.length; i++)

					if (!mstSet.contains(i) && keys[i] <= min) {
						min = keys[i];
						vertex = i;
					}
			}

			return mstSet;
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
