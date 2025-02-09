package DSA._09_graph.medium._02_TopologicalSort_DAG;

import java.util.*;

// topological sorting is applicable only for Directed Acyclic graph
public class _02_KahnAlgo_WithoutQ {

	static class Graph {

		int v;
		LinkedList<Integer>[] adj;
		int[] indegreeOfVertices;
		ArrayList<Integer> topologicalSort;

		Graph(int v) {
			this.v = v;
			adj = new LinkedList[v];
			indegreeOfVertices = new int[v];

			topologicalSort = new ArrayList<Integer>();

			for (int i = 0; i < v; i++)
				adj[i] = new LinkedList<Integer>(); // O(V+E)
		}

		public void addEdge(int u, int v) {
			adj[u].add(v);
		}

		// Initially Find indegree of each vertex in graph
		public void findIndegreeOfVertices() {
			for (int i = 0; i < v; i++) {

				// for each vertex increase indegree of neighboring vertices
				for (int j : adj[i])
					indegreeOfVertices[j] += 1;

			}
		}

		// get next vertex with indegree=0 & not already in result
		public int getVertexWithInDegreeAsZero() {
			for (int i = 0; i < indegreeOfVertices.length; i++) {
				if (indegreeOfVertices[i] == 0 && !topologicalSort.contains(i))
					return i;
			}
			return -1;
		}

		public ArrayList<Integer> topologicalSort() {

			while (topologicalSort.size() != v) {

				int vertex = getVertexWithInDegreeAsZero(); // TC : O(V), SC : O(V)

				topologicalSort.add(vertex); // SC : O(V) 

				for (int i : adj[vertex]) // TC : O(E)
					indegreeOfVertices[i] -= 1;

			}

			return topologicalSort;
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
			g.findIndegreeOfVertices();

			// Step 2: start finding topologically Sorted Array
			System.out.println("Topological sorting of vertices for given graph is : " + g.topologicalSort());
		}
	}

}
