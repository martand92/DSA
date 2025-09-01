package DSA.Bucket2._05_slidingWindow;

public class _05_01_LongestSubArrOfSumLessOrEqualToK {

	public static int longestSubArrOfSumLesserOrEqualToK(int[] arr, int k) {

		int windowSum = 0, longestSubArr = 0, l = 0;

		for (int r = 0; r < arr.length; r++) {

			windowSum += arr[r];

			while (windowSum > k) {
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

//TC : O(N + N). First to increase window size and second to shrink window size when condition is not met
//SC : O(1)