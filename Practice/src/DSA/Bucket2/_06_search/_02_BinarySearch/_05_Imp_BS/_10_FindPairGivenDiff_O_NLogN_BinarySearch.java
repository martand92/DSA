package DSA.Bucket2._06_search._02_BinarySearch._05_Imp_BS;

import java.util.Arrays;

//https://practice.geeksforgeeks.org/problems/find-pair-given-difference1559/1
public class _10_FindPairGivenDiff_O_NLogN_BinarySearch {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 6, 3, 4 };
		int n = 0;
		boolean found = false;

		Arrays.sort(arr);

		// O(N)
		for (int i = 0; i < arr.length - 1; i++) {

			int l = i + 1, r = arr.length - 1;
			int key = arr[i] + n;

			// O log(N)
			while (l <= r) {

				int mid = l + (r - l) / 2;

				if (key == arr[mid])
					found = true;

				else if (key < arr[mid])
					r = mid - 1;

				else
					l = mid + 1;
			}

		}

		System.out.println(found);
	}
}
