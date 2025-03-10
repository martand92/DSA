package DSA.Bucket5._10_dynamicprogramming._02_FrogJump;

public class _03_FrogJump_Tabulation {

	public static int energyLost(int[] height) {

		int[] dp = new int[height.length];

		dp[0] = 0;

		for (int i = 1; i < height.length; i++) {

			int left = dp[i - 1] + Math.abs(height[i] - height[i - 1]);

			int right = Integer.MAX_VALUE;
			if (i > 1)
				right = dp[i - 2] + Math.abs(height[i] - height[i - 2]);

			dp[i] = Math.min(left, right);
		}

		return dp[height.length - 1];

	}

	public static void main(String[] args) {
		int[] height = { 10, 20, 30, 10 };
		System.out.println(energyLost(height));
	}
}