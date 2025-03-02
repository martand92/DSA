package DSA.Bucket4._10_dynamicprogramming._02_FrogJump;

public class _04_FrogJump_SpaceOpt {

	public static int energyLost(int[] height) {

		int prev2 = 0;
		int prev1 = 0;

		for (int i = 1; i < height.length; i++) {

			int left = prev1 + Math.abs(height[i] - height[i - 1]);
			int right = prev2 + Math.abs(height[i] - height[i - 2]);

			prev2 = prev1;
			prev1 = Math.min(left, right);
		}

		return prev1; // dp[i-1] where i = n

	}

	public static void main(String[] args) {
		int[] height = { 10, 20, 30, 10 };
		System.out.println(energyLost(height));
	}
}