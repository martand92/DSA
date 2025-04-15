package DSA.Bucket3._06_stacks;

//https://youtu.be/Bzat9vgD0fs?list=PLgUwDviBIf0pOd5zvVVSzgpo6BaCpHT9c&t=994
import java.util.*;

public class _24_02_LargesttRactangleInHistogram_Opt {

	public static int findLongestRectangleArea(int[] arr) {

		Stack<Integer> st = new Stack<Integer>(); //SC : O(N)
		int[] pse = new int[arr.length]; //SC : O(N)
		int maxArea = 0;

		// for arr[i], pse can be found but nse will be found only during popping out
		// stack elements. Hence final area of arr[i] can be found during popping out of
		// elements from stack when nse is found

		for (int i = 0; i < arr.length; i++) { //TC : O(N)

			while (!st.isEmpty() && arr[i] <= arr[st.peek()]) { //TC : O(N)

				// Now st.peek()'s area could be found as its pse is already computed and nse =
				// arr[i]
				int index = st.pop();
				maxArea = Math.max(maxArea, arr[index] * (i - pse[index] - 1)); // here arr[i] is nse of st.peek()
			}

			if (st.isEmpty())
				pse[i] = -1;
			else
				pse[i] = st.peek();

			st.push(i);
		}
		
		return maxArea;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 1, 5, 6, 2, 3 };
		System.out.println(findLongestRectangleArea(arr));
	}

}
