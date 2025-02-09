package DSA._09_graph.medium._06_DetectCycle.Undirected;

import java.util.*;

//https://www.youtube.com/watch?v=zQ3zgFypzX4
public class _12_02_DetectCycleInUndirectedGraph_DFS {

	static class Graph {

		LinkedList<Integer>[] adjList;
		int[] flag;
		Queue<Integer> q = new LinkedList<Integer>();
		// As this is undirected, you need to maintain parent array to check while
		// traversing if vertex's parent is not considered as cycle
		int[] parent;

		Graph(int v) {

			adjList = new LinkedList[v];

			for (int i = 0; i < v; i++)
				adjList[i] = new LinkedList<Integer>();

			flag = new int[v];
			Arrays.fill(flag, -1);

			parent = new int[v];
			Arrays.fill(parent, -1);

		}

		public void addEdge(int u, int v) {
			adjList[u].add(v);
			adjList[v].add(u);
		}

		public boolean detectCycle(int vertex) {

			flag[vertex] = 0;

			for (int i : adjList[vertex]) {

				if (i != parent[vertex] & flag[i] == 0)
					return true;

				if (i != parent[vertex]) {
					flag[i] = 0;
					parent[i] = vertex;
					if (detectCycle(i))
						return true;
					flag[i] = 1;
				}
			}

			return false;
		}

		public static void main(String[] args) {
			Graph g = new Graph(4);
			g.addEdge(0, 1);
			g.addEdge(1, 2);
			g.addEdge(2, 0);
			g.addEdge(2, 3);
			g.addEdge(3, 3);
			System.out.println(g.detectCycle(0));

		}
	}

}

//TC : O(V + E)
//SC : O(V)