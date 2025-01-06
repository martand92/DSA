package DSA._06_stacks;

//https://www.youtube.com/watch?v=gIrMptNPf5M
//https://leetcode.com/problems/sum-of-subarray-ranges/description/
public class _22_SumOfSubArrayRanges {

	public static int sumOfSubArrRanges_BruteForce(int[] arr) {

		int total = 0;

		for (int i = 0; i < arr.length; i++) {

			int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

			for (int j = i; j < arr.length; j++) {
				min = Math.min(arr[j], min);
				max = Math.max(arr[j], max);
				total += (max - min);
			}
		}
		return total;
	} // TC : O(N^2), SC : O(N)

	// find sum of min & max elements in all possible sub arrays using previous
	// methods and find final difference
	public static int sumOfSubArrRanges_Stack(int[] arr) {

		int maxSumOfAllSubArr = _21_02_SumOfSubArrMax.maxElementInSubArrSum_Stack(arr);
		int minSumOfAllSubArr = _21_01_SumOfSubArrMin.minElementInSubArrSum_Stack(arr);

		return maxSumOfAllSubArr - minSumOfAllSubArr;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 4, 3, 2 };
		System.out.println("sum of sub arr ranges using brute force : " + sumOfSubArrRanges_BruteForce(arr));
		System.out.println("sum of sub arr ranges using stack : " + sumOfSubArrRanges_Stack(arr));
	}

}
