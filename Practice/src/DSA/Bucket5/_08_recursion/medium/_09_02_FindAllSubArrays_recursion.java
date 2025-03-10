package DSA.Bucket5._08_recursion.medium;

import java.util.*;

public class _09_02_FindAllSubArrays_recursion {

	public static ArrayList<ArrayList<Integer>> findAllSubArrays(int[] arr, int i, List<Integer> list,
			ArrayList<ArrayList<Integer>> result) {

		if (i == arr.length)
			return result;

		list.add(arr[i]);
		result.add(new ArrayList<Integer>(list));
		return findAllSubArrays(arr, i + 1, list, result);
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3 };

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < arr.length; i++)
			result = findAllSubArrays(arr, i, new ArrayList<Integer>(), result);

		System.out.println(result);
	}
}