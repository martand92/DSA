package DSA.Bucket5._10_dynamicprogramming._15_String_EditDistance;

public class _02_02_Memoisation_1BasedIndexingForTabulation {

	public static int countMinOperations(String s1, String s2, int index1, int index2, int[][] dp) {

		if (index1 == 0)
			return index2;
		
		if (index2 == 0)
			return index1;

		if (dp[index1][index2] != -1)
			return dp[index1][index2];

		if (s1.charAt(index1 - 1) == s2.charAt(index2 - 1))
			return 0 + countMinOperations(s1, s2, index1 - 1, index2 - 1, dp);

		else {
			int insertCount = 1 + countMinOperations(s1, s2, index1, index2 - 1, dp);
			int deleteCount = 1 + countMinOperations(s1, s2, index1 - 1, index2, dp);
			int replaceCount = 1 + countMinOperations(s1, s2, index1 - 1, index2 - 1, dp);

			int minTemp = Math.min(insertCount, deleteCount);
			return dp[index1][index2] = Math.min(minTemp, replaceCount);
		}
	}

	public static void main(String[] args) {
		String s1 = "horse";
		String s2 = "ros";

		int[][] dp = new int[s1.length() + 1][s2.length() + 1];
		for (int i = 0; i <= s1.length(); i++) {
			for (int j = 0; j <= s2.length(); j++) {
				dp[i][j] = -1;
			}
		}

		System.out.println(countMinOperations(s1, s2, s1.length(), s2.length(), dp));
	}
}
//TC : O(N * M)
//SC : O(N * M) + O(N + M)