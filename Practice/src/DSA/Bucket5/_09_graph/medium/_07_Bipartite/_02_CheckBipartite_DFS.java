package DSA.Bucket5._09_graph.medium._07_Bipartite;

import java.util.*;

//if graph has no adjacent vertices with same color
//if graph is linear it will be bipartite
//if graph has cycle and cycle length is even, then it's bipartite
public class _02_CheckBipartite_DFS {

	static class Graph {

		static LinkedList<Integer>[] adjList;
		static int[] colored;

		Graph(int v) {

			adjList = new LinkedList[v + 1]; // 1 based indexing
			for (int i = 0; i <= v; i++)
				adjList[i] = new LinkedList<>();

			colored = new int[v + 1];
			Arrays.fill(colored, -1);

		}

		void addEdge(int u, int v) {
			adjList[u].add(v);
			adjList[v].add(u);
		}

		public static boolean checkBipartite(int vertex, int lastColoured) {

			colored[vertex] = lastColoured == 0 ? 1 : 0;

			for (int i : adjList[vertex]) {

				if (colored[i] == colored[vertex])
					return false;

				// consider vertex thats not colored
				if (colored[i] == -1) {
					if (!checkBipartite(i, colored[vertex]))
						return false;
				}
			}

			return true;
		}

		public static void main(String[] args) {
			int noOfVertices = 8;
			Graph g = new Graph(noOfVertices);

			// Not Bipartite graph data
			g.addEdge(1, 2);
			g.addEdge(2, 3);
			g.addEdge(2, 6);
			g.addEdge(3, 4);
			g.addEdge(4, 5);
			g.addEdge(4, 7);
			g.addEdge(5, 6);
			g.addEdge(7, 8);

			// Bipartite graph data
//			g.addEdge(1, 2);
//			g.addEdge(2, 3);
//			g.addEdge(2, 5);
//			g.addEdge(3, 4);
//			g.addEdge(5, 4);
//			g.addEdge(4, 6);

			System.out.println(checkBipartite(1, 1));

		}
	}
}