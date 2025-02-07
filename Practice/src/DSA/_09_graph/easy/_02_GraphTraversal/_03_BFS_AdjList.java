package DSA._09_graph.easy._02_GraphTraversal;

import java.util.*;

public class _03_BFS_AdjList {

	static ArrayList<Integer> result = new ArrayList<Integer>();
	static Queue<Integer> q = new LinkedList<Integer>();
	static boolean[] visited;

	static class Graph {

		static int v;
		static LinkedList<Integer>[] adj;

		Graph(int v) {

			adj = new LinkedList[v];
			visited = new boolean[v];

			for (int i = 0; i < v; i++)
				adj[i] = new LinkedList<Integer>();
		}

		public void addEdge(int v, int w) {
			adj[v].add(w);
		}

		public static ArrayList<Integer> BFS(int vertex) {

			q.add(vertex);
			visited[vertex] = true;

			while (!q.isEmpty()) {

				vertex = q.poll();
				result.add(vertex);

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

			// If graph is disconnected
			for (int i = 0; i < adj.length; i++) {
				if (!visited[i])
					result = BFS(i);// calling BFS traversal for each vertex in a graph thats not visited

			}

			System.out.println(result);
		}
	}

}
