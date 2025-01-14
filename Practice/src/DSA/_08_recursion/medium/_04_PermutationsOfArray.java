package DSA._08_recursion.medium;

import java.util.ArrayList;
import java.util.Arrays;

//https://www.youtube.com/watch?v=f2ic2Rsc9pU
public class _04_PermutationsOfArray {

	public static ArrayList<String> permutation(int[] arr, int i, int j, ArrayList<String> result) {

		if (i == arr.length || j == arr.length)
			return result;

		if (i == arr.length - 1 && j == arr.length - 1) {
			result.add(Arrays.toString(arr));
			return result;
		}

		swap(arr, i, j);
		permutation(arr, i + 1, i + 1, result);
		permutation(arr, i, j + 1, result);
		swap(arr, i, j);// reverting array to original seq before backtracking as arr updates based on
						// reference. Hence it persists changes

		return result;

	}

	public static int[] swap(int[] arr, int i, int j) {

		if (i == j)
			return arr;

		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;

		return arr;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3 };
		System.out.println(permutation(arr, 0, 0, new ArrayList<String>()));
	}

}

//TC : n! * n (as there will be n! permutations generated and add each of size n to result)
