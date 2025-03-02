package DSA.Bucket1._06_stacks;

import java.util.*;

//https://practice.geeksforgeeks.org/problems/string-manipulation3706/1
public class _16_StringManipulation {
	public static void main(String[] args) {

		Vector<String> v = new Vector<>();
		v.add("ab");
		v.add("aa");
		v.add("aa");
		v.add("bcd");
		v.add("ab");

		Stack<String> st = new Stack<String>();

		for (int i = 0; i < v.size(); i++) {
			if (st.isEmpty())
				st.push(v.get(i));

			else if (st.peek().equals(v.get(i)))
				st.pop();

			else
				st.push(v.get(i));
		}
		System.out.println(st.size());
	}

}
