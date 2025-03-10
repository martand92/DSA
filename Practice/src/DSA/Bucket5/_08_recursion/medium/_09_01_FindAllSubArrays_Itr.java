package DSA.Bucket5._08_recursion.medium;

import java.util.*;

public class _09_01_FindAllSubArrays_Itr {

	public static List<List<Integer>> findSubArrays(int[] arr) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();

		for (int i = 0; i < arr.length; i++) { // O(n)

			for (int j = i; j < arr.length; j++) { // O(n)

				List<Integer> list = new ArrayList<Integer>();

				for (int k = i; k <= j; k++) // O(n)
					list.add(arr[k]);

				result.add(list);
			}

		}

		return result;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3 };
		System.out.println(findSubArrays(arr));
	}

}
//TC : O(n^3)