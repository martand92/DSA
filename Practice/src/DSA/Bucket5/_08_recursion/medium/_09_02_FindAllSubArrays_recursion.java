package DSA.Bucket5._08_recursion.medium;

import java.util.*;

public class _09_02_FindAllSubArrays_recursion {

	public static ArrayList<ArrayList<Integer>> findAllSubArrays(int[] arr, int i, ArrayList<Integer> list,
			ArrayList<ArrayList<Integer>> result) {

		for (int j = i; j < arr.length; j++) {
			list.add(arr[j]);
			result.add(new ArrayList<Integer>(list));
		}

		return findAllSubArrays(arr, i + 1, new ArrayList<Integer>(), result);
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3 };
		System.out.println(findAllSubArrays(arr, 0, new ArrayList<Integer>(), new ArrayList<ArrayList<Integer>>()));
	}
}