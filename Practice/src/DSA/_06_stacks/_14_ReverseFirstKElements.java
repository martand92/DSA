package DSA._06_stacks;

import java.util.*;

public class _14_ReverseFirstKElements {

	public static void main(String[] args) {

		Queue<Integer> q = new LinkedList<Integer>();
		q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);
		q.add(5);

		int k = 3;
		Stack<Integer> st = new Stack<Integer>();
		Queue<Integer> q1 = new LinkedList<Integer>();

		for (int i = 0; i < k; i++)
			st.push(q.poll());

		while (!q.isEmpty())
			q1.add(q.poll());

		while (!st.isEmpty())
			q.add(st.pop());

		while (!q1.isEmpty())
			q.add(q1.poll());

		System.out.println(q);
	}

}
