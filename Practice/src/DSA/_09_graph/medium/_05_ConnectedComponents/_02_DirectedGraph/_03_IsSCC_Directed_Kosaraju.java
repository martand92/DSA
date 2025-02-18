package DSA._09_graph.medium._05_ConnectedComponents._02_DirectedGraph;

import java.util.LinkedList;

//https://www.geeksforgeeks.org/connectivity-in-a-directed-graph/
public class _03_IsSCC_Directed_Kosaraju {

	public static class Graph {

		LinkedList<Integer> adjList[];
		LinkedList<Integer> transposeGraph[];
		boolean[] visited;

		public Graph(int v) {
			visited = new boolean[v];
			adjList = new LinkedList[v];
			transposeGraph = new LinkedList[v];

			for (int i = 0; i < v; i++) {
				adjList[i] = new LinkedList<Integer>();
				transposeGraph[i] = new LinkedList<Integer>();
			}

		}

		public void addEdge(int u, int v) {
			adjList[u].add(v);// Directed Graph
		}

		public void dfs(int vertex, LinkedList<Integer>[] adjList) {
			visited[vertex] = true;
			for (int v : adjList[vertex]) {
				if (!visited[v])
					dfs(v, adjList);
			}
		}

		public boolean isStronglyConnected(int vertex) {

			// Step 1 : check if all the vertices are strongly connected in given graph
			dfs(vertex, adjList);
			for (boolean v : visited) {
				if (!v)
					return false;
			}

			// Step 2 : Create transposed graph
			for (int i = 0; i < adjList.length; i++) {
				for (int v : adjList[i])
					transposeGraph[v].add(i);// add edge v -> u in new transposed graph
			}

			// Step 3 : Do dfs again & check if all transposed graph vertices are visited
			visited = new boolean[adjList.length]; // reset
			dfs(vertex, transposeGraph);
			for (boolean v : visited) {
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
			String output = g1.isStronglyConnected(0) == true ? "Strongly connected" : "Not Strongly connected";
			System.out.println(output);

			Graph g2 = new Graph(4);
			g2.addEdge(0, 1);
			g2.addEdge(1, 2);
			g2.addEdge(2, 3);
			output = g2.isStronglyConnected(0) == true ? "Strongly connected" : "Not Strongly connected";
			System.out.println(output);

		}

	}

}
