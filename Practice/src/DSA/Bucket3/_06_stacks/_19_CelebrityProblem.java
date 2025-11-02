package DSA.Bucket3._06_stacks;

import java.util.*;

//https://www.youtube.com/watch?v=cEadsbTeze4
//https://www.geeksforgeeks.org/problems/the-celebrity-problem/1
public class _19_CelebrityProblem {

	public static int findCelebrity(int[][] mat) {

		Stack<Integer> st = new Stack<Integer>();

		// first add all the people to stack
		for (int i = 0; i < mat.length; i++)
			st.push(i);

		while (st.size() > 1) {

			int person1 = st.pop();
			int person2 = st.pop();

			if (mat[person1][person2] == 1)// if person1 knows person2 then person1 is not celebrity
				st.push(person2); // hence add person2 back for further checks
			else
				st.push(person1); // else add person1 back for further checks

		} // At the end, only 1 person will be left, need to check if he is celebrity

		int celebrity = st.pop();

		// now further check if person is celebrity by checking if he/she doesn't know
		// anyone and all others should know him/her

		// first check if this person knows others except himself
		for (int i = 0; i < mat[0].length; i++)
			if (celebrity != i && mat[celebrity][i] == 1)
				return -1;

		// Then check if all others know him. If any 1 person doesn't know him then he
		// is not celebrity
		for (int i = 0; i < mat.length; i++)
			if (i != celebrity && mat[i][celebrity] == 0)
				return -1;

		return celebrity;
	}

	public static void main(String[] args) {

		int[][] mat = { { 0, 1, 0 }, { 0, 1, 0 }, { 0, 1, 0 } };
		System.out.println(findCelebrity(mat));
	}

}

//TC : O(3N)
//SC : O(N)