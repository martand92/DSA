package DSA.Bucket2._01_arrays._01_basic;

import java.util.Arrays;

//https://www.youtube.com/watch?v=JDOXKqF60RQ
//https://www.naukri.com/code360/problems/next-greater-permutation_6929564

//Intuition :
//Next permutation element will have longest prefix match
//Find highest element on right (i.e, 5) whose prev is lower than this highest (i.e 1). 
//Now from prev (i.e, 1) till the end can be considered to find next array in sorted permutation seq  
//To find next greater element, need to find next greater element of 1 to swap with 
//Above step will result in 2,3,5,4,1,0,0
//Now to get next permutation, sort all nums after swapped index -> 2,3,0,0,1,4,5

public class _19_NextPermutation_imp {

//  Find all permutations using recursion in arrange in ascending order and then check for next of given num from seq
//	public static int[] nextPermutationNum_Brute(int[] arr) {
//
//	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static int[] nextPermutationNum_Opt(int[] arr) {

		// Step 1 : Find highest element on right whose prev is lower
		int highestIndex = -1;

		for (int i = arr.length - 1; i > 0; i--) {

			if (arr[i - 1] < arr[i])
				highestIndex = i;
		}

		// then given array is itself last occurrence in permutation, then return first
		// occurrence of this permutation
		if (highestIndex == -1) {
			Arrays.sort(arr);
			return arr;
		}

		// Step 2 : find next greater element of previous (1) to swap with
		int ngeIndex = -1;
		int minDiff = Integer.MAX_VALUE;

		for (int i = highestIndex; i < arr.length; i++) {
			if (arr[i] > arr[highestIndex - 1] && Math.abs(arr[i] - arr[highestIndex - 1]) < minDiff) {
				minDiff = Math.abs(arr[i] - arr[highestIndex - 1]);
				ngeIndex = i;
			}
		}
		swap(arr, highestIndex - 1, ngeIndex);

		// Step 3 : sort from highestIndex to end in ascending order
		Arrays.sort(arr, highestIndex, arr.length);
		return arr;

	}

	public static void main(String[] args) {
		int[] arr = { 2, 1, 5, 4, 3, 0, 0 };
		System.out.println(Arrays.toString(nextPermutationNum_Opt(arr)));
	}

}
