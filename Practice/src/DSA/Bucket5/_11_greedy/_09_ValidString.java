package DSA.Bucket5._11_greedy;

public class _09_ValidString {

	private static boolean isValid(String s) {

		int min = 0, max = 0;

		for (int i = 0; i < s.length(); i++) {

			if (s.charAt(i) == '(') {
				min++;
				max++;

			} else if (s.charAt(i) == ')') {
				if (min > 0)// only update min-1 results in >= 0
					min--;
				max--;

			} else { // if *

				// for min consider min from range 0 to 1
				if (min > 0)// if min-1 results in < 0 then keep min as 0 else do min-1
					min--;

				max = max + 1;
			}
		}

		// if s = ")" then min-1=-1 <0, so keep min=0, but max=-1. Hence return false as its
		// not valid String
		if (max == -1)
			return false;

		return (min == 0);

	}

	public static void main(String[] args) {

		String s = "()*)*()";
		// String s = "(**(";
		System.out.println(isValid(s));
	}

}
