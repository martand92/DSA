package DSA.Bucket3._04_recursion.medium;

import java.util.HashSet;

//https://practice.geeksforgeeks.org/problems/generate-ip-addresses/1
public class _03_IPAddress {

	static HashSet<String> hs = new HashSet<String>();

	public static boolean isValid(String st) {
		// Each segment of IP is valid if its 0-255 & doesn't start with 0
		if (Integer.valueOf(st) > 255 || Integer.valueOf(st) < 0 || (st.length() > 1 && st.startsWith("0")))
			return false;

		return true;
	}

	public static HashSet<String> printIPAddress(String st, int i, int j, int k) {

		if (k == st.length())
			return hs;

		/*
		 * Divide given string into 4 segments using 3 indices & get all the
		 * permutations. Then check if all segments are valid then concatenate all
		 * segments with dots
		 */

		String str1 = st.substring(0, i);
		String str2 = st.substring(i, j);
		String str3 = st.substring(j, k);
		String str4 = st.substring(k);

		if (isValid(str1) && isValid(str2) && isValid(str3) && isValid(str4))
			hs.add(str1 + "." + str2 + "." + str3 + "." + str4);

		// first increase k till end of string
		printIPAddress(st, i, j, k + 1);
		printIPAddress(st, i, j + 1, j + 2);
		printIPAddress(st, i + 1, i + 2, i + 3);

		return hs;
	}

	public static void main(String[] args) {
		String st = "1902426";
		// String st = "121111";

		if (st.length() > 3)
			System.out.println(printIPAddress(st, 1, 2, 3));
		else
			System.out.println("-1");
	}

}
