package DSA.Bucket3._06_stacks;

import java.util.*;

//https://www.youtube.com/watch?v=NdDIaH91P0g

//Need to get Min in given stack in O(1)
public class _12_02_MinStack_Imp {

	public static class Data {
		int key;
		int val;

		Data(int key, int val) {
			this.key = key;
			this.val = val;
		}
	}

	public static void push(Stack<Data> st, int d) {
		if (st.isEmpty())
			st.push(new Data(d, d));

		st.push(new Data(d, Math.min(d, st.peek().val))); // check if current val is min or already existing val in st
	}

	public static int getMin(Stack<Data> st) {
		if (st.isEmpty())
			return -1;
		else
			return st.peek().val;
	}

	public static int pop(Stack<Data> st) {
		return st.pop().key;
	}

	public static int top(Stack<Data> st) {
		return st.peek().key;
	}

	public static void main(String[] args) {

		Stack<Data> st = new Stack<Data>();
		push(st, 12);
		push(st, 15);
		push(st, 10);
		System.out.println("Current min:" + getMin(st)); // return 10
		System.out.println("Popped:" + pop(st)); // 10 is taken out
		System.out.println("Stack top:" + top(st)); // top is 15
		System.out.println("Current min:" + getMin(st)); // this should return 12 though top is 15 in O(1)
	}
}

//TC : O(1)
//SC : O(2N) . To store pair of data in stack 
