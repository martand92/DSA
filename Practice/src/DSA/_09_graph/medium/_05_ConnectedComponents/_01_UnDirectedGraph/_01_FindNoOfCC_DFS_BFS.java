package DSA._09_graph.medium._05_ConnectedComponents._01_UnDirectedGraph;

/*Intuition : if dfs /bfs starting from a node traverses through all connected nodes 
 *then number of these iterations will be no of components
 */
import java.util.*;

//Same can be implemented using BFS
public class _01_FindNoOfCC_DFS_BFS {

	static class Graph {

		static LinkedList<Integer>[] adjList;
		static boolean[] visited;
		static int v;

		Graph(int v) {
			adjList = new LinkedList[v];
			visited = new boolean[v];
			this.v = v;
			for (int i = 0; i < v; i++)
				adjList[i] = new LinkedList<Integer>();
		}

		public static void addEdge(int u, int v) {
			adjList[u].add(v);
			adjList[v].add(u);
		}

		public static void dfs(int i) {
			visited[i] = true;
			for (int v : adjList[i]) {
				if (!visited[v]) {
					dfs(v);
				}
			}
		}

		public static int findNoOfCC() {
			int count = 0;
			for (int i = 0; i < v; i++) {
				if (!visited[i]) {
					count++;
					dfs(i);
				}
			}

			return count;
		}

		public static void main(String[] args) {

			new Graph(5);
			addEdge(0, 1);
			addEdge(1, 2);
			addEdge(2, 3);
			addEdge(3, 0);
			// addEdge(2, 4);
			System.out.println(findNoOfCC());
		}
	}
}