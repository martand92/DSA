package DSA.Bucket5._09_graph.medium._04_ConnectedComponents._02_DirectedGraph;

import java.util.*;

//https://www.geeksforgeeks.org/connectivity-in-a-directed-graph/
public class _03_IsSCC_Kosaraju_Directed {

	public static class Graph {

		LinkedList<Integer> adjList[];
		LinkedList<Integer> transposeGraph[];
		boolean[] visited;
		Stack<Integer> st;

		public Graph(int v) {

			adjList = new LinkedList[v];
			transposeGraph = new LinkedList[v];
			st = new Stack<Integer>();

			for (int i = 0; i < v; i++) {
				adjList[i] = new LinkedList<Integer>();
				transposeGraph[i] = new LinkedList<Integer>();
			}
		}

		public void addEdge(int u, int v) {
			adjList[u].add(v);// Directed Graph
		}

		public void dfs1(int vertex) {

			visited[vertex] = true;

			for (int v : adjList[vertex]) {
				if (!visited[v])
					dfs1(v);
			}

			st.push(vertex);
		}

		public void dfs2(int vertex) {

			visited[vertex] = true;

			for (int v : transposeGraph[vertex]) {
				if (!visited[v])
					dfs2(v);
			}
		}

		public boolean isStronglyConnected() {

			// Step 1 : do dfs on all available components
			visited = new boolean[adjList.length];
			for (int i = 0; i < adjList.length; i++) { // ensures even disconnected nodes are also considered
				if (!visited[i])
					dfs1(i);
			}

			// Step 2 : Create transposed graph
			for (int i = 0; i < adjList.length; i++) {
				for (int v : adjList[i])
					transposeGraph[v].add(i);// add edge v -> u in new transposed graph
			}

			// Step 3 : Process nodes in stack order and count components
			visited = new boolean[transposeGraph.length]; // reset
			int components = 0;

			while (!st.isEmpty()) {

				int v = st.pop();

				if (!visited[v]) {
					components++;
					dfs2(v);
				}
			}

			// If there's more than one component, it's not strongly connected
			return components == 1;
		}

		public static void main(String[] args) {

			Graph g1 = new Graph(5);
			g1.addEdge(0, 1);
			g1.addEdge(1, 2);
			g1.addEdge(2, 3);
			g1.addEdge(3, 0);
			g1.addEdge(2, 4);
			g1.addEdge(4, 2);
			String output = g1.isStronglyConnected() == true ? "Strongly connected" : "Not Strongly connected";
			System.out.println(output);

			Graph g2 = new Graph(4);
			g2.addEdge(0, 1);
			g2.addEdge(1, 2);
			g2.addEdge(2, 3);
			output = g2.isStronglyConnected() == true ? "Strongly connected" : "Not Strongly connected";
			System.out.println(output);
		}
	}
}

//TC : First DFS: O(V + E) , Graph Transposition: O(V + E) , Second DFS: O(V + E). Hence : Total Complexity: O(V + E)