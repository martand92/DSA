package DSA.Bucket2._05_slidingWindow;

//When Window condition is not met, no need to shrink more than max window size already found as you need to check for only higher window size and not smaller
//Hence instead of while() shrink only once to get back to prev largest window and check for next windows that would either provide larger or same window size satisfying condition

//This optimization is only valid when need to return length but not for returning array
public class _05_02_LongestSubArrOfSumLessOrEqualToK_Opt_Imp {

	public static int longestSubArrOfSumLesserOrEqualToK(int[] arr, int k) {

		int windowSum = 0, longestSubArr = 0, l = 0;

		for (int r = 0; r < arr.length; r++) {

			windowSum += arr[r];

			if (windowSum > k) { // replacing while with if as prev window found is already largest
				windowSum -= arr[l];
				l++;
			}

			longestSubArr = Math.max(longestSubArr, r - l + 1);
		}

		return longestSubArr;
	}

	public static void main(String[] args) {

		int[] arr = { 2, 5, 1, 7, 10 };
		int k = 14;

		System.out.println(longestSubArrOfSumLesserOrEqualToK(arr, k));
	}

}
//TC : O(N). Only to increase window size and traverse through all elements
//SC : O(1)