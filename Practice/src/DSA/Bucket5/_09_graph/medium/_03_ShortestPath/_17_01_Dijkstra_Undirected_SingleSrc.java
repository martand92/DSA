package DSA.Bucket5._09_graph.medium._03_ShortestPath;

import java.util.*;

public class _17_01_Dijkstra_Undirected_SingleSrc {

	static class Graph {

		int[][] adjMatrix;
		int[] dist;
		boolean[] visited;

		Graph(int v) {

			adjMatrix = new int[v][v];
			dist = new int[v]; // total distance
			Arrays.fill(dist, Integer.MAX_VALUE);
			visited = new boolean[v];
		}

		// undirected edge addition to graph
		public void addEdge(int u, int v, int w) {
			adjMatrix[u][v] = w;
			adjMatrix[v][u] = w;
		}

		// find shortest path from given root vertex
		public int[] shortestPathFromRoot(int vertex, int count) {

			while (count < adjMatrix.length) {

				// Step 1 : Add given source vertex to visited list
				visited[vertex] = true;

				for (int i = 0; i < adjMatrix.length; i++) {

					// Step 2 : for all unvisited adjMatrix vertices from given src, update
					// distance array if its current value > derived value
					if (!visited[i] && adjMatrix[vertex][i] > 0 && ((dist[vertex] + adjMatrix[vertex][i]) < dist[i]))
						dist[i] = dist[vertex] + adjMatrix[vertex][i];
				}

				// Step 3: Once distance array of adjMatrix vertices is updated, then find next
				// unvisited vertex whose dist array value is least
				int min = Integer.MAX_VALUE;
				for (int i = 0; i < adjMatrix.length; i++) {
					if (dist[i] < min && !visited[i]) {
						min = dist[i];
						vertex = i;
					}
				}

				count++;

			} // loop till all vertices become part of visited array

			return dist;

		}

		public static void main(String[] args) {
			Graph g = new Graph(9);
			g.addEdge(0, 1, 4);
			g.addEdge(0, 4, 8);
			g.addEdge(1, 2, 8);
			g.addEdge(1, 4, 11);
			g.addEdge(2, 3, 7);
			g.addEdge(2, 6, 4);
			g.addEdge(2, 8, 2);
			g.addEdge(3, 7, 9);
			g.addEdge(3, 6, 14);
			g.addEdge(4, 5, 1);
			g.addEdge(4, 8, 7);
			g.addEdge(5, 8, 6);
			g.addEdge(5, 6, 2);
			g.addEdge(6, 7, 10);

			// selecting random src vertex from which shortest path to all other vertices
			// are calculated
			int vertex = 0;

			// make distance of src vertex as 0
			g.dist[vertex] = 0;

			// Find shortest path from given root vertex
			System.out.println("Shortest path to all other vertices from given root " + vertex + " is : "
					+ Arrays.toString(g.shortestPathFromRoot(vertex, 0)));

		}

	}

}
