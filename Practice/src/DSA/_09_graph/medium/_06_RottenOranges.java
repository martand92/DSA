package DSA._09_graph.medium;

import java.util.*;

public class _06_RottenOranges {

	static class Content {
		int u;
		int v;
		int unitTime;

		Content(int u, int v, int unitTime) {
			this.u = u;
			this.v = v;
			this.unitTime = unitTime;
		}
	}

	public static int findMinTime(int[][] grid) {

		// Declare Q that holds src, dest vertices with unit time
		Queue<Content> q = new LinkedList<Content>(); // O(N * M)
		int minTime = 0;

		// add all the rotten oranges to queue
		for (int i = 0; i < grid.length; i++) { // O(N * M)
			for (int j = 0; j < grid.length; j++) {
				if (grid[i][j] == 2)
					q.add(new Content(i, j, 0));
			}
		}

		while (!q.isEmpty()) { // O(N * M)

			Content i = q.poll();

			// if in all 4 directions fresh oranges are seen, then O(4)
			int[] deltaRow = { -1, 1, 0, 0 };
			int[] deltaCol = { 0, 0, -1, 1 };

			for (int k = 0; k < 4; k++) {
				int newRow = i.u + deltaRow[k];
				int newCol = i.v + deltaCol[k];

				if (newRow < grid.length && newCol < grid.length && newRow >= 0 && newCol >= 0
						&& grid[newRow][newCol] == 1) {
					q.add(new Content(newRow, newCol, i.unitTime + 1));
					grid[newRow][newCol] = 2;
					minTime = Math.max(i.unitTime + 1, minTime);
				}
			}

//			if (i.u != 0) {
//				if (grid[i.u - 1][i.v] == 1) {
//					q.add(new Content(i.u - 1, i.v, i.unitTime + 1));
//					grid[i.u - 1][i.v] = 2;
//					minTime = Math.max(i.unitTime + 1, minTime);
//				}
//			}
//
//			if (i.u != grid.length - 1) {
//				if (grid[i.u + 1][i.v] == 1) {
//					q.add(new Content(i.u + 1, i.v, i.unitTime + 1));
//					grid[i.u + 1][i.v] = 2;
//					minTime = Math.max(i.unitTime + 1, minTime);
//				}
//			}
//
//			if (i.v != 0) {
//				if (grid[i.u][i.v - 1] == 1) {
//					q.add(new Content(i.u, i.v - 1, i.unitTime + 1));
//					grid[i.u][i.v - 1] = 2;
//					minTime = Math.max(i.unitTime + 1, minTime);
//				}
//			}
//
//			if (i.v != grid[0].length - 1) {
//				if (grid[i.u][i.v + 1] == 1) {
//					q.add(new Content(i.u, i.v + 1, i.unitTime + 1));
//					grid[i.u][i.v + 1] = 2;
//					minTime = Math.max(i.unitTime + 1, minTime);
//				}
//			}
		}

		// check if all oranges are rotten
		for (int i = 0; i < grid.length; i++)
			for (int j = 0; j < grid[0].length; j++)
				if (grid[i][j] == 1)
					return -1;

		return minTime;
	}

	public static void main(String[] args) {

		int[][] grid = { { 0, 1, 2 }, { 0, 1, 2 }, { 2, 1, 1 } };
		// int[][] grid = { { 2, 2, 0, 1 } };

		System.out.println(findMinTime(grid));
	}

}

//SC : O(N*M)
//TC : O(N*M) + O(4) = O(N*M)