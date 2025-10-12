package DSA.Bucket2._08_search._02_BinarySearch._05_BS;

import java.util.Arrays;
import java.util.HashSet;

//https://practice.geeksforgeeks.org/problems/find-pair-given-difference1559/1
public class _10_CheckPairExistsWithGivenDiff_Imp {

	public static boolean doesPairExist_hash(int[] arr, int n) {

		// 2 possibilities exists to be checked
		// a-b=n : a=b+n
		// b-a=n : a=b-n

		HashSet<Integer> hs = new HashSet<Integer>();

		for (int i = 0; i < arr.length; i++) {

			if (hs.contains(n + arr[i]) || hs.contains(arr[i] - n))
				return true;

			hs.add(arr[i]);
		}

		return false;
	} // O(n)

	public static boolean doesPairExist_BS(int[] arr, int n) {

		Arrays.sort(arr);

		for (int i = 0; i < arr.length - 1; i++) {

			int l = i + 1, r = arr.length - 1;
			int key = n + arr[i];

			while (l <= r) {

				int mid = l + (r - l) / 2;

				if (key == arr[mid])
					return true;
				else if (key < arr[mid])
					r = mid - 1;
				else
					l = mid + 1;
			}

		}

		return false;
	} // O(nlogn)

	public static void main(String[] args) {

		int[] arr = { 1, 2, 6, 3, 4 };
		int n = 0;

		System.out.println(doesPairExist_hash(arr, n));
		System.out.println(doesPairExist_BS(arr, n));
	}
}