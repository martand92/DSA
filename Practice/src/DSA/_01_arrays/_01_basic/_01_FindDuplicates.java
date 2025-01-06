package DSA._01_arrays._01_basic;

import java.util.*;

public class _01_FindDuplicates {

	public static void findDup_Brute(int[] arr) {

		HashSet<Integer> hs = new HashSet<Integer>(); // SC : O(N)

		for (int i = 0; i < arr.length; i++) {// TC : O(N)
			if (!hs.add(arr[i]))//logn
				System.out.print(arr[i] + " ");
		}

		// if no duplicates are found the return -1
		if (hs.size() == arr.length)
			System.out.println(-1);
		
		System.out.println();

		// TC : O(nlogn)
		// SC : O(n)
	}

	public static void findDup_Opt(int[] arr) {

		Arrays.sort(arr);// O(nlogn)
		
		for (int i = 1; i < arr.length; i++) { // O(n)
			
			if (arr[i] == arr[i - 1])
				System.out.print(arr[i] + " ");

		}
		// TC : O(nlogn + n)
		// SC : O(1)
	}

	public static void main(String[] args) {
		int[] arr = { 0, 3, 1, 2, 3, 2 };
		findDup_Brute(arr);
		findDup_Opt(arr);
	}

}
