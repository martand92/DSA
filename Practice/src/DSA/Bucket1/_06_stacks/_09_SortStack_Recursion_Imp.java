package DSA.Bucket1._06_stacks;

import java.util.*;

public class _09_SortStack_Recursion_Imp {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();

		stack.add(11);
		stack.add(9);
		stack.add(12);
		stack.add(8);

		System.out.println(sort(stack));
	}

	public static Stack<Integer> sort(Stack<Integer> st, int temp) {

		if (st.isEmpty() || temp < st.peek()) {
			st.push(temp);
			return st;
		}

		int a = st.pop();
		sort(st, temp);
		st.push(a);
		return st;
	}

	public static Stack<Integer> sort(Stack<Integer> st) {
		if (st.size() == 1)
			return st;

		int temp = st.pop();

		sort(st);
		sort(st, temp);

		return st;

	}

}