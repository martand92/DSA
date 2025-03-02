package DSA.Bucket4._09_graph.medium._04_DetectCycle.Undirected;

import java.util.*;

//https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1
//Algo : a cycle occurs when we encounter a vertex that has already been visited but is NOT the parent of the current node 
public class _12_01_Using_BFS {

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

			Queue<Integer> q = new LinkedList<Integer>();
			q.add(vertex);
			visited[vertex] = true;
			parent[vertex] = vertex;

			while (!q.isEmpty()) {

				int v = q.poll();

				for (int i : adjList[v]) {
					// if vertex is re-visited now with other parent vertex than prev visit, meaning
					// this vertex is visited twice from different source. Hence forms cycle
					if (visited[i] && parent[v] != i)
						return true;

					else if (!visited[i]) {
						q.add(i);
						visited[i] = true;
						parent[i] = v;
					}
				}
			}

			return false;
		}

		// Handles multiple components in a graph
		public boolean hasCycle() {
			for (int i = 0; i < adjList.length; i++) {
				if (!visited[i]) {
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
			System.out.println(g.detectCycle(0));

		}
	}
}

//TC : O(V + E)
//SC : O(V)