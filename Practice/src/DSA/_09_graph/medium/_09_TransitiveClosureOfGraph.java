package DSA._09_graph.medium;

import java.util.Arrays;

//https://practice.geeksforgeeks.org/problems/transitive-closure-of-a-graph0930/1
public class _09_TransitiveClosureOfGraph {

	// DFS on adjmatrix
	public static boolean dfs(int[][] graph, int srcVertex, int destVertex, boolean[] visited) {

		if (srcVertex == destVertex)
			return true;

		visited[srcVertex] = true;

		for (int i = 0; i < graph[srcVertex].length; i++) {
			if (graph[srcVertex][i] == 1 && !visited[i])
				if (dfs(graph, i, destVertex, visited))
					return true;
		}

		return false;
	}

	public static void main(String[] args) {

		int[][] graph = { { 1, 1, 0, 1 }, { 0, 1, 1, 0 }, { 0, 0, 1, 1 }, { 0, 0, 0, 1 } };
		int[][] result = new int[graph.length][graph[0].length];

		System.out.println("Initial array : " + Arrays.deepToString(graph));

		for (int i = 0; i < graph.length; i++) {

			for (int j = 0; j < graph[0].length; j++) {

				if (graph[i][j] == 0) {
					if (dfs(graph, i, j, new boolean[graph[0].length]))
						result[i][j] = 1;

				} else
					result[i][j] = 1;
			}
		}

		System.out.println("Resultant Array : " + Arrays.deepToString(result));
	}
}