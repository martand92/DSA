package DSA.Bucket5._09_graph.medium._03_ShortestPath;

import java.util.*;

public class _01_DAG_TopoSort_BFS {

	static class Graph {

		LinkedList<LinkedList<Integer>>[] adjList;// storing edges with weights in adjList

		Graph(int v) {
			adjList = new LinkedList[v];
			for (int i = 0; i < v; i++)
				adjList[i] = new LinkedList<LinkedList<Integer>>();
		}

		public static Graph createGraph(int[][] edges, int n) {
			Graph g = new Graph(n);
			for (int i = 0; i < edges.length; i++) {
				LinkedList<Integer> list = new LinkedList<Integer>();
				list.add(edges[i][1]);// Storing adj node to current node i
				list.add(edges[i][2]);// storing weight from i -> adjNode
				g.adjList[edges[i][0]].add(list);
			}

			return g;
		}

		public static int[] findShortestPath(int[][] edges, int[] dist, int n) {

			Graph g = createGraph(edges, n);
			Queue<Integer> q = new LinkedList<Integer>();

			// For topo sort find indgree of all vertices
			int[] indegree = new int[n];
			for (int i = 0; i < edges.length; i++)
				indegree[edges[i][1]]++;

			// find vertices with indegree = 0 and add to Q for topo sorting
			for (int i = 0; i < indegree.length; i++)
				if (indegree[i] == 0)
					q.add(i);

			dist[q.peek()] = 0;

			while (!q.isEmpty()) {

				int v = q.poll();

				for (LinkedList<Integer> i : g.adjList[v]) {

					if (dist[i.get(0)] > (dist[v] + i.get(1))) {
						dist[i.get(0)] = dist[v] + i.get(1);

						indegree[i.get(0)]--;

						if (indegree[i.get(0)] == 0) // Avoiding looking for next vertex with shortest dist by directly
														// considering vertex with indegree = 0
							q.add(i.get(0));
					}

				}

			}

			return dist;
		}

		public static void main(String[] args) {

			int[][] edges = { { 0, 1, 2 }, { 0, 4, 1 }, { 4, 5, 4 }, { 4, 2, 2 }, { 1, 2, 3 }, { 2, 3, 6 },
					{ 5, 3, 1 } };
			int n = 6; // number of vertices
			int[] dist = new int[6];
			Arrays.fill(dist, Integer.MAX_VALUE);

			System.out.println(Arrays.toString(findShortestPath(edges, dist, n)));

		}
	}

}
