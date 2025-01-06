package DSA._09_graph.medium._03_MST_Undirected;

import java.util.*;

public class _14_02_PrimsAlgo_WithParallelEdge {

	static class Graph {

		// AdjMatrix with list of integers indicating parallel edges
		LinkedList<Integer>[][] adjMatrix;

		// Set that are part of MST
		ArrayList<Integer> mstSet = new ArrayList<Integer>();

		// Set holds least weighted vertices
		int[] keys;

		Graph(int v) {

			adjMatrix = new LinkedList[v][v];

			for (int i = 0; i < v; i++)
				for (int j = 0; j < v; j++)
					adjMatrix[i][j] = new LinkedList<Integer>();

			keys = new int[v];
			Arrays.fill(keys, Integer.MAX_VALUE);
		}

		// Adding Undirected Edge between src & dest
		public void addEdge(int srcVertex, int destVertex, int w) {
			if (srcVertex != destVertex) {
				adjMatrix[destVertex][srcVertex].add(w);
				adjMatrix[srcVertex][destVertex].add(w);
			}
		}

		// removing loops from vertices by clearing diagonal elements
		public void removeLoops() {
			for (int i = 0; i < adjMatrix.length; i++)
				adjMatrix[i][i].clear();
		}

		// Consider adj vertex of this vertex only if its less weighted
		public void findAdjVertices(int vertex) {

			for (int i = 0; i < adjMatrix[0].length; i++) {

				if (!adjMatrix[vertex][i].isEmpty() && !mstSet.contains(i))
					if (adjMatrix[vertex][i].get(0) < keys[i])
						keys[i] = adjMatrix[vertex][i].get(0);

			}
		}

		// considering less weighted edge from parallel edges between same vertices
		public void removeParallelEdges() {

			for (int i = 0; i < adjMatrix.length; i++) {

				for (int j = 0; j < adjMatrix[0].length; j++) {

					if (adjMatrix[i][j].size() > 1) {

						int min = adjMatrix[i][j].get(0);

						for (int k = 1; k < adjMatrix[i][j].size(); k++) {

							if (adjMatrix[i][j].get(k) < min)
								min = adjMatrix[i][j].get(k);
						}

						adjMatrix[i][j].clear();
						adjMatrix[i][j].add(min);
					}

				}
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
		g.addEdge(1, 3, 8);// parallel edge
		g.addEdge(2, 3, 4);
		g.addEdge(2, 4, 3);
		g.addEdge(3, 4, 2);
		g.addEdge(4, 5, 2);
		g.addEdge(5, 3, 5);
		g.addEdge(5, 5, 1);// loop

		// Step 1:Remove loops from graph. In Adj Matrix, diagonal ele are loops
		g.removeLoops();

		// Step 2 : If parallel edges, then keep min weighted edge in graph
		g.removeParallelEdges();

		// Step 3 : Find MST from starting vertex as 0
		System.out.println("Min Spanning Tree of given graph : " + g.findMST(0));
	}
}
