package DSA.Bucket4._06_stacks;

import java.util.Stack;

//https://practice.geeksforgeeks.org/problems/evaluation-of-postfix-expression1735/1
public class _13_EvaluationOfPostfix_Imp {

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

	public static int evaluation(String str) {

		Stack<Integer> st = new Stack<Integer>();

		for (int i = 0; i < str.length(); i++) {

			if (Character.isDigit(str.charAt(i)))
				st.push(Character.getNumericValue(str.charAt(i)));
			else
				st.push(operator(st.pop(), st.pop(), str.charAt(i)));
		}

		return st.pop();
	}

	public static void main(String[] args) {
		String s = "231*+9-"; // 2 + (3 * 1) – 9 = 5 – 9 = -4.
		System.out.println(evaluation(s));
	}
}
