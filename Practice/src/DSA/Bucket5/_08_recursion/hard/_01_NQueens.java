package DSA.Bucket5._08_recursion.hard;

//https://www.youtube.com/watch?v=i05Ju7AftcM
import java.util.ArrayList;
import java.util.Arrays;

public class _01_NQueens {

	public static boolean canAddQueen(char[][] grid, int row, int col) {

		// cannot contain another Q in same row
		for (int i = 0; i < col; i++)
			if (grid[row][i] == 'Q')
				return false;

		int[] rowVal = { -1, 0, 1 };
		int[] colVal = { -1, 0, 1 };

		for (int i = 0; i < rowVal.length; i++) {
			for (int j = 0; j < colVal.length; j++) {

				int deltaRow = row + rowVal[i];
				int deltaCol = col + colVal[j];

				if (deltaRow > -1 && deltaRow < grid.length && deltaCol > -1 && deltaCol < grid[0].length) {

					if (grid[deltaRow][deltaCol] == 'Q')
						return false;
				}
			}
		}

		return true;
	}

	public static ArrayList<String> findDistinctQueenPlacement(int n, char[][] grid, int col,
			ArrayList<String> result) {

		if (col == n) {
			String[] mainString = new String[n];
			for (int i = 0; i < n; i++) {
				String str = new String();
				for (int j = 0; j < n; j++)
					str += grid[i][j] != 'Q' ? '.' : 'Q';
				mainString[i] = str;
			}
			result.add(Arrays.toString(mainString));
			return result;
		}

		for (int row = 0; row < n; row++) {
			if (canAddQueen(grid, row, col)) {
				grid[row][col] = 'Q';
				findDistinctQueenPlacement(n, grid, col + 1, result);
				grid[row][col] = '\u0000';
			}
		}

		return result;
	}

	public static void main(String[] args) {
		int n = 4;
		char[][] grid = new char[n][n];
		System.out.println(findDistinctQueenPlacement(n, grid, 0, new ArrayList<String>()));
	}

}