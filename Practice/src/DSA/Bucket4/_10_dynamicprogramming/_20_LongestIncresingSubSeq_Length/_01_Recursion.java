package DSA.Bucket4._10_dynamicprogramming._20_LongestIncresingSubSeq_Length;

public class _01_Recursion {

	public static int longestIncreasingSubSeq(int[] arr, int index, int prevIndex) {

		if (index == arr.length)
			return 0;

		int pick = 0;
		if (prevIndex == -1 || (arr[prevIndex] - arr[index] < 0)) {
			pick = 1 + longestIncreasingSubSeq(arr, index + 1, index);
		}

		int notPick = longestIncreasingSubSeq(arr, index + 1, prevIndex);

		return Math.max(pick, notPick);

	}

	public static void main(String[] args) {
		int[] arr = { 10, 9, 2, 5, 3, 7, 101, 18 };
		System.out.println(longestIncreasingSubSeq(arr, 0, -1));
	}

}

//TC : O(2^n)
//SC : O(n)