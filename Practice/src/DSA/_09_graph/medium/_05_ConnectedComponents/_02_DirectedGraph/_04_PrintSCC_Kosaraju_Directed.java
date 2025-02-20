package DSA._09_graph.medium._05_ConnectedComponents._02_DirectedGraph;

import java.util.*;

//https://www.geeksforgeeks.org/connectivity-in-a-directed-graph/
public class _04_PrintSCC_Kosaraju_Directed {

	public static class Graph {
		LinkedList<Integer> adjList[];
		LinkedList<Integer> transposeGraph[];
		boolean[] visited;
		Stack<Integer> st;

		public Graph(int v) {
			visited = new boolean[v];
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

		public ArrayList<Integer> dfs2(int vertex, ArrayList<Integer> list) {
			list.add(vertex);
			visited[vertex] = true;

			for (int v : transposeGraph[vertex]) {
				if (!visited[v])
					dfs2(v, list);
			}
			return list;
		}

		public List<ArrayList<Integer>> getSCC(int vertex) {

			List<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

			// Step 1 : do dfs on all available components
			visited = new boolean[adjList.length];
			for (int i = 0; i < adjList.length; i++) { // ensures even disconnected nodes are also considered
				if (!visited[i])
					dfs1(i);
			}

			// Get transpose of given graph
			for (int u = 0; u < adjList.length; u++) {
				for (int v : adjList[u])
					transposeGraph[v].add(u);
			}

			visited = new boolean[transposeGraph.length]; // reset
			while (!st.isEmpty()) {
				int v = st.pop();
				if (!visited[v])
					result.add(dfs2(v, new ArrayList<Integer>()));
			}

			return result;
		}

		public static void main(String[] args) {

			Graph g1 = new Graph(5);
			g1.addEdge(0, 1);
			g1.addEdge(1, 2);
			g1.addEdge(2, 3);
			g1.addEdge(3, 0);
			g1.addEdge(2, 4);
			g1.addEdge(4, 2);
			System.out.println("SCC are : " + g1.getSCC(0));

			Graph g2 = new Graph(4);
			g2.addEdge(0, 1);
			g2.addEdge(1, 2);
			g2.addEdge(2, 3);
			System.out.println("SCC are : " + g2.getSCC(0));

			Graph g3 = new Graph(8);
			g3.addEdge(0, 1);
			g3.addEdge(1, 2);
			g3.addEdge(2, 0);
			g3.addEdge(2, 3);
			g3.addEdge(3, 4);
			g3.addEdge(4, 5);
			g3.addEdge(4, 7);
			g3.addEdge(5, 6);
			g3.addEdge(6, 4);
			g3.addEdge(6, 7);
			System.out.println("SCC are : " + g3.getSCC(0));
		}

	}

}
