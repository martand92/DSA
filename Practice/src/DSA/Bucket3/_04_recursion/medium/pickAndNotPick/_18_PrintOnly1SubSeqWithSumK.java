package DSA.Bucket3._04_recursion.medium.pickAndNotPick;

import java.util.*;

//https://www.geeksforgeeks.org/generating-all-possible-subsequences-using-recursion/
//https://youtu.be/AxNNVECce8c
public class _18_PrintOnly1SubSeqWithSumK {

	public static boolean getAllSubSequences(int[] arr, int index, List<Integer> list, int sum, int k) {

		if (index == arr.length) {

			if (sum == k)// When this.list has the required sum, then backtracking won't modify this.list
							// as its pass by ref.
				return true;

			return false;
		}

		list.add(arr[index]);
		if (getAllSubSequences(arr, index + 1, list, sum + arr[index], k))
			return true;

		list.remove(list.size() - 1);// remove last element from list

		if (getAllSubSequences(arr, index + 1, list, sum, k))
			return true;

		return false;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3 };
		int k = 6;

		List<Integer> list = new ArrayList<Integer>();

		if (getAllSubSequences(arr, 0, list, 0, k))// this list will contain subseq with sum = k as its pass by ref
			System.out.println(list);
		else
			System.out.println(new ArrayList<Integer>().add(-1));
	}

}
