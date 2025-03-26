package DSA.Bucket5._09_graph.medium;

import java.util.*;

//https://leetcode.com/problems/rotting-oranges/
public class _06_RottenOranges {

	static class Content {
		int u;
		int v;
		int time;

		Content(int u, int v, int time) {
			this.u = u;
			this.v = v;
			this.time = time;
		}
	}

	public static int findMinTime(int[][] grid) {

		// Declare Q that holds src, dest vertices with unit time
		Queue<Content> q = new LinkedList<Content>(); // O(N * M)
		int minTime = 0;

		// initially add all the rotten oranges to queue with unit time as 0
		for (int i = 0; i < grid.length; i++) { // O(N * M)
			for (int j = 0; j < grid.length; j++) {
				if (grid[i][j] == 2)
					q.add(new Content(i, j, 0));
			}
		}

		while (!q.isEmpty()) { // O(N * M)

			Content vertex = q.poll();

			// if in all 4 directions fresh oranges are seen, then O(4)
			int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

			for (int i = 0; i < directions.length; i++) {

				int newRow = vertex.u + directions[i][0];
				int newCol = vertex.v + directions[i][1];

				if (newRow < grid.length && newCol < grid.length && newRow >= 0 && newCol >= 0
						&& grid[newRow][newCol] == 1) {
					q.add(new Content(newRow, newCol, vertex.time + 1));
					grid[newRow][newCol] = 2;
					minTime = Math.max(vertex.time + 1, minTime);
				}
			}
		}

		// check if all oranges are rotten
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1)
					return -1;
			}
		}

		return minTime;
	}

	public static void main(String[] args) {

		int[][] grid = { { 0, 1, 2 }, { 0, 1, 2 }, { 2, 1, 1 } };
		// int[][] grid = { { 2, 2, 0, 1 } };

		System.out.println(findMinTime(grid));
	}
}
//SC : O(N*M) // for q
//TC : O(N*M) + O(4) = O(N*M)