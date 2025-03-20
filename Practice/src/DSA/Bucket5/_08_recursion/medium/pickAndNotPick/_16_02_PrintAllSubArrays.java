package DSA.Bucket5._08_recursion.medium.pickAndNotPick;

import java.util.*;

public class _16_02_PrintAllSubArrays {

	public static ArrayList<ArrayList<Integer>> findAllSubArrays(int[] arr, int i, List<Integer> list,
			ArrayList<ArrayList<Integer>> result) {

		if (i == arr.length)
			return result;

		list.add(arr[i]);
		result.add(new ArrayList<Integer>(list));
		findAllSubArrays(arr, i + 1, list, result);
		list.remove(list.size() - 1);
		findAllSubArrays(arr, i + 1, list, result);
		return result;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3 };
		System.out.println(findAllSubArrays(arr, 0, new ArrayList<Integer>(), new ArrayList<ArrayList<Integer>>()));
	}
}