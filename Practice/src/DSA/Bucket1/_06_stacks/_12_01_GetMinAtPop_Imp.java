package DSA.Bucket1._06_stacks;

import java.util.*;

//https://practice.geeksforgeeks.org/problems/get-min-at-pop/1
public class _12_01_GetMinAtPop_Imp {

	static ArrayList<Integer> al = new ArrayList<Integer>();

	public static void main(String[] args) {

		int[] arr = { 1, 6, 43, 1, 2, 0, 5 };
		Stack<Integer> st = new Stack<Integer>();

		st.push(arr[0]);

		// Check if arr[i] is lesser than Stack peek
		// If less then push arr[i] to stack else copy stack peek & push to stack
		for (int i = 1; i < arr.length; i++) {

			if (st.peek() > arr[i])
				st.push(arr[i]);
			else
				st.push(st.peek());

		}

		System.out.println(st);
	}
}
