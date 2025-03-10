package DSA.Bucket5._09_graph.easy._02_GraphTraversal;

import java.util.ArrayList;
import java.util.LinkedList;

public class _04_DFS_AdjList {

	static ArrayList<Integer> result = new ArrayList<Integer>();
	static boolean[] visited;

	static class Graph {

		static int v;
		static LinkedList<Integer>[] adj;

		Graph(int v) {
			Graph.v = v;
			adj = new LinkedList[v];
			visited = new boolean[v];

			for (int i = 0; i < v; i++)
				adj[i] = new LinkedList();
		}

		public void addEdge(int v, int w) {
			adj[v].add(w);
		}

		public static ArrayList<Integer> DFSTraversal(int root) {

			result.add(root);
			visited[root] = true;

			for (int i : adj[root]) {
				if (!visited[i])
					DFSTraversal(i);
			}

			return result;
		}

		public static void main(String[] args) {

			Graph g = new Graph(4);

			g.addEdge(0, 1);
			g.addEdge(0, 2);
			g.addEdge(1, 2);
			g.addEdge(2, 0);
			// g.addEdge(2, 3);
			g.addEdge(3, 3);

			// If graph is disconnected
			for (int i = 0; i < v; i++) {
				if (!visited[i])
					DFSTraversal(i);
			}
		}
	}

}
