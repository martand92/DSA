package DSA._10_dynamicprogramming._03_PickAndNotPick_MaxSumOfNonAdjEle;

public class _04_MaxSumOfNonAdjEle_Tabulation_SpaceOpt {

	public static int findMaxSumOfNonAdjEle(int[] arr, int n) {

		int prev1 = arr[0];
		int prev2 = 0;

		for (int i = 1; i < arr.length; i++) {

			int leftSum = prev2 + arr[i];
			int rightSum = prev1 + 0;

			prev2 = prev1;
			prev1 = Math.max(leftSum, rightSum);
		}

		return prev1;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3 };
		System.out.println(findMaxSumOfNonAdjEle(arr, 0));
	}
}