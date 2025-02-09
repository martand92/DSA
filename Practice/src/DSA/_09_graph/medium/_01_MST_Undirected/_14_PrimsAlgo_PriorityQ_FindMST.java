package DSA._09_graph.medium._01_MST_Undirected;

import java.util.*;

public class _14_PrimsAlgo_PriorityQ_FindMST {

	static class Graph {

		static class Node {
			int key;
			int weight;

			Node(int key, int weight) {
				this.key = key;
				this.weight = weight;
			}
		}

		// AdjMatrix with list of integers indicating parallel edges
		LinkedList<Integer>[][] adjMatrix;

		ArrayList<Integer> mstSet = new ArrayList<Integer>();

		// PQ is majorly used to get least weighted vertex at O(1) instead of again
		// looping through keys[]
		PriorityQueue<Node> pq;

		int[] keys;

		Graph(int v) {

			adjMatrix = new LinkedList[v][v];

			for (int i = 0; i < v; i++)
				for (int j = 0; j < v; j++)
					adjMatrix[i][j] = new LinkedList<Integer>();

			// keys = new int[v];

			pq = new PriorityQueue<Node>(new Comparator<Node>() {
				public int compare(Node a, Node b) {
					return a.weight - b.weight;
				}
			});

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

			pq.add(new Node(vertex, 0));

			while (mstSet.size() != adjMatrix.length) {

				vertex = pq.poll().key;
				mstSet.add(vertex);

				for (int i = 0; i < adjMatrix.length; i++) {
					// reason we have keys[] in addition to pq because access is O(1) to check
					// current value of a vertex
					if (!adjMatrix[vertex][i].isEmpty() && !mstSet.contains(i)
							&& keys[i] > adjMatrix[vertex][i].get(0)) {

						keys[i] = adjMatrix[vertex][i].get(0);

						pq.add(new Node(i, adjMatrix[vertex][i].get(0)));
					}
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
