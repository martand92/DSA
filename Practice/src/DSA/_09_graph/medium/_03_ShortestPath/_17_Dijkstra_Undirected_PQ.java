package DSA._09_graph.medium._03_ShortestPath;

import java.util.*;

public class _17_Dijkstra_Undirected_PQ {

	static class Distance {
		int vertex;
		int distance;

		Distance(int vertex, int distance) {
			this.vertex = vertex;
			this.distance = distance;
		}
	}

	static class Graph {
		int[][] adjMatrix;
		int[] dist;
		PriorityQueue<Distance> pq;

		Graph(int v) {

			adjMatrix = new int[v][v];
			dist = new int[v];
			Arrays.fill(dist, Integer.MAX_VALUE);

			pq = new PriorityQueue<Distance>(new Comparator<Distance>() {
				public int compare(Distance a, Distance b) {
					return a.distance - b.distance;
				}
			});
		}

		// undirected edge addition to graph
		public void addEdge(int u, int v, int w) {
			adjMatrix[u][v] = w;
			adjMatrix[v][u] = w;
		}

		// find shortest path from given root vertex
		public int[] shortestPathFromRoot(int vertex, int count) {

			dist[vertex] = 0;

			// First add starting vertex to pq with its distance
			pq.add(new Distance(vertex, dist[vertex]));

			while (!pq.isEmpty()) { // O(V)

				vertex = pq.poll().vertex; // O(log(heapSize)) cz PQ(minHeap) takes log(heapSize) to get next priority
											// element from queue

				for (int i = 0; i < adjMatrix.length; i++) { // O(V-1) cz this loop runs for all other adj vertices in
																// matrix

					// for all unvisited vertices for given src, update dist arr if it's
					// current val > derived val And add dist and vertex info to the priority queue
					if (adjMatrix[vertex][i] > 0 && ((dist[vertex] + adjMatrix[vertex][i]) < dist[i])) {
						dist[i] = dist[vertex] + adjMatrix[vertex][i];
						pq.add(new Distance(i, dist[i])); // O(log(heapSize))
					}
				}
			}

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

			// Find shortest path from given root vertex
			System.out.println("Shortes path to all other vertices from given root " + vertex + " is : "
					+ Arrays.toString(g.shortestPathFromRoot(vertex, 0)));

		}

	}

}

//TC : O(V) * O(log(heapSize)) + O(V-1) * O(log(heapSize)) -> O(log(heapSize))(O(V) + O(V-1))
//heapSize -> V^2 as each vertex added to pq and being connected to all other vertices make them adjacent

//Hence TC : O(log(V^2))(O(V)) -> O(2log(V) * V) -> O(2V * log(v)) -> O(Elog(V))
