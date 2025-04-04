package DSA.Bucket5._09_graph.medium._06_Eulerian;

import java.util.*;

//https://www.geeksforgeeks.org/eulerian-path-and-circuit/

//Graph is said to be eulerian if it has eulerian cycle (and not just eulerian path)

/*Condition for undirected graph to be Eulerian:
 * 1. All vertices with non-zero degree belongs to single strongly connected component 
 * 2. If odd degree vertices count = 2, then only Eulerian path (semi-Eulerian)
 * 3. If odd degree vertices count = 0, i.e, all vertices are of even degree then graph is Eulerian Cycle
 * 4. Else not an Eulerian
 */

public class _10_Eulerian_Undirected {

	static class Graph {

		static LinkedList<Integer> adjList[];
		static boolean[] visited;
		static int[] degree;

		Graph(int v) {

			adjList = new LinkedList[v];

			for (int i = 0; i < v; i++)
				adjList[i] = new LinkedList<Integer>();

			degree = new int[v];
			visited = new boolean[v];
		}

		// un-directed graph
		public static void addEdge(int u, int v) {
			adjList[u].add(v);
			adjList[v].add(u);
		}

		public static void dfs(int vertex) {
			visited[vertex] = true;
			for (int i : adjList[vertex]) {
				if (!visited[i])
					dfs(i);
			}
		}

		// 1. All vertices with non-zero degree are connected
		public static boolean isConnected() {

			// find degree of all vertices
			for (int i = 0; i < adjList.length; i++)
				degree[i] = adjList[i].size(); // just consider out going edges

			// find first non-zero degree vertex
			// and do DFS to check if all non-zero degree vertices are connected
			int firstNonZeroDegreeVertex = 0;

			for (int i = 0; i < degree.length; i++) {
				if (degree[i] > 0) {
					firstNonZeroDegreeVertex = i;
					break;
				}
			}

			// Now do DFS from first non-zero degree vertex and check for vertices that are
			// connected
			dfs(firstNonZeroDegreeVertex);

			// Checking if all non-zero degree vertices are connected
			for (int i = 0; i < degree.length; i++)
				if (degree[i] > 0 && !visited[i])
					return false;

			return true;
		}

		// The function returns one of the following values
		// 0 --> If graph is not Eulerian
		// 1 --> If graph has an Euler path (Semi-Eulerian)
		// 2 --> If graph has an Euler Circuit (Eulerian)
		public static int isEulerian() {

			// Check if all non-zero degree vertices are connected
			if (!isConnected())
				return 0;

			// Count vertices with odd degree
			int odd = 0;

			for (int i = 0; i < degree.length; i++)
				if (degree[i] % 2 != 0)
					odd++;

			// If odd count > 2, then graph is not Eulerian(return 2)
			// If odd count = 2 , then semi - eulerian (return 1)
			// If odd count = 0, then eulerian (return 0)
			// Note : odd count can never be 1 for undirected graph
			if (odd > 2)
				return 2; // not eulerian

			else if (odd == 2)
				return 1; // eulerian path / semi-eulerian

			else
				return 0; // eulerian
		}

		public static void main(String[] args) {

			new Graph(5);

			addEdge(1, 0);
			addEdge(0, 2);
			addEdge(2, 1);
			addEdge(0, 3);
			addEdge(3, 4);

			System.out.println(isEulerian());

		}
	}
}