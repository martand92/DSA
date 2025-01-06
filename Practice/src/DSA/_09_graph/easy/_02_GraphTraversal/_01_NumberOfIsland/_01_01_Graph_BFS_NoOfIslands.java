package DSA._09_graph.easy._02_GraphTraversal._01_NumberOfIsland;

import java.util.*;

public class _01_01_Graph_BFS_NoOfIslands {

	static class Vertex {
		int i;
		int j;

		Vertex(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

	static class Graph {

		public static void connectedIslands(int[][] adjMatrix, boolean[][] visited, Queue<Vertex> q, int i, int j) {
			// add current indicated land to q & mark it as visited
			q.add(new Vertex(i, j));
			visited[i][j] = true;

			while (!q.isEmpty()) {

				// take current land from Q and check for all neighbors
				Vertex currentVertex = q.poll();

				// Visit all land neighbors in all 8 directions, mark as visited & add to queue
				for (int deltaRow = 0; deltaRow <= 1; deltaRow++) {

					for (int deltaCol = 0; deltaCol <= 1; deltaCol++) {

						int newRow = currentVertex.i + deltaRow;
						int newCol = currentVertex.j + deltaCol;

						if (newRow < adjMatrix.length && newRow >= 0 && newCol < adjMatrix[0].length && newCol >= 0
								&& adjMatrix[newRow][newCol] == 1 && !visited[newRow][newCol]) {
							visited[newRow][newCol] = true;
							q.add(new Vertex(newRow, newCol));

						}
					}
				}

			}

		}

	}

	public static void main(String[] args) {
		// in adjMatrix 1 rep land and 0 rep water
		int[][] adjMatrix = { { 0, 1, 1, 0 }, { 0, 1, 1, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 0 }, { 1, 1, 0, 1 } };
		boolean[][] visited = new boolean[adjMatrix.length][adjMatrix[0].length];
		int noOfComponents = 0; // no of disconnected lands
		Queue<Vertex> q = new LinkedList<Vertex>();

		for (int i = 0; i < adjMatrix.length; i++) {

			for (int j = 0; j < adjMatrix[0].length; j++) {
				// consider lands in grid that are not visited to do dfs & no of dfs you do will
				// be no of islands
				if (!visited[i][j] && adjMatrix[i][j] == 1) {
					noOfComponents++;
					Graph.connectedIslands(adjMatrix, visited, q, i, j);
				}

			}

		}

		System.out.println(noOfComponents);
	}

}
