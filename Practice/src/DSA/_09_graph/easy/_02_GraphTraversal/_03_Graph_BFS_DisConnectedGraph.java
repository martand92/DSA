package DSA._09_graph.easy._02_GraphTraversal;

import java.util.*;

/* In Connected Graph its assumed that all vertices in adj array are connected and are reachable,
 * but if there is a vertex which is not reachable in graph then BFS for connected graph wont work as it wont consider this disconnected vertex 
 * Hence in disconnected graph, instead of starting BFS by considering a node as root node and finding its adjacent vertices. 
 * In Disconnected graph, BFS is traversed from all nodes (every nodes, adjacent vertices are considered and not just single root)
 */

public class _03_Graph_BFS_DisConnectedGraph {

	static ArrayList<Integer> result = new ArrayList<Integer>(); // to store final result of BFS traversal

	/*
	 * In BFS, Queue is used where all adjacent node values are added to queue as
	 * they are at same level in graph
	 */
	static Queue<Integer> q = new LinkedList<Integer>();
	static boolean[] visited;

	static class Graph {

		static int v;
		static LinkedList<Integer>[] adj;

		Graph(int v) {
			adj = new LinkedList[v]; // Initializing adj array as LinkedList
			visited = new boolean[v];
			for (int i = 0; i < v; i++)
				/*
				 * Initializing each adj array index with a linked list
				 * adj[linkedList,linkedList, linkedList]
				 */
				adj[i] = new LinkedList<Integer>();
		}

		// for vth vertex add w vertex as adjacent vertex
		public void addEdge(int v, int w) {
			adj[v].add(w);
		}

		// Function to traverse Graph with BFS traversal for given vertex
		public static ArrayList<Integer> BFS(int vertex) {

			q.add(vertex); // Add given vertex to Queue
			visited[vertex] = true;

			while (!q.isEmpty()) { // iterate till queue is empty, this is base condition for BFS

				vertex = q.poll();
				result.add(vertex); // Add queue top element (vertex) in final result array

				for (int i : adj[vertex]) {
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
			g.addEdge(3, 3);

			for (int i = 0; i < adj.length; i++) { // here i is vertex

				/*
				 * if given vertex is not visited during multiple BFS traversals, then there is
				 * a node thats not connected, so this node should also be passed for BFS
				 * traversal
				 */
				if (!visited[i])
					result = BFS(i);// calling BFS traversal for each vertex in a graph

			}

			System.out.println(result);
		}
	}

}
