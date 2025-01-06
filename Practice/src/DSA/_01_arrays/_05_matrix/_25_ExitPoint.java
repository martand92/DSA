package DSA._01_arrays._05_matrix;

//https://practice.geeksforgeeks.org/problems/exit-point-in-a-matrix0905/1
public class _25_ExitPoint {

	public static void main(String[] args) {
		int[][] matrix = { { 0, 1, 0 }, { 1, 1, 1 }, { 0, 0, 0 } };
		// int[][] matrix = { { 0, 0 } };
		int i = 0, j = 0, previ = 0, prevj = 0;
		boolean rowIncrease = false, columnIncrease = true, columnDecrease = false, rowDecrease = false, initial = true;

		while (i < matrix.length && j < matrix[0].length && j >= 0 && i >= 0) {
			
			if (matrix[i][j] == 1) {
				
				initial = false;
				
				if (i - previ == 1) {
					rowIncrease = true;
					columnIncrease = false;
					columnDecrease = false;
					rowDecrease = false;
					
				} else if (j - prevj == 1) {
					columnIncrease = true;
					rowIncrease = false;
					columnDecrease = false;
					rowDecrease = false;
					
				} else if (j - prevj == -1) {
					columnDecrease = true;
					rowIncrease = false;
					columnIncrease = false;
					rowDecrease = false;
					
				} else if (i - previ == -1) {
					rowDecrease = true;
					columnDecrease = false;
					rowIncrease = false;
					columnIncrease = false;
				}
				matrix[i][j] = 0;
			}

			previ = i;
			prevj = j;

			if (initial || rowDecrease)
				j++;
			else if (columnIncrease)
				i++;
			else if (rowIncrease)
				j--;
			else if (columnDecrease)
				i--;
		}

		System.out.println(previ + " ," + prevj);

	}
}
