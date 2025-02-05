package DSA._09_graph.medium;

import java.util.*;

//https://leetcode.com/problems/number-of-islands/description/
public class _05_01_NoOfIslands {

	static class Vertex {
		int i;
		int j;

		Vertex(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

	static class Graph {

		public static void connectedIslands(int[][] grid, boolean[][] visited, Queue<Vertex> q, int i, int j) {
			// add current indicated land to q & mark it as visited
			q.add(new Vertex(i, j));
			visited[i][j] = true;

			while (!q.isEmpty()) {

				// take current land from Q and check for all neighbors
				Vertex currentVertex = q.poll();

				// Visit all land neighbors in all 8 directions, mark as visited & add to queue
				for (int deltaRow = -1; deltaRow <= 1; deltaRow++) {

					for (int deltaCol = -1; deltaCol <= 1; deltaCol++) {

						int newRow = currentVertex.i + deltaRow;
						int newCol = currentVertex.j + deltaCol;

						if (newRow < grid.length && newRow >= 0 && newCol < grid[0].length && newCol >= 0
								&& grid[newRow][newCol] == 1 && !visited[newRow][newCol]) {
							
							visited[newRow][newCol] = true;
							q.add(new Vertex(newRow, newCol));

						}
					}
				}

			}

		}

	}

	public static void main(String[] args) {

		// in grid 1 rep land and 0 rep water
		// int[][] grid = { { 0, 1, 1, 0 }, { 0, 1, 1, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 0
		// }, { 1, 1, 0, 1 } };
		int[][] grid = { { 0, 1, 0, 0 }, { 0, 0, 1, 0 }, { 0, 0, 1, 1 }, { 0, 0, 0, 0 }, { 1, 1, 0, 1 } };

		boolean[][] visited = new boolean[grid.length][grid[0].length];
		int noOfComponents = 0; // no of disconnected lands

		Queue<Vertex> q = new LinkedList<Vertex>();

		for (int i = 0; i < grid.length; i++) {

			for (int j = 0; j < grid[0].length; j++) {

				// consider lands in grid that are not visited to do dfs & no of dfs you do will
				// be no of islands
				if (!visited[i][j] && grid[i][j] == 1) {
					noOfComponents++;
					Graph.connectedIslands(grid, visited, q, i, j);
				}

			}

		}

		System.out.println(noOfComponents);
	}

}
