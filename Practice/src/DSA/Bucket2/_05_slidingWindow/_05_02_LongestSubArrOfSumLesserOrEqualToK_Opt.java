package DSA.Bucket2._05_slidingWindow;

//Here when you find length of window satisfying condition and make it max window size, 

//If you then start to shrink window size when condition is not met for window, then no need to shrink more than max window size already found 
//cz you need to check for only higher window size and not smaller

//Hence instead of inner while loop to shrink, shrink only once to get back valid window and check for next windows that would either provide larger or same window size satisfying condition

//This optimization is only valid when need to return length but not for returning array
public class _05_02_LongestSubArrOfSumLesserOrEqualToK_Opt {

	public static int longestSubArrOfSumLesserOrEqualToK(int[] arr, int k) {

		int windowSum = 0;
		int longestSubArr = 0;
		int subArrSize = 0;
		int left = 0;

		for (int right = 0; right < arr.length; right++) {

			windowSum += arr[right];
			subArrSize++;

			if (windowSum > k) { // replacing while with if to shrink only by 1 as previous window found is
									// already largest
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
//TC : O(N). Only to increase window size and traverse through all elements
//SC : O(1)