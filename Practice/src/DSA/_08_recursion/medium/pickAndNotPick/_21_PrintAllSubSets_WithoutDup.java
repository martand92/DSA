package DSA._08_recursion.medium.pickAndNotPick;

import java.util.*;

//https://www.youtube.com/watch?v=RIn3gOkbhQE
//Problem Statement : Print all possible subsets without duplicates.

//Brute Force : You can do pick and not pick and add all subsets to hashSet to avoid duplicates

/*
 * Opt: Below sorted input data results in multiple duplicate subsets, but this algo prints only unique 
 * Note : This works only on sorted input
 */

public class _21_PrintAllSubSets_WithoutDup {

	public static ArrayList<ArrayList<Integer>> findSubSet(int[] arr, int index, ArrayList<Integer> list,
			ArrayList<ArrayList<Integer>> result) {

		// base case not needed
		result.add(new ArrayList<Integer>(list));

		for (int i = index; i < arr.length; i++) {

			if (i == index || arr[i - 1] != arr[i]) {
				list.add(arr[i]);
				findSubSet(arr, i + 1, list, result);
				list.remove(list.size() - 1);
			}

		}

		return result;
	}

	public static void main(String[] args) {
		
		int[] arr = { 1, 2, 2 };

		Arrays.sort(arr); // input need to be sorted

		System.out.println(findSubSet(arr, 0, new ArrayList<Integer>(), new ArrayList<ArrayList<Integer>>()));
	}

}
