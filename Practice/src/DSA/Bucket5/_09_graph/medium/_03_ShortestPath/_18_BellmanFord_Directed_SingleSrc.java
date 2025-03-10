package DSA.Bucket5._09_graph.medium._03_ShortestPath;

import java.util.*;

public class _18_BellmanFord_Directed_SingleSrc {

	static class Graph {
		int[][] adj;
		int[] dist;// contains final shortest distance of all vertices from given single source
					// vertex
		int itr = 0;

		Graph(int v) {
			adj = new int[v][v];
			dist = new int[v];
			Arrays.fill(dist, Integer.MAX_VALUE);
		}

		// directed edge addition to graph
		public void addEdge(int u, int v, int w) {
			adj[u][v] = w;
		}

		public int[] findShortestPath() {

			boolean isChanged = false;
			// loop through all vertices starting from vertex 0 and update distance
			// from this src vertex and repeat for n-1 times

			for (int itr = 0; itr < adj.length - 1; itr++) {

				isChanged = false;

				for (int i = 0; i < adj.length; i++) {
					for (int j = 0; j < adj.length; j++) {
						if (adj[i][j] != 0 && dist[j] > dist[i] + adj[i][j]) {
							dist[j] = dist[i] + adj[i][j];
							isChanged = true;
						}
					}
				}

				// if dist[] doesn't update before completion of n-1 iterations, then no need
				// to further iterate
				if (!isChanged)
					return dist;
			}

			// check if shortest path distance can be further updated even after completing
			// v-1 iterations, then this graph has negative cycle
			for (int i = 0; i < adj.length; i++) {
				for (int j = 0; j < adj.length; j++) {
					if (adj[i][j] != 0 && dist[j] > dist[i] + adj[i][j]) {
						System.out.println("has negative cycle");
						break;
					}
				}
			}

			return dist;

		}

		public static void main(String[] args) {
			Graph g = new Graph(6);
			g.addEdge(0, 1, 6);
			g.addEdge(0, 2, 4);
			g.addEdge(0, 3, 5);
			g.addEdge(1, 4, -1);
			g.addEdge(2, 1, -2);
			g.addEdge(2, 4, 3);
			g.addEdge(3, 2, -2);
			g.addEdge(3, 5, -1);
			g.addEdge(4, 5, 3);

			// root is 0, Hence make dist array of vertex 0 as 0
			g.dist[0] = 0;

			// Calculate shortest distance from given root : 0
			System.out.println(
					"Shortes path to all other vertices vertex 0 is : " + Arrays.toString(g.findShortestPath()));

		}

	}

}
