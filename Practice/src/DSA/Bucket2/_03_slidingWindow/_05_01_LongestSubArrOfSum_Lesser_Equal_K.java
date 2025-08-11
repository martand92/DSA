package DSA.Bucket2._03_slidingWindow;

public class _05_01_LongestSubArrOfSum_Lesser_Equal_K {

	public static int longestSubArrOfSumLesserOrEqualToK(int[] arr, int k) {

		int windowSum = 0;
		int longestSubArr = 0;
		int subArrSize = 0;
		int left = 0;

		for (int right = 0; right < arr.length; right++) {

			windowSum += arr[right];
			subArrSize++;

			while (windowSum > k) {
				windowSum -= arr[left];
				left++;
				subArrSize--;
			}

			longestSubArr = Math.max(longestSubArr, subArrSize);
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