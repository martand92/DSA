package DSA._09_graph.easy._02_GraphTraversal;

public class _05_DFS_AdjMatrix {

	public static void dfs(int[][] adjMatrix, int i, boolean[] visited) {

		visited[i] = true;
		System.out.println("Visited : " + i);

		for (int j = 0; j < adjMatrix[0].length; j++) {
			if (!visited[j] && adjMatrix[i][j] == 1)
				dfs(adjMatrix, j, visited);
		}
	}

	public static void main(String[] args) {

		// Connected graph
		// int[][] adjMatrix = { { 0, 1, 1, 0 }, { 1, 0, 1, 1 }, { 1, 1, 0, 1 }, { 0, 1,
		// 1, 0 } };

		// Disconnected graph
		int[][] adjMatrix = { { 0, 1, 0, 0 }, { 1, 0, 0, 0 }, { 0, 0, 0, 1 }, { 0, 0, 1, 0 } };

		boolean[] visited = new boolean[adjMatrix.length];

		for (int i = 0; i < adjMatrix.length; i++) {
			if (!visited[i])
				dfs(adjMatrix, i, visited);
		}
	}
}
