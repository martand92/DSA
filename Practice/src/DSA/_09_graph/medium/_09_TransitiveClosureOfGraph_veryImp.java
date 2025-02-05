package DSA._09_graph.medium;

import java.util.Arrays;

//https://practice.geeksforgeeks.org/problems/transitive-closure-of-a-graph0930/1
public class _09_TransitiveClosureOfGraph_veryImp {

	int[][] graph;
	int[][] result;

	public _09_TransitiveClosureOfGraph_veryImp(int n) {
		graph = new int[n][n];
		result = new int[n][n];
	}

	public void addEdge(int u, int v) {
		graph[u][v] = 1;
	}

	// DFS on grid / matrix
	public boolean dfs(int srcVertex, int destVertex, boolean[] visited) {

		if (srcVertex == destVertex)
			return true;

		visited[srcVertex] = true;

		for (int i = 0; i < graph[srcVertex].length; i++) {

			if (graph[srcVertex][i] == 1 && !visited[i])

				if (dfs(i, destVertex, visited))
					return true;
		}

		return false;
	}

	public static void main(String[] args) {

		_09_TransitiveClosureOfGraph_veryImp g = new _09_TransitiveClosureOfGraph_veryImp(4);

		g.addEdge(0, 0);
		g.addEdge(0, 1);
		g.addEdge(0, 3);

		g.addEdge(1, 1);
		g.addEdge(1, 2);

		g.addEdge(2, 2);
		g.addEdge(2, 3);

		g.addEdge(3, 3);

		System.out.println("Initial array : " + Arrays.deepToString(g.graph));

		for (int i = 0; i < g.graph.length; i++) {
			for (int j = 0; j < g.graph[0].length; j++) {

				boolean[] visited = new boolean[g.graph[0].length];

				if (g.graph[i][j] == 0) {
					if (g.dfs(i, j, visited))
						g.result[i][j] = 1;

				} else
					g.result[i][j] = 1;
			}
		}

		System.out.println("Resultant Array : " + Arrays.deepToString(g.result));
	}
}