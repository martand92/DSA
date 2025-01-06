package DSA._08_recursion;

import java.util.ArrayList;

//https://practice.geeksforgeeks.org/problems/find-all-possible-paths-from-top-to-bottom/1
public class _01_FindAllPossiblePaths {

	static ArrayList<Integer> al = new ArrayList<Integer>();
	static ArrayList<ArrayList<Integer>> finalAl = new ArrayList<ArrayList<Integer>>();

	public static void findingPath(int[][] mat, int i, int j) {

		if (i == mat.length || j == mat[0].length)
			return;

		al.add(mat[i][j]);

		findingPath(mat, i, j + 1);
		findingPath(mat, i + 1, j);

		if (i == mat.length - 1 && j == mat[0].length - 1) {
			ArrayList<Integer> al1 = new ArrayList<Integer>();
			al1.addAll(al);
			finalAl.add(al1);
		}

		al.remove(al.size() - 1);

		return;

	}

	public static void main(String[] args) {

		int[][] grid = { { 1, 2, 3 }, { 4, 5, 6 } };

		findingPath(grid, 0, 0);

		System.out.println(finalAl);
	}
}
