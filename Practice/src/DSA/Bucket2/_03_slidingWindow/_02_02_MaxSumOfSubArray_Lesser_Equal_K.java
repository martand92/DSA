package DSA.Bucket2._03_slidingWindow;

//https://practice.geeksforgeeks.org/problems/maximum-sum-of-subarray-less-than-or-equal-to-x4033/1
//Here window size is not fixed
public class _02_02_MaxSumOfSubArray_Lesser_Equal_K {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 4, 5 };
		// int[] arr = { 2, 4, 6, 8, 10 };

		int sum = 10;

		int l = 0;
		long currSum = 0, max = 0;

		for (int r = 0; r < arr.length; r++) {

			currSum += arr[r];

			while (currSum > sum) {// using while() to reduce currsum within target
				currSum -= arr[l];
				l++;
			}

			max = Math.max(max, currSum); // to check if initially found sum is greater than current sum

		}

		System.out.println(max);
	}

}
