package DSA.Bucket5._10_dynamicprogramming._08_SubSeq_SubSetSum;

public class _03_Tabulation {

	public static boolean checkIfKSum(int[] arr, int k) {

		boolean[][] dp = new boolean[arr.length][k + 1];

		for (int i = 0; i < arr.length; i++)
			dp[i][0] = true;

		dp[0][arr[0]] = true;

		for (int i = 1; i < dp.length; i++) {

			for (int j = 1; j < dp[0].length; j++) {// for j=0 its already set in line#10

				boolean pick = false;
				if (j >= arr[i])
					pick = dp[i - 1][j - arr[i]];

				boolean notPick = dp[i - 1][j];

//				dp[index][k] = pick || notPick ? 1 : 0; // update dp[][] to 1 or 0 from -1 to indicate this index,k is visited
//				return pick || notPick;
				dp[i][j] = pick | notPick;
			}
		}

		return dp[arr.length - 1][k];

	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3 };
		int k = 6;

		// directly writing dp as boolean instead of int
		System.out.println(checkIfKSum(arr, k));
	}
}