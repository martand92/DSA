package DSA._09_graph.easy;

import java.util.ArrayList;

//https://practice.geeksforgeeks.org/problems/sum-of-dependencies-in-a-graph5311/1
public class _05_SumOfDependenciesInGraph {

	static class Graph {

		static int v;
		static ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

		Graph(int v) {
			this.v = v;
			adj = new ArrayList<ArrayList<Integer>>(v);

			for (int i = 0; i < v; i++)
				adj.add(new ArrayList<Integer>()); // Initializing each adj array index with a linked list
													// adj[linkedList,
			// linkedList, linkedList]
		}

		public void addEdge(int u, int v) {
			adj.get(u).add(v);
		}

		public int sumOfDependencies(ArrayList<ArrayList<Integer>> adj) {
			int count = 0;
			for (int i = 0; i < v; i++)
				count += adj.get(i).size();

			return count;
		}

		public static void main(String[] args) {
			Graph g = new Graph(4);
			g.addEdge(0, 2);
			g.addEdge(0, 3);
			g.addEdge(1, 3);
			g.addEdge(2, 3);

			System.out.println(g.sumOfDependencies(adj));

		}
	}

}
