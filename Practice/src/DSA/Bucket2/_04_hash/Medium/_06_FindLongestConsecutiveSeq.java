package DSA.Bucket2._04_hash.Medium;

import java.util.HashSet;
import java.util.TreeSet;

public class _06_FindLongestConsecutiveSeq {

	public static int longestConsecutiveSeq_Better(int[] arr) {

		// Intuition : If you find minimal number in consecutive seq and count all its
		// next numbers, then find highest consecutive seq of all available consecutive
		// seq

		// Algo :
		// first add all available numbers to hashSet
		// start re-iterating array and check if current element is the lowest in
		// consecutive seq by checking if lower number exists
		// if lower number exists then don't do anything and move to next array element.
		// If lower element is not found then current element should be the lowest in
		// consecutive seq
		// then count if all next elements are present in hs till no next element is
		// found.
		// take max count of multiple consecutive sub sequences to provide result

		// ---Further optimization---
		// Once all elements are added to hashset, no need to iterate over array
		// elements again as you are interested in minimum num,
		// instead you can iterate over hashset to avoid iterating over duplicates
		// Ex: Let's take a test case: [3,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1]
		// While loop won't execute for 3 & 2 since 1 is present. But while loop will be
		// executed for 1 since 0 is not present, and that will be executed (n-2) times
		// here.
		// instead of iterating over arr which consists repeated elements, we can
		// iterate over hashset then for 1 it will execute while loop only once
		// resulting time complexity O(n) + O(n)

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
	public static int longestConsecutiveSeq_Opt(int[] arr) {

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

	public static void main(String[] args) {

		int[] arr = { 102, 4, 100, 1, 101, 3, 2 };
		// int[] arr = { 100, 102, 100, 101, 101, 4, 3, 2, 3, 2, 1, 1, 1, 2 };
		// int[] arr = { 15, 6, 2, 1, 16, 4, 2, 29, 9, 12, 8, 5, 14, 21, 8, 12, 17, 16,
		// 6, 26, 3 };
		// int[] arr = { 1, 3, 5, 7 };

		System.out.println(longestConsecutiveSeq_Better(arr));
		System.out.println(longestConsecutiveSeq_Opt(arr));
	}
}
