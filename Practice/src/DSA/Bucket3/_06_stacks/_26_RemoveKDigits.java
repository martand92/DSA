package DSA.Bucket3._06_stacks;

import java.util.*;

public class _26_RemoveKDigits {

	public static String reverseString(String str) {
		if (str.length() == 1)
			return str;

		return reverseString(str.substring(1)) + str.charAt(0);
	}

	public static String removeKDigits(String num, int k) {

		Stack<Character> st = new Stack<Character>();
		st.push(num.charAt(0));

		for (int i = 1; i < num.length(); i++) { // TC : O(N)

			if (k == 0)
				st.push(num.charAt(i));

			// if curr < pre then pre shouldn't be part of final ans as its higher number
			else if ((int) st.peek() > (int) num.charAt(i)) {
				st.pop();
				st.push(num.charAt(i));
				k--;

			} else if (i < num.length() - 1 && (int) st.peek() < (int) num.charAt(i)
					&& (int) num.charAt(i) < (int) num.charAt(i + 1))
				st.push(num.charAt(i));
			else
				k--;
		}

		// ex: {1,2,3,4,5} and k = 3, then all elements gets added to stack without
		// removing anything. Hence k will remain as 3. So in this case, you can remove
		// last 3 elements to get to smallest int
		while (k > 0) { // O(K)
			st.pop();
			k--;
		}

		// if all elements can be removed ex: "10" and k = 2, then ans = "0"
		if (st.isEmpty())
			return "0";

		String str = "";
		while (!st.isEmpty())// O(N) cz at worst case none of the elements will be removed and all will be
								// added to stack
			str += st.pop();

		return String.valueOf(Integer.valueOf(reverseString(str))); // converting to int to remove trailing zeros and
																	// reversing received string as stack stores ans in
																	// reverse order
	}

	public static void main(String[] args) {
//		String num = "1432219";
//		int k = 3;

//		String num = "10200";
//		int k = 1;

//		String num = "10";
//		int k = 2;

		String num = "123456";
		int k = 3;
		System.out.println(removeKDigits(num, k));

	}

}
