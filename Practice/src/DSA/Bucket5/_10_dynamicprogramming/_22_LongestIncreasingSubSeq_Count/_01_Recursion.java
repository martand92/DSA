package DSA.Bucket5._10_dynamicprogramming._22_LongestIncreasingSubSeq_Count;

public class _01_Recursion {

	public static int longestIncreasingSubSeq(int[] arr, int index, int prevIndex) {

		if (index == arr.length)
			return 0;

		int pick = 0;
		if (prevIndex == -1 || (arr[prevIndex] - arr[index] < 0))
			pick = 1 + longestIncreasingSubSeq(arr, index + 1, index);

		int notPick = longestIncreasingSubSeq(arr, index + 1, prevIndex);

		return Math.max(pick, notPick);
	}

	public static int countLongestSubSeq(int[] arr, int index, int prevIndex, int currLength, int longestSubSeq) {

		if (index == arr.length) {
			if (currLength == longestSubSeq)
				return 1;

			return 0;
		}

		int pick = 0;
		if (prevIndex == -1 || (arr[prevIndex] - arr[index] < 0))
			pick = countLongestSubSeq(arr, index + 1, index, currLength + 1, longestSubSeq);

		int notPick = countLongestSubSeq(arr, index + 1, prevIndex, currLength, longestSubSeq);

		return pick + notPick;

	}

	public static void main(String[] args) {
		int[] arr = { 5, 4, 6, 7 };
		int longestSubSeq = longestIncreasingSubSeq(arr, 0, -1);
		System.out.println(countLongestSubSeq(arr, 0, -1, 0, longestSubSeq));
	}
}
//TC : O(2^n)
//SC : O(n)