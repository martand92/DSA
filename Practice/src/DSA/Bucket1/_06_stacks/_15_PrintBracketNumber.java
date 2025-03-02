package DSA.Bucket1._06_stacks;

import java.util.*;

//https://practice.geeksforgeeks.org/problems/print-bracket-number4058/1
public class _15_PrintBracketNumber {

	public static void main(String[] args) {
		String s = "(aa(bdc))p(dee)â€‹";
		int count = 0;

		ArrayList<Integer> al = new ArrayList<Integer>();
		Stack<Integer> st = new Stack<Integer>();

		for (int i = 0; i < s.length(); i++) {

			if (s.charAt(i) == '(') {
				count++;
				st.push(count);
				al.add(count);

			} else if (s.charAt(i) == ')')
				al.add(st.pop());

		}
		System.out.println(al);
	}

}
