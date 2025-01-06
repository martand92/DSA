package DSA._03_hash.Medium;

import java.util.*;

//https://practice.geeksforgeeks.org/problems/three-sum-closest/1
public class _04_02_3Sum_FindTripletsWithGivenSum {

	public static void main(String[] args) {

		int[] arr = { 1, -1, -2, -3, 1 };
		int givenSum = 1;

		for (int i = 0; i < arr.length - 1; i++) {

			HashSet<Integer> s = new HashSet<Integer>();

			for (int j = i + 1; j < arr.length; j++) {

				if (s.contains(givenSum - (arr[i] + arr[j]))) {
					System.out.println(arr[i] + "," + arr[j] + "," + (givenSum - (arr[i] + arr[j])));
					return;
				} else
					s.add(arr[j]);
			}
		}

	}

}
