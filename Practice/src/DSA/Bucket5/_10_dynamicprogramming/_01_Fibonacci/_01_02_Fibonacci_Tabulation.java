package DSA.Bucket5._10_dynamicprogramming._01_Fibonacci;

public class _01_02_Fibonacci_Tabulation { // Tabulation mean bottom-up

	public static int findFibonacci(int n) {

		int[] dp = new int[n + 1];

		dp[0] = 0;
		dp[1] = 1;

		for (int i = 2; i <= n; i++)
			dp[i] = dp[i - 1] + dp[i - 2];

		return dp[n];

	}

	public static void main(String[] args) {
		int n = 5;
		System.out.println(findFibonacci(n));
	}

}
