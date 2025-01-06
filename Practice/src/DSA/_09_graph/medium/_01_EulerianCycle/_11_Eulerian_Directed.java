package DSA._09_graph.medium._01_EulerianCycle;

import java.util.*;

//https://www.geeksforgeeks.org/euler-circuit-directed-graph/

//Graph is said to be eulerian if it has eulerian cycle (and not just eulerian path)

/*Condition for directed graph to be Eulerian:
 * 1. All vertices with non-zero degree belongs to single strongly-connected component
 * 2. If in-degree = out-degree for every vertex the  its Eulerian cycle
 * 3. If in-degree = out-degree + 1 of a vertex and out-degree = indegree + 1 of another vertex then its Eulerian path
 * 4. Else its not Eulerain
 */

public class _11_Eulerian_Directed {

	static class Graph {

		LinkedList<Integer> adjList[];
		boolean[] visited;
		int[] indegree;
		int[] outdegree;

		Graph(int v) {

			adjList = new LinkedList[v];

			for (int i = 0; i < v; i++)
				adjList[i] = new LinkedList<Integer>();

			indegree = new int[v];
			outdegree = new int[v];
			visited = new boolean[v];
		}

		// directed graph
		public void addEdge(int u, int v) {
			adjList[u].add(v);
		}

		public void dfs(int vertex, Graph g) {

			g.visited[vertex] = true;

			for (int i : adjList[vertex]) {
				if (!g.visited[i])
					dfs(i, g);
			}
		}

		// find reversed or transpose of graph
		Graph getTranspose() {

			Graph g = new Graph(adjList.length);

			for (int i = 0; i < adjList.length; i++) {
				for (int j : adjList[i])
					g.adjList[j].add(i);
			}
			return g;
		}

		// All vertices with non-zero degree belong to single strongly connected
		// component
		public boolean isStronglyConnected(int vertex, Graph g) {

			// check if all vertices are connected starting from vertex 0
			dfs(vertex, g);
			for (boolean v : g.visited) {
				if (!v)
					return false;
			}

			// create transpose of original graph
			Graph transposedGraph = getTranspose();

			// Now check again if all vertices are connected starting from vertex 0 of
			// reversed graph
			// First reset visited array
			// Arrays.fill(visited, false);
			transposedGraph.dfs(0, transposedGraph);
			for (boolean v : transposedGraph.visited) {
				if (!v)
					return false;
			}

			return true;
		}

		// return 0 : if not Eulerian
		// return 1 : if has only Eulerian path
		// return 2 : if has Eulerian cycle
		public int isEulerian(int vertex, Graph g) {

			// Check if all non-zero degree vertices are connected
			if (!isStronglyConnected(vertex, g))
				return 0;

			// find out-degree of all vertices
			for (int i = 0; i < adjList.length; i++)
				outdegree[i] = adjList[i].size();

			// find in-degree of all vertices
			for (int i = 0; i < adjList.length; i++)
				for (int j = 0; j < adjList[i].size(); j++)
					indegree[adjList[i].get(j)]++;

			int eulerianPathCount = 0;

			// Check in-degree and out-degree of every vertex
			for (int i = 0; i < adjList.length; i++) {

				if (indegree[i] != outdegree[i]) {// if degrees are not same

					if (indegree[i] == outdegree[i] + 1)
						eulerianPathCount++;

					else if (outdegree[i] == indegree[i] + 1)
						eulerianPathCount++;

					else // if in-degree is not greater or lesser by 1 of out-degree, then its not
							// Eulerian
						return 0;
				}
			}

			if (eulerianPathCount == 2)
				return 1; // If only 2 vertices have in-degree > & < by 1 of out-degree, its Eulerian path

			else if (eulerianPathCount > 2)
				return 0; // If more than 2 vertices have in-degree > & < by 1 of out-degree, its
							// not-Eulerian

			return 2; // Eulerian cycle where all in-degree = out-degree
		}
	}

	boolean[] dfs(LinkedList<Integer>[] adj, boolean[] visited, int startIndex) {

		if (!visited[startIndex])
			visited[startIndex] = true;

		for (int i : adj[startIndex]) {
			if (!visited[i])
				visited = dfs(adj, visited, i);
		}

		return visited;
	}

	public static void main(String[] args) {

		Graph g = new Graph(5);
		g.addEdge(1, 0);
		g.addEdge(0, 2);
		g.addEdge(2, 1);
		g.addEdge(0, 3);
		g.addEdge(3, 4);
		g.addEdge(4, 0);

		int a = g.isEulerian(0, g);

		if (a == 0)
			System.out.println("Graph Not Eulerian");
		else if (a == 1)
			System.out.println("Graph has only Eulerian path");
		else if (a == 2)
			System.out.println("Graph has Eulerian cycle");

	}

}
