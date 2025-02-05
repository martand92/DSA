package DSA._09_graph.easy._02_GraphTraversal;

import java.util.*;

//Applicable for both Directed and Undirected graphs
public class _04_DFS_ConnectedGraph_AdjList {

	static ArrayList<Integer> result = new ArrayList<Integer>();
	static boolean[] visited;// create a boolean visited array to track if a given vertex is already visited

	static class Graph {

		static int v;
		static LinkedList<Integer>[] adj;

		Graph(int v) {
			Graph.v = v; // No of vertices / nodes
			adj = new LinkedList[v]; // Initializing adj array as LinkedList
			visited = new boolean[v];

			for (int i = 0; i < v; i++)
				adj[i] = new LinkedList<Integer>();
		}

		// for vth vertex add w vertex as adjacent vertex
		public void addEdge(int v, int w) {
			adj[v].add(w);
			adj[w].add(v);
		}

		// Function to traverse Graph with DFS traversal
		public static ArrayList<Integer> DFSTraversal(int root) {

			result.add(root);
			visited[root] = true;

			for (int i : adj[root]) {// Then check for its adjacent list and pick any 1 vertex which is not visited
				if (!visited[i])
					DFSTraversal(i);// not visited adj vertex will then follow same path
			}

			return result;

		}

		public static void main(String[] args) {
			Graph g = new Graph(4);
			g.addEdge(0, 1);
			g.addEdge(0, 2);
			g.addEdge(1, 2);
			g.addEdge(2, 0);
			g.addEdge(2, 3);
			g.addEdge(3, 3);

			System.out.println(DFSTraversal(2));// calling DFS traversal with root node as 2
		}
	}

}
