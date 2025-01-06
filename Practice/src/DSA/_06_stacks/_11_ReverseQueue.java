package DSA._06_stacks;

import java.util.*;

public class _11_ReverseQueue {
	public static void main(String[] args) {

		Queue<Integer> q = new LinkedList<Integer>();
		q.add(4);
		q.add(3);
		q.add(2);
		q.add(1);

		Stack<Integer> st = new Stack<Integer>();
		while (!q.isEmpty())
			st.push(q.poll());

		while (!st.isEmpty())
			q.add(st.pop());
		
		System.out.println(q);
	}
}
