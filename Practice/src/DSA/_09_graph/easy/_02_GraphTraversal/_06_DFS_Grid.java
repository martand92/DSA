package DSA._09_graph.easy._02_GraphTraversal;

public class _06_DFS_Grid {

	static class Vertex {
		int i;
		int j;

		Vertex(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

	public static void dfs(int[][] grid, int i, int j, boolean[][] visited) {

		visited[i][j] = true;
		System.out.println("Visiting: (" + i + ", " + j + ")");

		// Directions for moving up, down, left, right
		int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

		for (int k = 0; k < directions.length; k++) {

			int newrow = i + directions[k][0];
			int newcol = j + directions[k][1];

			if (newrow >= 0 && newrow < grid.length && newcol >= 0 && newcol < grid[0].length
					&& grid[newrow][newcol] == 1 && !visited[newrow][newcol]) {
				dfs(grid, newrow, newcol, visited);
			}
		}
	}

	public static void main(String[] args) {

		int[][] grid = { { 1, 1, 0, 0 }, { 0, 1, 0, 1 }, { 1, 0, 1, 1 }, { 0, 0, 1, 1 } };
		boolean[][] visited = new boolean[grid.length][grid[0].length];

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {

				if (grid[i][j] == 1 && !visited[i][j]) {
					System.out.println("Starting new DFS from: (" + i + ", " + j + ")");
					dfs(grid, i, j, visited);
				}
			}
		}

	}

}
