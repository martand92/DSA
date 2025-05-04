package DSA.Bucket2._01_arrays._03_matrix;

import java.util.*;

//https://practice.geeksforgeeks.org/problems/sorted-matrix2333/1
public class _05_SortedMatrix {

	public static void main(String[] args) {
		// int[][] a = new int[7][7];
		int[][] a = { { 68, 35, 1, 70, 25, 79, 59 }, { 63, 65, 6, 46, 82, 28, 62 }, { 92, 96, 43, 28, 37, 92, 5 },
				{ 3, 54, 93, 83, 22, 17, 19 }, { 96, 48, 27, 72, 39, 70, 13 }, { 68, 100, 36, 95, 4, 12, 23 },
				{ 34, 74, 65, 42, 12, 54, 69 } };
		
		Arrays.sort(a);
		System.out.println(Arrays.deepToString(a));

		ArrayList<Integer> al = new ArrayList<Integer>();

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++)
				al.add(a[i][j]);

		}

		Collections.sort(al);
		int k = 0;

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++)
				a[i][j] = al.get(k++);
		}

		//System.out.println(Arrays.deepToString(a));

	}
}
