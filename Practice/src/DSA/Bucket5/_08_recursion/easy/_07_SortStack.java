package DSA.Bucket5._08_recursion.easy;

import java.util.*;

public class _07_SortStack {

	int top = 0;
	int temp = 0; // These cant be static as each stack frame will store its own instance

	public static Stack<Integer> sortedInsert(Stack<Integer> s, int temp, int top) {

		if (s.empty() || s.peek() < temp)
			s.push(temp);

		else {
			top = s.pop();
			sortedInsert(s, temp, top);
			s.push(top);
		}
		return s;
	}

	public static Stack<Integer> sort(Stack<Integer> s, int temp, int top) {
		if (!s.empty()) {
			temp = s.pop();
			sort(s, temp, top);
			sortedInsert(s, temp, top);
		}
		return s;
	}

	public static void main(String[] args) {
		_07_SortStack obj = new _07_SortStack();

		Stack<Integer> s = new Stack<Integer>();
		s.push(41);
		s.push(3);
		s.push(32);
		s.push(2);
		s.push(11);
//		
//		s.push(1);
//		s.push(2);
//		s.push(3);

		System.out.println(sort(s, obj.temp, obj.top));
		System.out.println("top : " + s.peek());
	}
}