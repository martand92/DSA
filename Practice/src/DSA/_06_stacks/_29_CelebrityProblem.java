package DSA._06_stacks;

import java.util.*;

//https://www.youtube.com/watch?v=cEadsbTeze4
//https://www.geeksforgeeks.org/problems/the-celebrity-problem/1
public class _29_CelebrityProblem {

	public static int findCelebrity(int[][] mat) {

		Stack<Integer> st = new Stack<Integer>();

		// first add all the people to stack
		for (int i = 0; i < mat.length; i++)
			st.push(i);

		while (st.size() > 1) {

			int person1 = st.pop();
			int person2 = st.pop();

			if (mat[person1][person2] == 1)// if person1 knows person2 then person1 is not celebrity
				st.push(person2); // hence add person2 back to stack and removing person1 from further checks
			else
				st.push(person1); // else add person1 back to stack to further check if he/she is celebrity
		} // Once this loop ends, then left over person/index could be celebrity

		int celebrity = st.pop();

		// now further check if person is celebrity by checking if he/she doesn't know
		// anyone and all others should know him/her

		// first check if this person knows others
		for (int i = 0; i < mat[0].length; i++)
			if (mat[celebrity][i] == 1)// means this person knows others hence this person is not celebrity
				return -1;

		for (int i = 0; i < mat.length; i++)
			if (i != celebrity && mat[i][celebrity] == 0)// means all other doesn't know this person hence this person
															// is not celebrity
				return -1;

		return celebrity;// means this person is indeed celebrity where he/she doesn't know anyone but
					// all others know him/her
	}

	public static void main(String[] args) {

		int[][] mat = { { 0, 1, 0 }, { 0, 0, 0 }, { 0, 1, 0 } };
		System.out.println(findCelebrity(mat));
	}

}

//TC : O(3N)
//SC : O(N)