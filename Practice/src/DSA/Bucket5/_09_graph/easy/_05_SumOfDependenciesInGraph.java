package DSA.Bucket5._09_graph.easy;

import java.util.*;

//https://practice.geeksforgeeks.org/problems/sum-of-dependencies-in-a-graph5311/1
public class _05_SumOfDependenciesInGraph {

	static class Graph {

		static LinkedList<Integer>[] adjList;

		Graph(int v) {

			adjList = new LinkedList[v];

			for (int i = 0; i < v; i++)
				adjList[i] = new LinkedList<Integer>();
		}

		public void addEdge(int u, int v) {
			adjList[u].add(v);
		}

		public int sumOfDependencies(LinkedList<Integer>[] adjList) {

			int count = 0;
			for (int i = 0; i < adjList.length; i++) {
				count += adjList[i].size();
			}

			return count;
		}

		public int sumOfDependencies_Opt(int[][] edges) {
			return edges.length; // as need to find sum of out-degree of each vertex
		}

		public static void main(String[] args) {

			int[][] edges = { { 0, 2 }, { 0, 3 }, { 1, 3 }, { 2, 3 } };

			Graph g = new Graph(4);

			for (int i = 0; i < edges.length; i++)
				g.addEdge(edges[i][0], edges[i][1]);

			System.out.println(g.sumOfDependencies(adjList));
			System.out.println(g.sumOfDependencies_Opt(edges));
		}
	}

}
