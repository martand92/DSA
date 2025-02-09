package DSA._09_graph.medium._06_DetectCycle.Undirected;

import java.util.*;

//https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1
public class _12_01_DetectCycleInUndirectedGraph_BFS {

	static class Graph {

		LinkedList<Integer>[] adjList;
		int[] flag;
		Queue<Integer> q = new LinkedList<Integer>();

		Graph(int v) {

			adjList = new LinkedList[v];

			for (int i = 0; i < v; i++)
				adjList[i] = new LinkedList<Integer>();

			flag = new int[v];
			Arrays.fill(flag, -1);
		}

		public void addEdge(int u, int v) {
			adjList[u].add(v);
			adjList[v].add(u);
		}

		public boolean detectCycle(int vertex) {

			q.add(vertex);
			flag[vertex] = 0;

			while (!q.isEmpty()) {

				int v = q.poll();
				flag[v] = 1;

				for (int i : adjList[v]) {

					if (flag[i] == 0)
						return true;

					else if (flag[i] == -1) {
						q.add(i);
						flag[i] = 0;
					}

				}
			}

			return false;
		}

		public static void main(String[] args) {
			Graph g = new Graph(3);
			g.addEdge(0, 1);
			g.addEdge(1, 2);
			// g.addEdge(2, 0);
			// g.addEdge(2, 3);
			// g.addEdge(3, 3);
			System.out.println(g.detectCycle(0));

		}
	}

}

//TC : O(V + E)
//SC : O(V)