package DSA.Bucket2._01_arrays._04_search._02_BinarySearch._05_Imp_BS;

import java.util.*;

//https://practice.geeksforgeeks.org/problems/find-pair-given-difference1559/1
public class _10_FindPairGivenDiff_O_N_Hash {

	public static void main(String[] args) {

		// int[] arr = { 1, 2, 6, 3, 4 };
		int[] arr = { 90, 70, 20, 80, 50};
		int n = 45;
		HashSet<Integer> hs = new HashSet<Integer>();

		for (int i = 0; i < arr.length; i++) {

			if (hs.contains(Math.abs(n - arr[i]))) {
				System.out.println(true);
				return;
			}

			hs.add(arr[i]);

		}

		System.out.println(false);
	}
}
