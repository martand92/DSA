package DSA._06_stacks;

import java.util.*;

//https://www.youtube.com/watch?v=_eYGqw_VDR4

//Rules :
//Positive integer says aestroid with this weight moving in right direction
//Negative integer says aestroid with this abs weight moving in left direction
//If positive and negative collide then aestroid with higher weight destroys lower weighted
//if both have same weight, both gets destroyed

public class _23_AestroidCollision {

	public static ArrayList<Integer> aestroidCollisionState(int[] arr) {

		ArrayList<Integer> result = new ArrayList<Integer>();
		Stack<Integer> st = new Stack<Integer>();

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] >= 0)
				st.push(arr[i]);

			else { // if arr[i] < 0

				// if arr[i] is negative and abs greater than st.peek() then this arr[i] will
				// destroy st.peek()
				while (!st.isEmpty() && arr[i] < 0 && st.peek() > 0 && Math.abs(arr[i]) > st.peek())
					st.pop();

				// if both arr[i] && st.peek() are equal weight and in opposite direction then
				// both get destroyed
				if (!st.isEmpty() && Math.abs(arr[i]) == st.peek())
					st.pop();

				// if st.peek() < 0 then push current arr[i]
				if (st.isEmpty() || st.peek() < 0)
					st.push(arr[i]);

			}

		}

		while (!st.isEmpty())
			result.add(st.pop());

		return result;

	}

	public static void main(String[] args) {
		int[] arr = { 4, 7, 1, 1, 2, -3, -7, 17, 15, -16 };
		System.out.println(aestroidCollisionState(arr));
	}

}
