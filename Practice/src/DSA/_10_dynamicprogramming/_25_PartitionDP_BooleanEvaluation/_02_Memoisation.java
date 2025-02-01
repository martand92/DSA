package DSA._10_dynamicprogramming._25_PartitionDP_BooleanEvaluation;

public class _02_Memoisation {

	public static int countTrueEval(String exp, int i, int j, int isTrue, int[][][] dp) {

		if (i > j)
			return 0;

		if (i == j) {
			if (isTrue == 1) {
				if (exp.charAt(i) == 'T')
					return 1;// Only 1 way to eval exp to true with single char(as i=j) to 'T'
			} else {
				if (exp.charAt(i) == 'F')
					return 1;// Only 1 way to eval exp to false with single char(as i=j) to 'F'
			}
			return 0;
		}

		if (dp[i][j][isTrue] != -1)
			return dp[i][j][isTrue];

		int ways = 0;
		int mod = (int) 1e9 + 7;
		// loop from 1st operand to last operand and make partition at every operand
		for (int k = i + 1; k <= j - 1; k = k + 2) {

			int leftTrue = countTrueEval(exp, i, k - 1, 1, dp);// from first index to left of partition k to eval to
																// true
			int leftFalse = countTrueEval(exp, i, k - 1, 0, dp);// from first index to left of partition k to eval to
																// false
			int rightTrue = countTrueEval(exp, k + 1, j, 1, dp);// from right of partition to last element to eval to
																// true
			int rightFalse = countTrueEval(exp, k + 1, j, 0, dp);// from right of partition to last element to eval to
																	// false

			// now check for operand at every partition
			// Counting in recursion involves summing up both left & right traversal
			if (exp.charAt(k) == '&') {
				if (isTrue == 1)
					ways += ((leftTrue * rightTrue) % mod) % mod;
				else
					ways += ((leftTrue * rightFalse) % mod + (leftFalse * rightTrue) % mod
							+ (rightFalse * leftFalse) % mod) % mod;

			} else if (exp.charAt(k) == '|') {
				if (isTrue == 1)
					ways += ((leftTrue * rightFalse) % mod + (leftFalse * rightTrue) % mod
							+ (leftTrue * rightTrue) % mod) % mod;
				else
					ways += (rightFalse * leftFalse) % mod;

			} else {
				if (isTrue == 1)
					ways += ((leftTrue * rightFalse) % mod + (leftFalse * rightTrue) % mod) % mod;
				else
					ways += ((leftTrue * rightTrue) % mod + (rightFalse * leftFalse) % mod) % mod;
			}
		}

		return dp[i][j][isTrue] = ways;

	}

	public static void main(String[] args) {
		// String exp = "T|T&F";
		String exp = "F|T^F";

		int[][][] dp = new int[exp.length()][exp.length()][2];
		for (int i = 0; i < exp.length(); i++) {
			for (int j = 0; j < exp.length(); j++) {
				for (int isTrue = 0; isTrue < 2; isTrue++) {
					dp[i][j][isTrue] = -1;
				}
			}
		}
		System.out.println(countTrueEval(exp, 0, exp.length() - 1, 1, dp));
	}

}
