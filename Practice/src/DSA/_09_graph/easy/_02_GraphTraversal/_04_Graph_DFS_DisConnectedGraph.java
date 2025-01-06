package DSA._09_graph.easy._02_GraphTraversal;

import java.util.ArrayList;
import java.util.LinkedList;

public class _04_Graph_DFS_DisConnectedGraph {

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
				adj[i] = new LinkedList(); // Initializing each adj array index with a linked list adj[linkedList,
											// linkedList, linkedList]
		}

		// for vth vertex add w vertex as adjacent vertex
		public void addEdge(int v, int w) {
			adj[v].add(w);
		}

		// Function to traverse Graph with DFS traversal
		public static ArrayList<Integer> DFSTraversal(int root) {

			if (!visited[root]) {// First Check if given root is visited
				result.add(root); // If not visited add to result and make it as visited
				visited[root] = true;

				for (int i : adj[root]) {// Then check for its adjacent list and pick any 1 vertex which is not visited
					if (!visited[i])
						DFSTraversal(i);// not visited adj vertex will then follow same path
				}
			}

			return result;

		}

		public static void main(String[] args) {
			Graph g = new Graph(4);
			g.addEdge(0, 1);
			g.addEdge(0, 2);
			g.addEdge(1, 2);
			g.addEdge(2, 0);
			//g.addEdge(2, 3);
			g.addEdge(3, 3);

			for (int i = 0; i < v; i++) {
				if (!visited[i])
					DFSTraversal(i);// calling DFS traversal for all vertices as some vertices might not be
									// reachable
			}
		}
	}

}
