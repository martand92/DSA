package DSA.Bucket4._10_dynamicprogramming._22_LongestIncreasingSubSeq_Count;

public class _02_Memoisation_Incomp {

	static int currMaxLength = 0;

	public static int longestIncreasingSubSeq(int[] arr, int index, int prevIndex) {
		return 1;
	}

	public static void main(String[] args) {
		int[] arr = { 5, 4, 6, 7 };

		int[][] dp = new int[arr.length][arr.length + 1];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j <= arr.length; j++)
				dp[i][j] = -1;
		}
		System.out.println(longestIncreasingSubSeq(arr, 0, -1));
	}

}

//TC : O(2^n)
//SC : O(n)