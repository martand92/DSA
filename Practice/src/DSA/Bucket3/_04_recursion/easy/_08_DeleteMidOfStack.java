package DSA.Bucket3._04_recursion.easy;

import java.util.*;

public class _08_DeleteMidOfStack {

	public static Stack<Integer> deleteMidNum(Stack<Integer> s, int mid) {

		if (mid == 1) {// when mid == 1 st.top need to be removed
			s.pop();
			return s;
		}

		int temp = s.pop();
		deleteMidNum(s, mid - 1);
		s.push(temp);

		return s;
	}

	public static void main(String[] args) {

		Stack<Integer> s = new Stack<Integer>();
		//s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);

		// Way to calculate mid when size of stack is both even / odd
		int mid = (int) Math.ceil((s.size() + 1) / 2);

		System.out.println(deleteMidNum(s, mid));
	}

}
