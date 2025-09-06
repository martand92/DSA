package DSA.Bucket2._05_slidingWindow;

//https://www.naukri.com/code360/problems/maximum-subarray-sum_630526
//https://www.youtube.com/watch?v=AHZpyENo7k4

//Find the sum of the subarray (including empty subarray) having maximum sum among all subarrays
//Note : The sum of an empty subarray is 0.
public class _03_01_MaxSumOfSubArr_Imp {

	public static int maxSumOfSubArr_Brute(int[] arr) {

		int sum = 0, maxSum = 0;

		for (int i = 0; i < arr.length; i++) {
			sum = 0;

			for (int j = i; j < arr.length; j++) {
				sum += arr[j];
				maxSum = Math.max(maxSum, sum);
			}
		}

		return maxSum;
		// TC : O(n^2), SC : O(1)
	}

	// Kadane's algo
	public static int maxSumOfSubArr_Opt(int[] arr) {

		int sum = 0, maxSum = Integer.MIN_VALUE;

		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			maxSum = Math.max(maxSum, sum);

			if (sum < 0)
				sum = 0;
		}

		return maxSum > 0 ? maxSum : sum; // if final maxSum < 0 then return 0
		// TC : O(n), SC : O(1)
	}

	public static void main(String[] args) {

		// int[] arr = { 1, 2, 7, -4, 3, 2, -10, 9, 1 };
		int[] arr = { -4, -2, -3, -1 };
		System.out.println(maxSumOfSubArr_Brute(arr));
		System.out.println(maxSumOfSubArr_Opt(arr));
	}

}
