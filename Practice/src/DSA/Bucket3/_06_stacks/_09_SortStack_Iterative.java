package DSA.Bucket3._06_stacks;

import java.util.*;

public class _09_SortStack_Iterative {

	public static void main(String[] args) {

		Stack<Integer> stack = new Stack<Integer>();

		stack.add(11);
		stack.add(9);
		stack.add(12);
		stack.add(8);

		Stack<Integer> finalStack = sortStack(stack);

		System.out.println(finalStack);

		while (!finalStack.isEmpty())
			System.out.println(finalStack.pop());

	}

	public static Stack<Integer> sortStack(Stack<Integer> st) {

		Stack<Integer> stfinal = new Stack<Integer>();
		Stack<Integer> sttemp = new Stack<Integer>();

		while (!st.isEmpty()) {

			if (stfinal.isEmpty() || stfinal.peek() <= st.peek())
				stfinal.push(st.pop());

			else {

				while (stfinal.peek() > st.peek())
					sttemp.push(stfinal.pop());

				stfinal.push(st.pop());

				while (!sttemp.isEmpty())
					stfinal.push(sttemp.pop());

			}

		}

		return stfinal;
	}

}
