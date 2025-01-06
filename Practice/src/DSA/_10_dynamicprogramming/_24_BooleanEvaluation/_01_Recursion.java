package DSA._10_dynamicprogramming._24_BooleanEvaluation;

public class _01_Recursion {

	public static int countTrueEval(String exp, int i, int j, int isTrue) {

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

		int ways = 0;

		// loop from 1st operand to last operand and make partition at every operand
		for (int k = i + 1; k <= j - 1; k = k + 2) {

			int leftTrue = countTrueEval(exp, i, k - 1, 1);// from first index to left of partition k to eval to true
			int leftFalse = countTrueEval(exp, i, k - 1, 0);// from first index to left of partition k to eval to false
			int rightTrue = countTrueEval(exp, k + 1, j, 1);// from right of partition to last element to eval to true
			int rightFalse = countTrueEval(exp, k + 1, j, 0);// from right of partition to last element to eval to false

			// now check for operand at every partition
			// Counting in recursion involves summing up both left & right traversal
			if (exp.charAt(k) == '&') {
				if (isTrue == 1)
					ways += leftTrue * rightTrue;
				else
					ways += (leftTrue * rightFalse) + (leftFalse * rightTrue) + (rightFalse * leftFalse);

			} else if (exp.charAt(k) == '|') {
				if (isTrue == 1)
					ways += (leftTrue * rightFalse) + (leftFalse * rightTrue) + (leftTrue * rightTrue);
				else
					ways += rightFalse * leftFalse;

			} else {
				if (isTrue == 1)
					ways += (leftTrue * rightFalse) + (leftFalse * rightTrue);
				else
					ways += (leftTrue * rightTrue) + (rightFalse * leftFalse);
			}
		}

		return ways;

	}

	public static void main(String[] args) {
		// String exp = "T|T&F";
		String exp = "F|T^F";
		System.out.println(countTrueEval(exp, 0, exp.length() - 1, 1));
	}

}
