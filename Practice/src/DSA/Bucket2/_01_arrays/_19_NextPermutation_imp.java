package DSA.Bucket2._01_arrays;

import java.util.Arrays;

//https://www.youtube.com/watch?v=JDOXKqF60RQ
//https://www.naukri.com/code360/problems/next-greater-permutation_6929564

// Intuition :
// Next permutation will be greater than current given permutation. So whole algo is to find greater permutation but closest 
// Step 1 : How to find greater permutation than current?
// Finding highest element from right whose prev is less than this highest(ex: 5 in given input array). This breakpoint provides option to find next permutation
// As next permutation should be greater than current anything right to this breakpoint will not yield in next higher permutation
// Ex: if we consider element 4, then any combination of elements from 4 -> end of array will all yield permutation lesser and not next/greater permutation
// So right of prev to breakpoint element(here 1) will result in next greater permutation with shuffling elements from 5 -> end accordingly

// Step 2 : How to find just next greater permutation than current?
// Now we have left of breakpoint (here 1) and right of it could be shuffled to result in permutation seq greater than current
// Now we need right next permutation. So need to find element on right which is greater & nearest to 1 i.e, 3
// Now need to swap 1 with 3 to result in higher permutation -> {2, 3, 5, 4, 1, 0, 0}
// But we also need just next permutation, hence need to arrange elements on right from break point such that its lowest
// Hence sort elements to right resulting in {2, 3, 0, 0, 1, 4, 5}

public class _19_NextPermutation_imp {

//  Find all permutations using recursion in asc order, then check for next given num from seq
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

			if (arr[i - 1] < arr[i]) {
				highestIndex = i;
				break;
			}
		}

		// then given array is itself last occurrence in permutation, then return first
		// occurrence of this permutation
		if (highestIndex == -1) {
			Arrays.sort(arr);// first occurrence will be simple ordered array
			return arr;
		}

		// Step 2 : find next greater element of element left to breaking point by
		// looping from rightmost
		// This works because elements on right are all increasing in nature
		for (int i = arr.length - 1; i > highestIndex; i--) {
			if (arr[i] > arr[highestIndex - 1]) {
				swap(arr, highestIndex - 1, i);
				break;
			}
		}

		// Step 3 : sort(asc) from breaking point to rightmost. But as elements from
		// breakpoint to right most is already sorted in desc order, you just need to
		// reverse it
		int l = highestIndex;
		int r = arr.length - 1;
		while (l < r) {
			swap(arr, l, r);
			l++;
			r--;
		}

		return arr;

	}

	public static void main(String[] args) {
		int[] arr = { 2, 1, 5, 4, 3, 0, 0 };
		System.out.println(Arrays.toString(nextPermutationNum_Opt(arr)));
	}

}
