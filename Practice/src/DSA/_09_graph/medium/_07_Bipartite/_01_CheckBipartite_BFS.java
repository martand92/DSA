package DSA._09_graph.medium._07_Bipartite;

import java.util.*;

//if graph has no adjacent vertices with same color
//if graph is linear it will be bipartite
//if graph has cycle and cycle length is even, then it's bipartite

public class _01_CheckBipartite_BFS {

	static class Graph {

		static LinkedList<Integer>[] adjList;
		static int[] colored;

		Graph(int v) {

			adjList = new LinkedList[v + 1]; // 1 based indexing

			for (int i = 0; i <= v; i++)
				adjList[i] = new LinkedList<>(); // Create a new list for each vertex
			colored = new int[v + 1];
			Arrays.fill(colored, -1);
		}

		static void addEdge(int u, int v) {
			adjList[u].add(v);
			adjList[v].add(u);
		}

		// Do BFS and check for every new vertex if its adj
		public static boolean checkBipartite(int vertex) {

			Queue<Integer> q = new LinkedList<Integer>();
			q.add(vertex);

			// mark initial vertex color as 0
			colored[vertex] = 0;

			while (!q.isEmpty()) {

				int v = q.poll();

				for (int i : adjList[v]) {

					if (colored[i] == colored[v]) // if adjacent vertices have same color then graph isn't bipartite
						return false;

					if (colored[i] == -1) { // only consider not colored vertices
						colored[i] = colored[v] == 0 ? 1 : 0; // if src vertex is already colored(0) then color adj
																// vertex with 1 else with 0 (starting color)
						q.add(i);
					}
				}
			}

			return true;
		}

		public static void main(String[] args) {

			new Graph(8);

			// Not Bipartite graph data
//			g.addEdge(1, 2);
//			g.addEdge(2, 3);
//			g.addEdge(2, 6);
//			g.addEdge(3, 4);
//			g.addEdge(4, 5);
//			g.addEdge(4, 7);
//			g.addEdge(5, 6);
//			g.addEdge(7, 8);

			// Bipartite graph data
			addEdge(1, 2);
			addEdge(2, 3);
			addEdge(2, 5);
			addEdge(3, 4);
			addEdge(5, 4);
			addEdge(4, 6);

			for (int i = 1; i <= 8; i++) {// 1 based indexing + handling disconnected graph
				if (colored[i] == -1) {
					if (!checkBipartite(i)) { // if any connected component of graph is not bipartite then break
						System.out.println(false);
						return;
					}
				}
			}

			System.out.println(true); // if entire graph is bipartite
		}
	}
}