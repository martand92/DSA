package DSA.Bucket2._06_hash.Medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeSet;

public class _06_FindLongestConsecutiveSeq_Imp {

	public static int longestConsecutiveSeq_Good(int[] arr) {

		// Intuition : If you find minimal number in consecutive seq and count all its
		// next numbers, then find highest consecutive seq of all available consecutive
		// seq

		HashSet<Integer> hs = new HashSet<Integer>(); // O(n)
		int maxCount = 0, count = 0;

		for (int i : arr) // O(n)
			hs.add(i); // O(logn)

		for (int i : hs) {// O(n)

			if (!hs.contains(i - 1)) { // O(log n)
				int num = i;
				while (hs.contains(num)) {// O(nlogn)
					count++;
					num += 1;
				}
				maxCount = Integer.max(maxCount, count);
				count = 0;
			}
		}

		return maxCount;
		// TC : O(nlogn + nlogn + nlogn) ~ O(3nlogn)
		// SC : O(n)

	}

	// https://www.youtube.com/watch?v=oO5uLE7EUlM
	// https://www.naukri.com/code360/problems/longest-successive-elements_6811740
	public static int longestConsecutiveSeq_Better(int[] arr) {

		TreeSet<Integer> ts = new TreeSet<Integer>();// O(n)
		for (int i = 0; i < arr.length; i++)// O(nlogn)
			ts.add(arr[i]);

		int maxLength = 0, prev = Integer.MIN_VALUE, currLength = 0;

		for (int num : ts) { // O(n)

			if (prev == Integer.MIN_VALUE || num != prev + 1)
				currLength = 1;
			else
				currLength++;

			maxLength = Math.max(maxLength, currLength);
			prev = num;
		}

		return maxLength;

		// TC : O(nlogn + n)
		// SC : O(n)
	}

	public static int longestConsecutiveSeq_Opt(int[] arr) {

		int maxLength = 0, count = 1;
		Arrays.sort(arr);

		for (int i = 1; i < arr.length; i++) {

			if (arr[i] != arr[i - 1]) {

				if (arr[i] == arr[i - 1] + 1)
					count++;
				else
					count = 1;
			}

			maxLength = Math.max(maxLength, count);
		}

		return maxLength;

		// TC : O(nlogn + n)
		// SC : O(1)
	}

	public static void main(String[] args) {

		// int[] arr = { 102, 4, 100, 1, 101, 3, 2 };
		int[] arr = { 100, 102, 100, 101, 101, 4, 3, 2, 3, 2, 1, 1, 1, 2 };
		// int[] arr = { 15, 6, 2, 1, 16, 4, 2, 29, 9, 12, 8, 5, 14, 21, 8, 12, 17, 16,
		// 6, 26, 3 };
		// int[] arr = { 1, 3, 5, 7 };

		System.out.println(longestConsecutiveSeq_Good(arr));
		System.out.println(longestConsecutiveSeq_Better(arr));
		System.out.println(longestConsecutiveSeq_Opt(arr));
	}
}
