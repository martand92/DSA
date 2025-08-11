package DSA.Bucket2._01_arrays;

import java.util.*;

//O(N)
public class _05_FirstRepeatingElement_imp {

	public static int firstRepeating_Approach2(int[] arr) {

		LinkedHashMap<Integer, Integer> lhm = new LinkedHashMap<Integer, Integer>();

		for (int i = 0; i < arr.length; i++) // O(n)
			lhm.put(arr[i], lhm.getOrDefault(arr[i], 0) + 1); // O(logn)

		for (Map.Entry<Integer, Integer> e : lhm.entrySet()) { // O(nlogn)
			if (e.getValue() > 1)
				return e.getKey();
		}

		return Integer.MIN_VALUE;
		// TC : O(nlogn + nlogn)
		// SC : O(n)
	}

	public static boolean binarySearch(int ele, int[] temp) {

		int l = 0, r = temp.length - 1, mid = 0;

		while (l <= r) {

			mid = l + (r - l) / 2;

			if (temp[mid] == ele) {

				if (mid - 1 > 0 && temp[mid - 1] == ele)
					return true;
				
				else if (mid + 1 < temp.length && temp[mid + 1] == ele)
					return true;

				return false;

			} else if (ele < temp[mid])
				r = mid - 1;

			else
				l = mid + 1;
		}

		return false;
	}

	public static int firstRepeating_Approach1(int[] arr) {

		int[] temp = new int[arr.length]; // O(n)
		for (int i = 0; i < arr.length; i++) // O(n)
			temp[i] = arr[i];

		Arrays.sort(temp); // O(nlogn)

		for (int i = 0; i < arr.length; i++) {// O(n)
			if (binarySearch(arr[i], temp))// O(logn)
				return arr[i];
		}

		return Integer.MIN_VALUE;
		// TC : O(n + nlogn + nlogn)
		// SC : O(n)
	}

	public static void main(String[] args) {
		int[] arr = { 1, 5, 3, 4, 3, 5, 6 };
		System.out.println(firstRepeating_Approach2(arr));
		System.out.println(firstRepeating_Approach1(arr));
	}

}
