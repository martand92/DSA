package DSA._08_recursion.medium.pickAndNotPick;

import java.util.ArrayList;

//https://www.geeksforgeeks.org/generating-all-possible-subsequences-using-recursion/
//https://youtu.be/AxNNVECce8c
public class _16_03_PrintOnly1SubSeqWithSumK {

	public static boolean getAllSubSequences(int[] arr, int index, ArrayList<Integer> list, int sum, int k) {

		if (index == arr.length) {

			if (sum == k) {
				System.out.println(list);
				return true;
			}

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
		System.out.println(getAllSubSequences(arr, 0, new ArrayList<Integer>(), 0, k));
	}

}
