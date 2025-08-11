package DSA.Bucket2._01_arrays;

import java.util.*;

//https://www.youtube.com/watch?v=cHrH9CQ8pmY
//https://www.naukri.com/code360/problems/superior-elements_6783446

//Algo : start tracing from right, last element is always leader and store it as max element.
//Continue to trace to left and check if current element is greater than max, if yes then its leader and update max as current
public class _18_LeadersInArray_imp { // or Superior element

	public static List<Integer> leaderElements(int[] arr) {

		List<Integer> al = new ArrayList<Integer>();
		int max = arr[arr.length - 1];
		al.add(max);

		for (int i = arr.length - 2; i >= 0; i--) {

			if (arr[i] > max) {
				max = arr[i];
				al.add(max);
			}
		}

		return al;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 2 };
		System.out.println(leaderElements(arr));
	}
}
