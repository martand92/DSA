package DSA.Bucket5._09_graph.medium._04_ConnectedComponents._01_UnDirectedGraph;

import java.util.*;

//Intuition : Ultimate parent of connected components are same. Hence find ult parents of all the vertices.  
public class _02_FindNoOfCC_DisjointSet {

	static class Graph {

		static LinkedList<Integer>[] adjList;

		Graph(int v) {
			adjList = new LinkedList[v];
			for (int i = 0; i < v; i++)
				adjList[i] = new LinkedList<Integer>();
		}

		public static void addEdge(int u, int v) {
			adjList[u].add(v);
			adjList[v].add(u);
		}

		public static int findUltParent(int v, int[] parent) {

			if (v == parent[v])
				return v;

			return parent[v] = findUltParent(parent[v], parent);
		}

		public static void unionByRank(int u, int v, int[] parent, int[] rank) {

			if (rank[u] > rank[v])
				parent[v] = u;

			else if (rank[u] < rank[v])
				parent[u] = v;

			else {
				parent[v] = u;
				rank[u]++;
			}
		}

		public static int NumOfCC() {

			int[] parent = new int[adjList.length];
			for (int i = 0; i < parent.length; i++)
				parent[i] = i;

			int[] rank = new int[adjList.length];

			// Vertices that are connected in a graph will be united to form single
			// component with 1 ult parent
			for (int i = 0; i < adjList.length; i++) {

				for (int j : adjList[i]) {

					if (i < j) {
						int ult_i = findUltParent(i, parent);
						int ult_j = findUltParent(j, parent);

						if (ult_i != ult_j)
							unionByRank(i, j, parent, rank);
					}

				}
			}

			// At this point all vertices of connected components in a graph will have 1
			// ultimate parent. Hence each component will have respective ult parent
			HashSet<Integer> hs = new HashSet<Integer>();
			for (int i : parent)
				hs.add(i);

			System.out.println(hs);
			return hs.size();

		}

		public static void main(String[] args) {

			new Graph(6);

			addEdge(0, 1);
			addEdge(1, 2);
			addEdge(2, 3);
			addEdge(3, 0);

			addEdge(4, 5);// This component is disconnected

			System.out.println(NumOfCC());
		}

	}

}
