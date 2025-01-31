package DSA._10_dynamicprogramming._15_String_EditDistance;

public class _03_Tabulation {

	public static int countMinOperations(String s1, String s2, int index1, int index2, int[][] dp) {

		for (int i = 0; i <= s1.length(); i++)
			dp[i][0] = i;

		for (int j = 0; j <= s2.length(); j++)
			dp[0][j] = j;

		for (int i = 1; i <= s1.length(); i++) {

			for (int j = 1; j <= s2.length(); j++) {

				if (s1.charAt(i - 1) == s2.charAt(j - 1))
					dp[i][j] = 0 + dp[i - 1][j - 1];

				else
					dp[i][j] = 1 + Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]);

			}
		}

		return dp[index1][index2];

	}

	public static void main(String[] args) {
		String s1 = "horse";
		String s2 = "ros";

		int[][] dp = new int[s1.length() + 1][s2.length() + 1];
		System.out.println(countMinOperations(s1, s2, s1.length(), s2.length(), dp));
	}
}
//TC : O(N * M)
//SC : O(N * M)