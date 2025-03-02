package DSA.Bucket1._06_stacks;

import java.util.Stack;

public class _10_ParenthesisCheck {

	public static void main(String[] args) {
		String s = "[()]";
		System.out.println(ispar(s));
	}

	public static boolean ispar(String x) {
		
		Stack<Character> st = new Stack<Character>();
		
		// add your code here
		if (x.length() % 2 != 0)
			return false;
		
		else {
			for (int i = 0; i < x.length(); i++) {
				if (x.charAt(i) == '{' || x.charAt(i) == '(' || x.charAt(i) == '[')
					st.push(x.charAt(i));

				else if (st.isEmpty())
					return false;

				else if (st.peek() == '{' && x.charAt(i) == '}' || st.peek() == '(' && x.charAt(i) == ')'
						|| st.peek() == '[' && x.charAt(i) == ']') {
					st.pop();
					continue;
				} else
					return false;
			}
			if (!st.isEmpty())
				return false;
		}
		return true;
	}
}
