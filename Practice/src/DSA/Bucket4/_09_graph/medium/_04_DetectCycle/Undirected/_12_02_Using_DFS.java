package DSA.Bucket4._09_graph.medium._04_DetectCycle.Undirected;

import java.util.*;

//https://www.youtube.com/watch?v=zQ3zgFypzX4
public class _12_02_Using_DFS {

	static class Graph {

		LinkedList<Integer>[] adjList;
		boolean[] visited;
		int[] parent;

		Graph(int v) {

			adjList = new LinkedList[v];

			for (int i = 0; i < v; i++)
				adjList[i] = new LinkedList<Integer>();

			visited = new boolean[v];
			parent = new int[v];
			Arrays.fill(parent, -1);
		}

		public void addEdge(int u, int v) {
			adjList[u].add(v);
			adjList[v].add(u);
		}

		public boolean detectCycle(int vertex) {

			visited[vertex] = true;

			for (int i : adjList[vertex]) {

				// Cycle detection
				if (visited[i] && parent[vertex] != i)
					return true;

				else if (!visited[i]) {
					parent[i] = vertex;
					if (detectCycle(i))
						return true;
				}
			}

			return false;
		}

		// Handles multiple components in a graph
		public boolean hasCycle() {

			for (int i = 0; i < adjList.length; i++) {

				if (!visited[i]) {
					parent[i] = i;

					if (detectCycle(i))
						return true;
				}
			}

			return false;
		}

		public static void main(String[] args) {

			Graph g = new Graph(4);

			g.addEdge(0, 1);
			g.addEdge(1, 2); // Add this to form cycle in this graph
			g.addEdge(2, 0);
			g.addEdge(2, 3);
			System.out.println(g.hasCycle());

		}
	}

}

//TC : O(V + E)
//SC : O(V)