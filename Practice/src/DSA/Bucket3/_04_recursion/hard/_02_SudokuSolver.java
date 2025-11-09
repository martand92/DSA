package DSA.Bucket3._04_recursion.hard;

import java.util.Arrays;

//https://www.youtube.com/watch?v=FWAIf_EVUKE
public class _02_SudokuSolver {

	public static boolean canAdd(char[][] sudoku, int ele, int row, int col) {

		for (int i = 0; i < sudoku.length; i++) {

			// ele about to be added should not be in that row
			if (sudoku[row][i] == ele)
				return false;

			// ele about to be added should not be in that col
			if (sudoku[i][col] == ele)
				return false;

			// check if ele is present in sub matrix
			if (sudoku[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == ele)
				return false;
		}

		return true;
	}

	public static boolean solveSudoku(char[][] sudoku, int row, int col) {
		if (row == sudoku.length)
			return true;

		// find empty col in a given row
		for (int i = col; i < sudoku.length; i++) {

			if (sudoku[row][i] == '\u0000') {

				boolean updated = false;

				// check from 1 -> 9 what can be added
				for (char ele = '1'; ele <= '9'; ele++) {

					if (canAdd(sudoku, ele, row, i)) {
						updated = true;
						sudoku[row][i] = ele;
						if (solveSudoku(sudoku, row, i + 1))
							return true;
					}
				}

				// check if unable to fill any cell in this row, then no need to continue with
				// next rows, so return false
				if (!updated)
					return false;

			}
		}

		if (solveSudoku(sudoku, row + 1, 0))
			return true;

		return false;
	}

	public static void main(String[] args) {
		char[][] sudoku = { { '5', '3', '\u0000', '6', '7', '8', '9', '\u0000', '2' },
				{ '6', '7', '2', '1', '9', '5', '3', '4', '8' }, { '\u0000', '9', '8', '3', '4', '2', '5', '6', '7' },
				{ '8', '5', '9', '7', '6', '1', '4', '2', '3' }, { '4', '2', '6', '8', '5', '3', '7', '9', '1' },
				{ '7', '1', '3', '9', '\u0000', '4', '8', '5', '6' },
				{ '9', '6', '\u0000', '5', '3', '7', '2', '8', '4' }, { '2', '8', '7', '4', '1', '9', '6', '3', '5' },
				{ '3', '4', '5', '2', '8', '6', '1', '7', '9' } };

		solveSudoku(sudoku, 0, 0);
		System.out.println(Arrays.deepToString(sudoku));
	}

}
