package DSA._09_graph.medium._02_TopologicalSort_DAG;

import java.util.*;

// topological sorting is applicable only for Directed Acyclic graph
public class _02_KahnAlgo_WithQ {

	static class Graph {

		LinkedList<Integer>[] adjList;
		static int[] indegree;
		ArrayList<Integer> topoSort;

		Graph(int v) {
			adjList = new LinkedList[v];
			indegree = new int[v];
			topoSort = new ArrayList<Integer>();

			for (int i = 0; i < v; i++)
				adjList[i] = new LinkedList<Integer>(); // O(V+E)
		}

		public void addEdge(int u, int v) {
			adjList[u].add(v);
		}

		// Initially Find indegree of each vertex in graph
		public void findIndegreeOfVertices() {
			for (int i = 0; i < adjList.length; i++) {
				for (int j : adjList[i])
					indegree[j]++;
			}
		}

		public ArrayList<Integer> topoSort() {

			Queue<Integer> q = new LinkedList<Integer>();

			// find vertices with zero degree and to Q
			for (int i = 0; i < indegree.length; i++)
				if (indegree[i] == 0)
					q.add(i);

			while (!q.isEmpty()) {

				int v = q.poll();
				
				// dequeue to result
				topoSort.add(v);

				// loop through all adj vertices & -1 in-degree
				for (int i : adjList[v]) {
					indegree[i] --;

					// if their indegree = 0 then add to Q
					if (indegree[i] == 0)
						q.add(i);
				}
			}

			return topoSort;
		}

		public static void main(String[] args) {

			Graph g = new Graph(5);
			g.addEdge(0, 1);
			g.addEdge(0, 3);
			g.addEdge(1, 2);
			g.addEdge(1, 3);
			g.addEdge(3, 2);
			g.addEdge(3, 4);

			// Step 1: to find indegree of each vertices
			g.findIndegreeOfVertices(); // O(V + E)

			// Step 2: start finding topologically Sorted Array
			System.out.println("Topological sorting of vertices for given graph is : " + g.topoSort());
		}
	}

}
