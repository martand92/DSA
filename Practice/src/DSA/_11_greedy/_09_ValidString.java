package DSA._11_greedy;

public class _09_ValidString {

	private static boolean isValid(String s) {
		int min = 0, max = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				min++;
				max++;

			} else if (s.charAt(i) == ')') {
				if (min - 1 >= 0)// only update min if >= 0 after doing -1
					min = min - 1;

				max--;
			} else { // if *

				// for min consider minimum from range 0 to 1
				if ((min - 1) >= 0)// first do -1 to min and check if its >= 0, only then consider. Else do min + 0
									// and consider it as min
					min = min - 1;

				max = max + 1;
			}

		}

		// if s = ")" then min-1=-1, remains 0 & max=-1. Hence return false as its
		// not valid String
		if (max == -1)
			return false;

		return (min == 0);

	}

	public static void main(String[] args) {

		String s = "()*)*()";
		System.out.println(isValid(s));
	}

}
