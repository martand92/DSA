package DSA.Bucket4._10_dynamicprogramming._02_FrogJump;

public class _01_FrogJump_Recursion {

	public static int energyLost(int n, int[] height) {

		if (n == 0)
			return 0;

		int left = energyLost(n - 1, height) + Math.abs(height[n] - height[n - 1]);

		int right = Integer.MAX_VALUE;
		if (n > 1)
			right = energyLost(n - 2, height) + Math.abs(height[n] - height[n - 2]);

		return Math.min(left, right);

	}

	public static void main(String[] args) {
		int[] height = { 10, 20, 30, 10 };
		System.out.println(energyLost(height.length - 1, height));
	}
}