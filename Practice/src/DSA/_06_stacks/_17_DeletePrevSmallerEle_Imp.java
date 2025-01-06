package DSA._06_stacks;

import java.util.*;

//https://practice.geeksforgeeks.org/problems/delete-array-elements-which-are-smaller-than-next-or-become-smaller3115/1
public class _17_DeletePrevSmallerEle_Imp {

	public static void main(String[] args) {
		int[] arr = { 12, 7, 11, 5, 20, 15, 15, 7, 10 };
		int k = 5;

		Stack<Integer> st = new Stack<Integer>();
		ArrayList<Integer> al = new ArrayList<Integer>();

		for (int a : arr)
			al.add(a);

		for (int i = 0; i < arr.length; i++) {

			if (st.isEmpty() || st.peek() > arr[i])
				st.push(arr[i]);

			else {
				while (!st.isEmpty() && k != 0 && st.peek() < arr[i]) {
					al.remove(st.pop());
					k--;
				}
				st.push(arr[i]);
			}

			if (k == 0)
				break;
		}

		System.out.println(al);

	}

}
