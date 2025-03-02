package DSA.Bucket4._10_dynamicprogramming._01_Fibonacci;

import java.util.Arrays;

public class _01_01_Fibonacci_Memoisation {

	public static int findFibonacci(int n, int sum, int[] dp) {

		if (n <= 1)
			return n;

		if (dp[n] != -1)
			return dp[n];

		return dp[n] = findFibonacci(n - 1, sum, dp) + findFibonacci(n - 2, sum, dp);
	}

	public static void main(String[] args) {
		int n = 5, sum = 0;
		int[] dp = new int[n + 1];
		Arrays.fill(dp, -1);
		System.out.println(findFibonacci(n, sum, dp));
	}

}
