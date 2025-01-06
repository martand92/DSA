package DSA._08_recursion.medium.pickAndNotPick;

import java.util.*;

//https://www.youtube.com/watch?v=RIn3gOkbhQE
//Print all possible subsets without duplicates. 
//You can do pick and not pick and have all subsets and add to hashSet to avoid duplicates

// But below is more optimized recursion approach to not pick duplicates without hashSet
public class _19_02_SubSetSum_Optimized {

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
		System.out.println(findSubSet(arr, 0, new ArrayList<Integer>(), new ArrayList<ArrayList<Integer>>()));
	}

}
