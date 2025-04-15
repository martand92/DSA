package DSA.Bucket5._08_recursion.medium;

import java.util.*;

public class _09_01_FindAllSubArrays_Itr {

	public static List<List<Integer>> findSubArrays(int[] arr) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();

		for (int i = 0; i < arr.length; i++) { // O(n)

			List<Integer> list = new ArrayList<Integer>();

			for (int j = i; j < arr.length; j++) { // O(n){
				list.add(arr[j]);
				result.add(new ArrayList<Integer>(list));
			}

		}

		return result;

	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3 };
		System.out.println(findSubArrays(arr));
	}
}
//TC : O(n^2)