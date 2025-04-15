package DSA.Bucket5._08_recursion.medium.pickAndNotPick;

import java.util.*;

//This could also be solved using pick & not pick : _16_02_PrintAllSubArrays
public class _15_01_PrintAllSubSeq_WithoutPickAndNotPick {

	public static ArrayList<ArrayList<Integer>> findAllSubArrays(int[] arr, int i, List<Integer> list,
			ArrayList<ArrayList<Integer>> result) {

//		if (i == arr.length)
//			return result;

		result.add(new ArrayList<Integer>(list));

		for (int j = i; j < arr.length; j++) {
			list.add(arr[j]);
			findAllSubArrays(arr, j + 1, list, result);
			list.remove(list.size() - 1);
		}
		return result;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3 };
		System.out.println(findAllSubArrays(arr, 0, new ArrayList<Integer>(), new ArrayList<ArrayList<Integer>>()));
	}
}