package DSA.Bucket5._08_recursion.easy;

import java.util.*;

//https://practice.geeksforgeeks.org/problems/find-all-possible-paths-from-top-to-bottom/1
public class _01_02_FindAllPossiblePaths {

	public static ArrayList<ArrayList<Integer>> findingPath(int[][] mat, int i, int j,
			ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list) {

		if (i == mat.length || j == mat[0].length)
			return result;

		list.add(mat[i][j]);

		result = findingPath(mat, i, j + 1, result, list);
		result = findingPath(mat, i + 1, j, result, list);

		if (i == mat.length - 1 && j == mat[0].length - 1)
			result.add(new ArrayList<Integer>(list));

		list.remove(list.size() - 1);

		return result;
	}

	public static void main(String[] args) {
		int[][] grid = { { 1, 2, 3 }, { 4, 5, 6 } };
		System.out.println(findingPath(grid, 0, 0, new ArrayList<ArrayList<Integer>>(), new ArrayList<Integer>()));
	}
}