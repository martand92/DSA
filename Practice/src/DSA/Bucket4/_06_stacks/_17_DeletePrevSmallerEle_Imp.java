package DSA.Bucket4._06_stacks;

import java.util.*;

//https://practice.geeksforgeeks.org/problems/delete-array-elements-which-are-smaller-than-next-or-become-smaller3115/1
public class _17_DeletePrevSmallerEle_Imp {

	public static void main(String[] args) {
		int[] arr = { 12, 7, 11, 5, 20, 15, 15, 7, 10 };
		int k = 5;

//		int[] arr = { 20, 10, 25, 30, 40 };
//		int k = 2;

		Stack<Integer> st = new Stack<Integer>();
		int i = 0;

		while (i < arr.length) {

			if (k == 0 || st.isEmpty() || st.peek() >= arr[i]) {
				st.push(arr[i]);
				i++;
			}

			else if (k > 0 || st.peek() < arr[i]) {
				st.pop();
				k--;
			}

		}

		System.out.println(st);

	}
}