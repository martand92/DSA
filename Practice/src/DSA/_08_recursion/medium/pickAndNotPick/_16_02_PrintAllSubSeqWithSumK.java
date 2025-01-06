package DSA._08_recursion.medium.pickAndNotPick;

import java.util.ArrayList;

//https://www.geeksforgeeks.org/generating-all-possible-subsequences-using-recursion/
//https://youtu.be/AxNNVECce8c
public class _16_02_PrintAllSubSeqWithSumK {

	public static ArrayList<ArrayList<Integer>> getAllSubSequences(int[] arr, int index, ArrayList<Integer> list,
			ArrayList<ArrayList<Integer>> finalList, int sum, int k) {

		if (index == arr.length) {

			if (sum == k)
				finalList.add(new ArrayList<Integer>(list));

			return finalList;
		}

		// sum += arr[index];
		list.add(arr[index]);
		// below the sum variable is reverted back to previous value when it backtracks
		// as needed. Instead of having sum as method local variable better to declare
		// as method
		// argument so need to explicity revert back
		finalList = getAllSubSequences(arr, index + 1, list, finalList, sum + arr[index], k);
		list.remove(list.size() - 1);// remove last element from list
		finalList = getAllSubSequences(arr, index + 1, list, finalList, sum, k);

		return finalList;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3 };
		int k = 5;
		System.out.println(
				getAllSubSequences(arr, 0, new ArrayList<Integer>(), new ArrayList<ArrayList<Integer>>(), 0, k));
	}

}
