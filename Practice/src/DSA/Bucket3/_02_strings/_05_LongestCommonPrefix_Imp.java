package DSA.Bucket3._02_strings;

import java.util.Arrays;

//https://practice.geeksforgeeks.org/problems/longest-common-prefix-in-an-array5129/1
public class _05_LongestCommonPrefix_Imp {

	public static int longestCommonPrefix(String[] arr) {
		//Sorting lexicographically
		Arrays.sort(arr); // O(nlogn)

		int count = 0, n = arr.length - 1;
		int len = Math.min(arr[0].length(), arr[n].length());

		for (int i = 0; i < len; i++) { // O(max(S))
			if (arr[0].charAt(i) != arr[n].charAt(i))
				return count;
			count++;
		}
		
		return count;
	}

	public static void main(String[] args) {

		String[] arr = { "geeksforgeeks", "geeks", "geek", "geezer" };
		System.out.println(longestCommonPrefix(arr));

	}
}

//TC : O(nlogn + max(S))