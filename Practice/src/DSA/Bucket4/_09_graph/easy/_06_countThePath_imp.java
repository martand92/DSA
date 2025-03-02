package DSA.Bucket4._09_graph.easy;

import java.util.*;

//https://practice.geeksforgeeks.org/problems/count-the-paths4332/1

/* Here visited[] is not used because destination vertex would be visited through multiple paths.
 * So shouldn't mark this dest vertex as visited
 */
public class _06_countThePath_imp {

	static class Graph {

		static LinkedList<Integer>[] adjList;

		Graph(int v) {
			adjList = new LinkedList[v];

			for (int i = 0; i < v; i++)
				adjList[i] = new LinkedList<Integer>();
		}

		public static void addEdge(int srcVertex, int destVertex) {
			adjList[srcVertex].add(destVertex);
		}

		public static int dfs(LinkedList<Integer>[] adj, int s, int d) {

			if (s == d)
				return 1;

			int count = 0;
			for (int i : adj[s])
				count += dfs(adj, i, d);

			return count;
		}

		public static void main(String[] args) {

			new Graph(4);

			addEdge(0, 1);
			addEdge(0, 3);
			addEdge(2, 0);
			addEdge(1, 3);
			addEdge(2, 1);

			System.out.println(dfs(adjList, 2, 3));
		}
	}
}