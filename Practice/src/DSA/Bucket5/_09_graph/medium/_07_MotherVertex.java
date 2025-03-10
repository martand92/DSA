package DSA.Bucket5._09_graph.medium;

import java.util.*;

//https://practice.geeksforgeeks.org/problems/mother-vertex/1
public class _07_MotherVertex {

	static class Graph {
		int v;
		LinkedList<Integer>[] adj;
		boolean[] visited;

		Graph(int v) {
			adj = new LinkedList[v];
			visited = new boolean[v];

			for (int i = 0; i < v; i++)
				adj[i] = new LinkedList<Integer>();
		}

		public void addEdge(int srcVertex, int destVertex) {
			adj[srcVertex].add(destVertex);
		}

		public int findDFSOfEachVertex(LinkedList<Integer>[] adj, int vertex, int count, boolean[] visited) {

			visited[vertex] = true;

			for (int i : adj[vertex]) {
				if (!visited[i])
					count = findDFSOfEachVertex(adj, i, count + 1, visited);
			}

			return count;
		}

		public int findMotherVertex(int V, LinkedList<Integer>[] adj) {

			for (int i = 0; i < V; i++) {
				int count = findDFSOfEachVertex(adj, i, 1, new boolean[V]);
				if (count == V)
					return i;
			}

			return -1;
		}

		public static void main(String[] args) {

			Graph g = new Graph(6);

			g.addEdge(0, 1);
			g.addEdge(0, 2);
			g.addEdge(0, 3);
			g.addEdge(1, 3);
			g.addEdge(1, 4);
			g.addEdge(2, 4);
			g.addEdge(2, 5);

			System.out.println(g.findMotherVertex(6, g.adj));
		}
	}
}