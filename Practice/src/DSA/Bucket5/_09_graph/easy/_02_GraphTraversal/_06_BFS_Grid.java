package DSA.Bucket5._09_graph.easy._02_GraphTraversal;

import java.util.*;

public class _06_BFS_Grid {

	static class Vertex {
		int i;
		int j;

		Vertex(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

	public static void bfs(int[][] grid, boolean[][] visited, int i, int j) {

		Queue<Vertex> q = new LinkedList<Vertex>();
		visited[i][j] = true;

		q.add(new Vertex(i, j));

		while (!q.isEmpty()) {

			Vertex v = q.poll();

			System.out.println("Visiting : (" + v.i + ", " + v.j + ")");

			// check in all 4 directions
			int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

			for (int k = 0; k < directions.length; k++) {

				int newrow = v.i + directions[k][0];
				int newcol = v.j + directions[k][1];

				if (newrow >= 0 && newrow < grid.length && newcol >= 0 && newcol < grid[0].length
						&& grid[newrow][newcol] == 1 && !visited[newrow][newcol]) {

					q.add(new Vertex(newrow, newcol));
					visited[newrow][newcol] = true;

				}
			}
		}

	}

	public static void main(String[] args) {

		int[][] grid = { { 1, 1, 0, 0 }, { 0, 1, 0, 1 }, { 1, 0, 1, 1 }, { 0, 0, 1, 1 } };
		boolean[][] visited = new boolean[grid.length][grid[0].length];

		// Unlike adjMatrix where entire row is considered for traversal, here a grid is
		// considered
		// If a grid is traversed, then look for connected grids around this in all 4
		// directions
		for (int i = 0; i < grid.length; i++) {

			for (int j = 0; j < grid[0].length; j++) {

				if (grid[i][j] == 1 && !visited[i][j]) {
					System.out.println("Starting BFS from : (" + i + "," + j + ")");
					bfs(grid, visited, i, j);
				}

			}
		}
	}

}
