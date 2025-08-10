package DSA.Bucket2._01_arrays._01_basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _13_02_MoveNegElementsToLast_imp {

	private static int[] moveNegElements_Brute(int[] arr) {

		List<Integer> temp_pos = new ArrayList<>();
		List<Integer> temp_neg = new ArrayList<>();

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] >= 0)
				temp_pos.add(arr[i]);
			else
				temp_neg.add(arr[i]);
		}

		for (int i = 0; i < temp_pos.size(); i++)
			arr[i] = temp_pos.get(i);

		for (int i = temp_pos.size(); i < arr.length; i++)
			arr[i] = temp_neg.get(i - temp_pos.size());

		return arr;
		// TC: O(N)
		// SC : O(N)
	}

	// same as moving zeros to last, except this involves continuous swaps till all
	// zeros are moved right
	private static int[] moveNegElements_Opt(int[] arr) {

		int i = 0, j = 0;

		while (i < arr.length) {

			// point j to 1st occurrence of neg num
			if (arr[j] > 0)
				j++;

			else if (arr[i] >= 0) {

				// when element with positive val is found with preceding neg values, then push
				// this pos val till front of neg values by swapping all preceding neg elements
				int itrCount = i - j;
				int swapPointr = i;// have additional pointer at pos val which need to be pushed to the front by
									// continuously swapping all preceding neg values

				// continue swapping bakward from current pos num till all neg nums are swapped
				// with this
				while (itrCount > 0) {
					swap(arr, swapPointr, swapPointr - 1);
					itrCount--;
				}

				j++;// continue to point j to 1st occurrence of neg num
			}

			i++;
		}

		return arr;

	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {

		int[] arr = { 1, -1, 3, 2, -7, -5, 11, 6 };
		System.out.println(Arrays.toString(moveNegElements_Brute(arr)));
		System.out.println(Arrays.toString(moveNegElements_Opt(arr)));
	}
}
