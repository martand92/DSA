package DSA._09_graph.easy._02_GraphTraversal;

import java.util.*;

//Applicable for both Directed and Undirected graphs
public class _03_Graph_BFS_ConnectedGraph {

	static ArrayList<Integer> result = new ArrayList<Integer>(); // to store final result of BFS traversal //O(V)

	/*
	 * In BFS, Queue is used where all adjacent node values are added to queue as
	 * they are at same level in graph
	 */
	static Queue<Integer> q = new LinkedList<Integer>(); // TC : O(V), SC : O(V)

	static boolean[] visited; // O(V)

	static class Graph {

		static int v;
		static LinkedList<Integer>[] adj; // SC : O(V)

		Graph(int v) {
			adj = new LinkedList[v]; // Initializing adj array as LinkedList
			visited = new boolean[v];
			for (int i = 0; i < v; i++) // O(V)
				/*
				 * Initializing each adj array index with a linked list adj[linkedList,
				 * linkedList, linkedList]
				 */
				adj[i] = new LinkedList<Integer>();
		}

		// for vth vertex add w vertex as adjacent vertex
		public void addEdge(int v, int w) {
			adj[v].add(w);
		}

		// Function to traverse Graph with BFS traversal
		public static List<Integer> BFS(int vertex) {

			q.add(vertex); // Add given root to Queue
			visited[vertex] = true; // make given root vertex as visited

			while (!q.isEmpty()) { // iterate till queue is empty, this is base condition for BFS. O(V)

				vertex = q.poll();
				result.add(vertex); // Add queue top element (vertex) in final result array

				for (int i : adj[vertex]) { // O(E)
					if (!visited[i]) {
						q.add(i);
						visited[i] = true;
					}
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
			g.addEdge(2, 3);
			g.addEdge(3, 3);

			System.out.println(BFS(2));// calling BFS traversal with root node as 2
		}
	}

}

//TC : O(V + E)
// SC : O(V)
