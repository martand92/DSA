package DSA.Bucket2._01_arrays._02_slidingWindow;

//https://practice.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1
public class _02_01_MaxSumOfSubArray_OfSizeK_O_N {

	public static void main(String[] args) {

		int[] arr = { 100, 200, 300, 400 };
		int k = 2; // fixed window size

		int l = 0, maxSum = 0, sum = 0, count = k;

		for (int r = 0; r < arr.length; r++) {
			sum += arr[r];
			count--;

			if (count < 0) {
				sum -= arr[l];
				l++;
				count++;
			}

			maxSum = Math.max(maxSum, sum);
		}

		System.out.println(maxSum);
	}

}
