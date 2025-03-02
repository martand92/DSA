package DSA.Bucket4._09_graph.medium._01_MST_Undirected;

import java.util.*;

public class _14_PrimsAlgo_PriorityQ_FindMST {

	static class Node {
		int v;
		int weight;

		Node(int v, int w) {
			this.v = v;
			this.weight = w;
		}
	}

	static class Graph {

		static int[][] adjMatrix;
		static int[] keys;
		static boolean[] inMST;

		Graph(int v) {
			adjMatrix = new int[v][v];
			keys = new int[v];
			Arrays.fill(keys, Integer.MAX_VALUE);
			inMST = new boolean[v];
		}

		// Adding Undirected Edge
		public void addEdge(int srcVertex, int destVertex, int w) {
			if (srcVertex != destVertex) {
				adjMatrix[destVertex][srcVertex] = w;
				adjMatrix[srcVertex][destVertex] = w;
			}
		}

		// removing loops
		public void removeLoops() {
			for (int i = 0; i < adjMatrix.length; i++)
				adjMatrix[i][i] = 0;
		}

		// function to find MST of given vertex
		public static int findMST(int vertex) {

			Queue<Node> pq = new PriorityQueue<Node>(new Comparator<Node>() {
				public int compare(Node a, Node b) {
					return a.weight - b.weight;
				}
			});

			pq.add(new Node(vertex, 0));

			while (!pq.isEmpty()) {
				vertex = pq.poll().v;
				inMST[vertex] = true;

				for (int i = 0; i < adjMatrix.length; i++) {
					if (adjMatrix[vertex][i] != 0 && !inMST[i] && keys[i] > adjMatrix[vertex][i]) {
						keys[i] = adjMatrix[vertex][i];
						pq.add(new Node(i, keys[i]));
					}
				}
			}

			int sum = 0;
			for (int key : Graph.keys) {
				if (key != Integer.MAX_VALUE)
					sum += key;
			}

			return sum;
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

			// Step 2 : Find MST from starting vertex as 0
			System.out.println("Min Spanning Tree of given graph : " + findMST(0));// starting with 0th vertex
		}
	}

}