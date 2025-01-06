package DSA._09_graph.medium._07_ConnectedComponents;

import java.util.Arrays;
import java.util.LinkedList;

//https://www.geeksforgeeks.org/connectivity-in-a-directed-graph/
public class _03_IsSCC_Directed_Kosaraju {

	public static class Graph {

		LinkedList<Integer> adjList[];
		boolean[] visited;

		public Graph(int v) {

			adjList = new LinkedList[v];

			for (int i = 0; i < v; i++)
				adjList[i] = new LinkedList<Integer>();

			visited = new boolean[v];
		}

		public void addEdge(int u, int v) {
			adjList[u].add(v);// Directed Graph
		}

		// check if all the vertices are visited
		public void dfs(int vertex) {

			visited[vertex] = true;

			for (int v : adjList[vertex]) {
				if (!visited[v])
					dfs(v);
			}
		}

		public Graph getTranspose() {

			// create new transposed graph
			Graph transposeGraph = new Graph(adjList.length);

			for (int u = 0; u < adjList.length; u++) {
				for (int v : adjList[u]) // u->v, requirement : v->u
					// add edge v -> u in new transposed graph
					transposeGraph.adjList[v].add(u);
			}

			return transposeGraph;
		}

		public boolean isStronglyConnected(int vertex) {

			// first check if all the vertices are strongly connected in given graph
			dfs(vertex);
			for (boolean v : visited) {
				if (!v)
					return false;
			}

			// Get transpose of given graph
			Graph transposeGraph = getTranspose();

			// reset visited array to false
			Arrays.fill(visited, false);

			// Do DFS of transposed graph
			transposeGraph.dfs(vertex);

			// again check if all transposed graph vertices are visited
			for (boolean v : transposeGraph.visited) {
				if (!v)
					return false;
			}

			return true;
		}

		public static void main(String[] args) {

			Graph g1 = new Graph(5);
			g1.addEdge(0, 1);
			g1.addEdge(1, 2);
			g1.addEdge(2, 3);
			g1.addEdge(3, 0);
			g1.addEdge(2, 4);
			g1.addEdge(4, 2);

			if (g1.isStronglyConnected(0))
				System.out.println("Strongly connected");
			else
				System.out.println("Not Strongly connected");

			Graph g2 = new Graph(4);
			g2.addEdge(0, 1);
			g2.addEdge(1, 2);
			g2.addEdge(2, 3);

			if (g2.isStronglyConnected(0))
				System.out.println("Strongly connected");
			else
				System.out.println("Not Strongly connected");

		}

	}

}
