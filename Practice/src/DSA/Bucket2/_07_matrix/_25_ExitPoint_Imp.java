package DSA.Bucket2._07_matrix;

//https://practice.geeksforgeeks.org/problems/exit-point-in-a-matrix0905/1
public class _25_ExitPoint_Imp {

	public static void main(String[] args) {
		int[][] matrix = { { 0, 1, 0 }, { 1, 1, 1 }, { 0, 0, 0 } };
		// int[][] matrix = { { 0, 0 } };
		int i = 0, j = 0, previ = 0, prevj = -1;

		while (i < matrix.length && j < matrix[0].length && j >= 0 && i >= 0) {

			int tempi = i, tempj = j;

			if (matrix[i][j] == 1) {

				if (j - prevj == 1) // moving right
					i++;
				else if (prevj - j == 1) // moving left
					i--;
				else if (previ - i == 1) // moving up
					j++;
				else // moving down
					j--;

				matrix[tempi][tempj] = 0;

			} else { // if matrix[i][j] == 0

				if (j - prevj == 1)
					j++;
				else if (prevj - j == 1)
					j--;
				else if (previ - i == 1)
					i--;
				else
					i++;
			}

			previ = tempi;
			prevj = tempj;

		}

		System.out.println(previ + "," + prevj);

	}
}
