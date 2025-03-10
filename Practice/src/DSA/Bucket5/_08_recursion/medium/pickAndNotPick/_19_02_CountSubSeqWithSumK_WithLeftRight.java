package DSA.Bucket5._08_recursion.medium.pickAndNotPick;

import java.util.ArrayList;

//https://www.geeksforgeeks.org/generating-all-possible-subsequences-using-recursion/
//https://youtu.be/AxNNVECce8c
public class _19_02_CountSubSeqWithSumK_WithLeftRight {

	public static int getAllSubSequences(int[] arr, int index, ArrayList<Integer> list, int sum, int k, int count) {

		if (index == arr.length) {
			if (sum == k)
				return 1;

			return 0;
		}

		list.add(arr[index]);
		int left = getAllSubSequences(arr, index + 1, list, sum + arr[index], k, count);
		list.remove(list.size() - 1);
		int right = getAllSubSequences(arr, index + 1, list, sum, k, count);

		return left + right;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3 };
		int k = 3;
		System.out.println(getAllSubSequences(arr, 0, new ArrayList<Integer>(), 0, k, 0));
	}
}