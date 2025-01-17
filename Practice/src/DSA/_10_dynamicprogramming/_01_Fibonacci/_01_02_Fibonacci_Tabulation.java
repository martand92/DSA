package DSA._10_dynamicprogramming._01_Fibonacci;

import java.util.Arrays;

public class _01_02_Fibonacci_Tabulation { // Tabulation mean bottom-up

	public static int findFibonacci(int n) {

		int[] dp = new int[n + 1];
		Arrays.fill(dp, -1);
		// convert base case of memoisation to dp array. i.e,
		// if(n ==1) return 1 and if(n == 0) return 0; will be dp array elements
		dp[0] = 0;
		dp[1] = 1;

		// Now recursive relationship need to be converted to iteration
		// So in fibonacci, f(n-1) + f(n-2) will be executed from n = 2 to n
		for (int i = 2; i <= n; i++)
			dp[i] = dp[i - 1] + dp[i - 2];

		System.out.println(Arrays.toString(dp));
		return dp[n];

	}

	public static void main(String[] args) {
		int n = 5;
		System.out.println(findFibonacci(n));
	}

}
