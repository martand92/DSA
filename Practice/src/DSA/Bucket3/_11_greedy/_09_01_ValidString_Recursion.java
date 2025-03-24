package DSA.Bucket3._11_greedy;

public class _09_01_ValidString_Recursion {

	private static boolean isValid(String s, int i, int sum) {

		// when ) comes before ( then it will never be a valid string
		if (sum < 0)
			return false;

		if (i == s.length()) {

			if (sum == 0)
				return true;

			return false;
		}

		if (s.charAt(i) == '(')
			return isValid(s, i + 1, sum + 1);

		else if (s.charAt(i) == ')')
			return isValid(s, i + 1, sum - 1);

		else
			return isValid(s, i + 1, sum + 1) | isValid(s, i + 1, sum) | isValid(s, i + 1, sum - 1);

	}

	public static void main(String[] args) {

		// String s = "()*)*()";
		// String s = "(**(";
		String s = "(*)";
		System.out.println(isValid(s, 0, 0));
	}
}