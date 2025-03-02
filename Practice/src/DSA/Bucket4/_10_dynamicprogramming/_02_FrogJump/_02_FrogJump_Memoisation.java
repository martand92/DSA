package DSA.Bucket4._10_dynamicprogramming._02_FrogJump;

import java.util.Arrays;

public class _02_FrogJump_Memoisation {

	public static int energyLost(int n, int[] height, int[] dp) {

		if (n == 0)
			return 0;

		if (dp[n] != -1)
			return dp[n];

		int left = energyLost(n - 1, height, dp) + Math.abs(height[n] - height[n - 1]);

		int right = Integer.MAX_VALUE;
		if (n > 1)
			right = energyLost(n - 2, height, dp) + Math.abs(height[n] - height[n - 2]);

		return dp[n] = Math.min(left, right);

	}

	public static void main(String[] args) {

		int[] height = { 10, 20, 30, 10 };

		int[] dp = new int[height.length];
		Arrays.fill(dp, -1);

		System.out.println(energyLost(height.length - 1, height, dp));
	}
}