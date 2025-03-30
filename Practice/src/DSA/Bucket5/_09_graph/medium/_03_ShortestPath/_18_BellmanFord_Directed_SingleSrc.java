package DSA.Bucket5._09_graph.medium._03_ShortestPath;

import java.util.*;

public class _18_BellmanFord_Directed_SingleSrc {

	static class Graph {
		int[] dist;
		int v;

		Graph(int v) {
			this.v = v;
			dist = new int[v];
			Arrays.fill(dist, (int) 1e8);// instead of 1e9 to avoid overflow
		}

		public int[] findShortestPath(int[][] edges, int src) {

			dist[src] = 0;

			for (int itr = 0; itr < v - 1; itr++) {

				for (int[] e : edges) {
					int u = e[0], v = e[1], w = e[2];
					if (dist[u] != 1e8 && dist[v] > dist[u] + w)
						dist[v] = dist[u] + w;
				}
			}

			// check if shortest path distance can be further updated even after completing
			// v-1 iterations, then this graph has negative cycle
			for (int[] e : edges) {
				int u = e[0], v = e[1], w = e[2];
				if (dist[u] != 1e8 && dist[v] > dist[u] + w) {
					System.out.println("has negative cycle");
					break;
				}
			}

			return dist;
		}

		public static void main(String[] args) {
			Graph g = new Graph(5);
			// Bellman ford works on edges
			int[][] edges = new int[][] { { 1, 3, 2 }, { 4, 3, -1 }, { 2, 4, 1 }, { 1, 2, 1 }, { 0, 1, 5 } };
			int src = 0;

			System.out.println("Shortes path to all other vertices vertex 0 is : "
					+ Arrays.toString(g.findShortestPath(edges, src)));
		}
	}
}
