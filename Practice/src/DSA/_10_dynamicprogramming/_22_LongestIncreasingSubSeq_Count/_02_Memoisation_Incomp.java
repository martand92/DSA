package DSA._10_dynamicprogramming._22_LongestIncreasingSubSeq_Count;

public class _02_Memoisation_Incomp {

	static int currMaxLength = 0;

	public static int longestIncreasingSubSeq(int[] arr, int index, int prevIndex, int length, int count, int[][] dp) {

		if (index == arr.length) {

			if (length > currMaxLength) {
				currMaxLength = length;
				return 1;
			}

			if (length == currMaxLength)
				return count + 1;

			return count;
		}

		if (dp[index][prevIndex + 1] != -1)
			return dp[index][prevIndex + 1];

		if (prevIndex == -1 || arr[prevIndex] < arr[index])
			count = longestIncreasingSubSeq(arr, index + 1, index, length + 1, count, dp);

		count = longestIncreasingSubSeq(arr, index + 1, prevIndex, length, count, dp);

		return dp[index][prevIndex + 1] = count;
	}

	public static void main(String[] args) {
		int[] arr = { 5, 4, 6, 7 };
 
		int[][] dp = new int[arr.length][arr.length + 1];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j <= arr.length; j++)
				dp[i][j] = -1;
		}
		System.out.println(longestIncreasingSubSeq(arr, 0, -1, 0, 0, dp));
	}

}

//TC : O(2^n)
//SC : O(n)