package DSA.Bucket2._01_arrays._05_matrix;

import java.util.*;

//https://practice.geeksforgeeks.org/problems/print-matrix-in-diagonal-pattern/1
public class _28_PrintDiagonalMatrix {

	public static void main(String[] args) throws Exception {
		// int[][] a = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		int[][] a = { { 5, 10, 5 }, { 9, 9, 10 }, { 6, 1, 3 } };

		ArrayList<Integer> al = new ArrayList<Integer>();
		ArrayList<Integer> tempal = new ArrayList<Integer>();
		int row = 0, col = 0;
		int i = 0, j = 0;

		// Add diagonal elements in reverse order to alternate iteration
		boolean reverse = true;
		
		
		while (j != a[0].length - 1 || i < a.length) {
			col = j;
			row = i;
			
			//keep adding diagonal elements to temp array list
			while (col >= 0 && row < a.length) {
				tempal.add(a[row][col]);
				col--;
				row++;
			}
			
			//reverse array list if previous list was not reversed
			if (reverse)
				Collections.reverse(tempal);

			reverse = !reverse;
			
			//add this temp al to final al
			al.addAll(tempal);
			tempal.clear();

			if (j != a[0].length - 1)
				j++;

			else if (j == a[0].length - 1)
				i++;

		}

		int[] a1 = new int[a.length * a[0].length];

		for (i = 0; i < al.size(); i++)
			a1[i] = al.get(i);

		System.out.println(Arrays.toString(a1));

	}
}
