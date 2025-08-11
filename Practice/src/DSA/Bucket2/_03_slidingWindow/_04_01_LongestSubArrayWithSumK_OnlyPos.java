package DSA.Bucket2._03_slidingWindow;

//Below solution will not work if array contains negative nums
public class _04_01_LongestSubArrayWithSumK_OnlyPos {

	public static int longestSubArr(int[] arr, int k) {
		int l = 0, maxLength = 0, sum = 0;
		
		for (int r = 0; r < arr.length; r++) {
			sum += arr[r];
			
			while (sum > k) {
				sum -= arr[l];
				l++;
			}

			if (sum == k)
				maxLength = Math.max(maxLength, r - l + 1);
		}

		return maxLength;
		// TC : O(n + n), first to increase window and then to shrink window
		// SC : O(1)
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 1, 1, 1, 4, 2, 3 };
		int k = 3;
		// int[] arr = { 2, 0, 0, 3 };
		// int k = 3;
		System.out.println(longestSubArr(arr, k));
	}
}
