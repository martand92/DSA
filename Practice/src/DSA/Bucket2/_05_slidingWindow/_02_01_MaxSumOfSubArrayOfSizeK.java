package DSA.Bucket2._05_slidingWindow;

//https://practice.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1
public class _02_01_MaxSumOfSubArrayOfSizeK {

	public static void main(String[] args) {

		int[] arr = { 100, 200, 300, 400 };
		int k = 2; // fixed window size

		int l = 0, maxSum = 0, sum = 0;

		for (int r = 0; r < arr.length; r++) {

			sum += arr[r];

			if (r - l + 1 == k) { // window size breached
				maxSum = Math.max(sum, maxSum);
				sum -= arr[l];
				l++;
			}
		}

		System.out.println(maxSum);
	}

}
