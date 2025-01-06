package DSA._09_graph.easy;

import java.util.*;

//https://practice.geeksforgeeks.org/problems/count-the-paths4332/1
public class _06_countThePath_imp {

	static int count = 0;

	static class Graph {
		LinkedList<Integer>[] adj;

		Graph(int v) {
			adj = new LinkedList[v];
			for (int i = 0; i < v; i++)
				adj[i] = new LinkedList<Integer>();
		}

		public void addEdge(int srcVertex, int destVertex) {
			adj[srcVertex].add(destVertex);
		}

		public int dfs(LinkedList<Integer>[] adj, int s, int d) {
			if (s == d)
				return ++count;

			for (int i : adj[s])
				count = dfs(adj, i, d);

			return count;
		}

		public static void main(String[] args) {
			Graph g = new Graph(4);
			g.addEdge(0, 1);
			g.addEdge(0, 2);
			g.addEdge(0, 3);
			g.addEdge(1, 3);
			g.addEdge(2, 1);

			System.out.println(g.dfs(g.adj, 0, 3));

		}

	}

}
