package DSA.Bucket2._05_slidingWindow;

//https://www.youtube.com/watch?v=XnMdNUkX6VM
//https://leetcode.com/problems/binary-subarrays-with-sum/description/

/* Here the problem is to count all sub arrays satisfying window condition. 
 * If you follow traditional way of increasing / shrinking window based on condition then all sub arrays cannot be considered.
 * Hence this problem should be re-written as count all subarray satisfying sum <= goal (x) and satisfying sum <= goal - 1 (y)
 * Now to get all subarray count satisfying sum=goal, do x - y
 */

//This can also be solved using hashmap + prefixSum : hash._04_CountSubArraysWithSumK_imp
public class _11_CountSubArrWithGivenSum {

	// finding all sub arrays with sum = given goal
	public static int countBinarySubArraysWithSumAsGoal(int[] nums, int goal) {

		int l = 0, count = 0, sum = 0;

		// here you are calculating all the sub arrays <= goal
		for (int r = 0; r < nums.length; r++) { // O(N)
			sum += nums[r];

			// when sum of current window exceeds goal then shrink
			while (sum > goal) {// O(N)
				sum -= nums[l];
				l++;
			}

			count += r - l + 1; // all sub arrays from l to r should be counted that matches goal
		}

		return count;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 0, 0, 1, 1, 0 };
		int goal = 2;

		// to get (count of all subarrays whose sum = goal) do,
		// (count of all subarrays whose sum <= goal - count of all subarrays whose sum
		// <= goal -1)
		int count1 = countBinarySubArraysWithSumAsGoal(nums, goal);
		int count2 = countBinarySubArraysWithSumAsGoal(nums, goal - 1);
		System.out.println(count1 - count2);
	}
}

//TC : O(2*2N) //since calling func() twice
//SC : O(1)