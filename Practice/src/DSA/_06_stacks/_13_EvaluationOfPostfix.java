package DSA._06_stacks;

import java.util.ArrayList;
import java.util.Stack;

//https://practice.geeksforgeeks.org/problems/evaluation-of-postfix-expression1735/1
public class _13_EvaluationOfPostfix {

	public static void main(String[] args) {

		String s = "231*+9-"; // 2 + (3 * 1) – 9 = 5 – 9 = -4.

		Stack<Integer> st = new Stack<Integer>();
		ArrayList<String> al = new ArrayList<String>();
		al.add("*");
		al.add("+");
		al.add("/");
		al.add("-");

		for (int i = 0; i < s.length(); i++) {
			if (al.contains(String.valueOf(s.charAt(i)))) {
				if (st.size() > 1)
					st.push(operator(st.pop(), st.pop(), s.charAt(i)));
			} else
				st.add(s.charAt(i) - '0');

		}

		System.out.println(st.pop());
	}

	public static int operator(int a, int b, char oper) {
		int res = 0;
		switch (oper) {
		case '+':
			res = b + a;
			break;
		case '-':
			res = b - a;
			break;
		case '*':
			res = b * a;
			break;
		case '/':
			res = b / a;
		}
		return res;
	}

}
