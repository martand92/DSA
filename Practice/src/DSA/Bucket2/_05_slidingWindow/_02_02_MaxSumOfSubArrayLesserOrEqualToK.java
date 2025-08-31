package DSA.Bucket2._05_slidingWindow;

//https://practice.geeksforgeeks.org/problems/maximum-sum-of-subarray-less-than-or-equal-to-x4033/1
//Here window size is not fixed

//You might think of solution based on finding min difference between currSum & givenSum and checking if prev found sum or currSum is the nearest
//Above logic works if array elements contains negative elements, but here elements are all positive. 
//Hence only check if currSum is nearing to givenSum or exactly equal as you go traverse adding elements to sum and if crossed then reduce window. 

public class _02_02_MaxSumOfSubArrayLesserOrEqualToK {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 4, 5 }; // need not be sorted
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
