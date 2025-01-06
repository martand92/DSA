package DSA._11_greedy._04_JumpGame._01_JumpGame;

public class _01_JumpGame {

	public static boolean jumpGame(int[] nums) {

		int maxIndex = 0;

		for (int i = 0; i < nums.length; i++) {

			if (i > maxIndex)
				return false;

			maxIndex = Math.max(maxIndex, nums[i] + i);
		}

		return true;
	}

	public static void main(String[] args) {
		// int[] nums = { 2, 3, 1, 1, 4 };
		int[] nums = { 3, 2, 1, 0, 4 };

		System.out.println(jumpGame(nums));
	}

}
