package DSA._09_graph.medium._04_DetectCycle.Undirected;

import java.util.LinkedList;

//https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1
public class _13_Using_UnionFind {

	public static class Graph {

		static LinkedList<Integer>[] adjList;

		Graph(int v) {
			adjList = new LinkedList[v];
			for (int i = 0; i < v; i++)
				adjList[i] = new LinkedList<Integer>();

		}

		public void addEdge(int srcVertex, int destVertex) {
			adjList[srcVertex].add(destVertex);
			adjList[destVertex].add(srcVertex);
		}

		public static int findUltParent(int[] parent, int vertex) {
			if (parent[vertex] == vertex)
				return vertex;

			return parent[vertex] = findUltParent(parent, parent[vertex]);
		}

		public static void unionByRank(int[] parent, int[] rank, int ult_i, int ult_j) {
			if (rank[ult_i] < rank[ult_j])
				parent[ult_i] = ult_j;

			else if (rank[ult_i] > rank[ult_j])
				parent[ult_j] = ult_i;

			else {
				parent[ult_j] = ult_i;
				rank[ult_i]++;
			}
		}

		public static boolean isGraphCyclic() {
			int[] parent = new int[adjList.length];
			int[] rank = new int[adjList.length];

			for (int i = 0; i < adjList.length; i++) {
				parent[i] = i;
				rank[i] = 0;
			}

			for (int i = 0; i < adjList.length; i++) {
				for (int j : adjList[i]) {

					if (i < j) {// Ensure each edge is checked only once as its undirected (i->j & j->i)
						int ult_i = findUltParent(parent, i);
						int ult_j = findUltParent(parent, j);

						if (ult_i == ult_j)
							return true;

						unionByRank(parent, rank, ult_i, ult_j);
					}
				}
			}

			return false;
		}

		public static void main(String[] args) {
			Graph g = new Graph(4);
			g.addEdge(0, 1);
			g.addEdge(0, 2);
			g.addEdge(1, 2);
			g.addEdge(2, 3);
			// g.addEdge(3, 3);

			System.out.println(isGraphCyclic());
		}

	}

}
