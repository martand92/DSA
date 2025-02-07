package DSA._09_graph.easy._02_GraphTraversal;

import java.util.*;

public class _05_BFS_AdjMatrix {

	public static void bfs(int[][] adjMatrix, int i, boolean[] visited) {

		Queue<Integer> q = new LinkedList<Integer>();
		q.add(i);
		visited[i] = true;

		while (!q.isEmpty()) {

			int vertex = q.poll();
			System.out.println("Visited : " + vertex);

			for (int j = 0; j < adjMatrix.length; j++) {
				if (!visited[j] && adjMatrix[vertex][j] == 1) {
					q.add(j);
					visited[j] = true;
				}
			}
		}
	}

	public static void main(String[] args) {

		// Connected graph
		// int[][] adjMatrix = { { 0, 1, 1, 0 }, { 1, 0, 1, 1 }, { 1, 1, 0, 1 }, { 0, 1,
		// 1, 0 } };

		// Disconnected graph
		// int[][] adjMatrix = { { 0, 1, 0, 0 }, { 1, 0, 0, 0 }, { 0, 0, 0, 1 }, { 0, 0,
		// 1, 0 } };
		int[][] adjMatrix = { { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 } };

		boolean[] visited = new boolean[adjMatrix.length];

		for (int i = 0; i < adjMatrix.length; i++) {
			if (!visited[i])
				bfs(adjMatrix, i, visited);
		}
	}
}