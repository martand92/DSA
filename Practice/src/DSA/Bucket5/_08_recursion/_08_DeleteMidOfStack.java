package DSA.Bucket5._08_recursion;

import java.util.*;

public class _08_DeleteMidOfStack {

	public static Stack<Integer> deleteMidNum(Stack<Integer> s, int mid) {

		if (mid == s.peek())
			s.pop();

		else {
			int temp = s.pop();
			deleteMidNum(s, mid);
			s.push(temp);
		}

		return s;
	}

	public static void main(String[] args) {

		// here input is in sorted order else calculate mid element based on stack size
		Stack<Integer> s = new Stack<Integer>();
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);

		// Way to calculate mid when size of stack is both even / odd
		int mid = (int) Math.ceil((s.size() + 1) / 2);

		System.out.println(deleteMidNum(s, mid));
	}

}
