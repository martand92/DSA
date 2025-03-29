package DSA.Bucket5._09_graph.medium._06_Eulerian;

import java.util.*;

//https://www.geeksforgeeks.org/euler-circuit-directed-graph/

//Graph is said to be Eulerian if it has Eulerian circuit (and not just eulerian path)

/*Condition for directed graph to be Eulerian:
 * 1. Check if given graph is strongly-connected component i.e it has 1 SCC
 * 2. If in-degree = out-degree for every vertex then its Eulerian circuit
 * 3. If in-degree = out-degree + 1 of a vertex and out-degree = indegree + 1 of another vertex then its Eulerian path
 * 4. Else its not Eulerain
 */

public class _11_Eulerian_Directed {

	static class Graph {

		LinkedList<Integer> adjList[];
		LinkedList<Integer> transposeGraph[];
		boolean[] visited;
		int[] indegree;
		int[] outdegree;
		Stack<Integer> st;

		Graph(int v) {

			adjList = new LinkedList[v];
			transposeGraph = new LinkedList[v];

			for (int i = 0; i < v; i++) {
				adjList[i] = new LinkedList<Integer>();
				transposeGraph[i] = new LinkedList<Integer>();
			}

			indegree = new int[v];
			outdegree = new int[v];
			visited = new boolean[v];
			st = new Stack<Integer>();
		}

		// directed graph
		public void addEdge(int u, int v) {
			adjList[u].add(v);
		}

		public void dfs1(int vertex) {
			visited[vertex] = true;
			for (int i : adjList[vertex]) {
				if (!visited[i])
					dfs1(i);
			}
			st.push(vertex);
		}

		public void dfs2(int vertex) {
			visited[vertex] = true;
			for (int i : transposeGraph[vertex]) {
				if (!visited[i])
					dfs2(i);
			}
		}

		public boolean isStronglyConnected_Kosaraju() {

			// do dfs on all the vertices starting from any vertex even if its disconnected.
			// Unlike Undirected graph where you had to start from vertex with non-zero
			// degree
			for (int i = 0; i < adjList.length; i++) {
				if (!visited[i])
					dfs1(i);
			}

			// Create transposed graph
			for (int i = 0; i < adjList.length; i++) {
				for (int j : adjList[i])
					transposeGraph[j].add(i);
			}

			// count scc in transposed graph
			visited = new boolean[adjList.length];
			int scc = 0;

			while (!st.isEmpty()) {

				int v = st.pop();

				if (!visited[v]) {
					scc++;
					dfs2(v);
				}
			}

			// If transposed graph has more than 1 scc then graph is not Eulerian
			if (scc > 1)
				return false;

			return true;
		}

		// return 0 : if not Eulerian
		// return 1 : if has only Eulerian path
		// return 2 : if has Eulerian cycle
		public int isEulerian() {

			// Check if graph has 1 scc, else its not eulerian
			if (!isStronglyConnected_Kosaraju())
				return 0;

			// find out-degree and in-degree of all vertices
			for (int i = 0; i < adjList.length; i++)
				outdegree[i] = adjList[i].size();

			for (int i = 0; i < adjList.length; i++)
				for (int j : adjList[i])
					indegree[j]++;

			int eulerianPathCount = 0;

			// Verify if graph is eulerian path
			for (int i = 0; i < adjList.length; i++) {

				if (indegree[i] != outdegree[i]) {

					if (indegree[i] == outdegree[i] + 1)
						eulerianPathCount++;

					else if (outdegree[i] == indegree[i] + 1)
						eulerianPathCount++;

					else // if for any vertex if in-degree / out-degree differ by > 1 then graph is not
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

	public static void main(String[] args) {

		Graph g = new Graph(5);

		g.addEdge(1, 0);
		g.addEdge(0, 2);
		g.addEdge(2, 1);
		g.addEdge(0, 3);
		g.addEdge(3, 4);
		g.addEdge(4, 0);

		int a = g.isEulerian();

		if (a == 0)
			System.out.println("Graph is not Eulerian");

		else if (a == 1)
			System.out.println("Graph is Semi-Eulerian");

		else if (a == 2)
			System.out.println("Graph is Eulerian");

	}
}