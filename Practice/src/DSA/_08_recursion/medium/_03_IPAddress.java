package DSA._08_recursion.medium;

import java.util.HashSet;

//https://practice.geeksforgeeks.org/problems/generate-ip-addresses/1
public class _03_IPAddress {

	static HashSet<String> hs = new HashSet<String>();

	public static boolean isValid(String st) {

		// given string is valid IP if its value is between 0-255 and doesnt start with
		// 0
		if (Integer.valueOf(st) > 255 || Integer.valueOf(st) < 0 || (st.length() > 1 && st.startsWith("0")))
			return false;

		return true;
	}

	public static HashSet<String> printIPAddress(String st, int i, int j, int k) {

		if (k == st.length())
			return hs;

		String[] str = new String[4];

		// Divide given string into 4 parts with placing dots in appropriate positions
		str[0] = st.substring(0, i);
		str[1] = st.substring(i, j);
		str[2] = st.substring(j, k);
		str[3] = st.substring(k);

		StringBuilder finalString = new StringBuilder();

		// form string with x.x.x.x only if each x is valid
		for (int l = 0; l < str.length; l++) {

			if (isValid(str[l])) {
				finalString.append(str[l]);

				if (l != str.length - 1)
					finalString.append(".");

			} else {
				finalString = new StringBuilder();
				break;
			}
		}

		if (finalString.length() > 0)
			hs.add(finalString.toString());

		// first increase k till end of string
		printIPAddress(st, i, j, k + 1);
		// k = j + 1;
		printIPAddress(st, i, j + 1, j + 2);
		// j = i + 1;
		// k = j + 1;
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
