package DSA.Bucket3._06_stacks;

import java.util.*;

//https://leetcode.com/problems/remove-k-digits/description/
public class _26_RemoveKDigits {

	public static String removeKDigits(String num, int k) {

		Stack<Character> st = new Stack<Character>();
		st.push(num.charAt(0));

		for (int i = 1; i < num.length(); i++) { // TC : O(N)

			// if prev(st.peek()) > curr then prev shouldn't be in final ans
			while (!st.isEmpty() && k > 0 && num.charAt(i) < st.peek()) {
				st.pop();
				k--;
			}
			st.push(num.charAt(i));
		}

		// If still have digits to remove, remove from the end i.e, of {1,4,3,6,7}, k=3,
		// you will remove only "4" & reach end

		// now stack would have {1,3,6,7} & k=2, hence remove last 2 to make num smaller
		while (k > 0 && !st.isEmpty()) {
			st.pop();
			k--;
		}

		StringBuilder sb = new StringBuilder();// Using SB instead of String to reduce from O(N^2) to O(N)
		while (!st.isEmpty())
			sb.append(st.pop());

		sb.reverse();// as stack stores ans in reverse

		// Remove leading zeros
		while (sb.length() > 0 && sb.charAt(0) == '0')
			sb.deleteCharAt(0);

		return sb.toString();
	}

	public static void main(String[] args) {
//		String num = "1432219";
//		int k = 3;

		String num = "10200";
		int k = 1;

//		String num = "10";
//		int k = 2;

		// String num = "123456";
		// int k = 3;
		System.out.println(removeKDigits(num, k));
	}
}