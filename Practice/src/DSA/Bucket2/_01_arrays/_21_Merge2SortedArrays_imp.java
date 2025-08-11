package DSA.Bucket2._01_arrays;

//https://www.youtube.com/watch?v=n7uwj04E0I4
//https://www.naukri.com/code360/problems/merge-two-sorted-arrays-without-extra-space_6898839
import java.util.*;

public class _21_Merge2SortedArrays_imp {

	public static int[] mergeArrays_Brute(int[] arr1, int[] arr2) {

		int[] arr3 = new int[arr1.length + arr2.length];
		int l = 0, r = 0, k = 0;

		while (l < arr1.length && r < arr2.length) {

			if (arr1[l] < arr2[r]) {
				arr3[k] = arr1[l];
				l++;
			} else {
				arr3[k] = arr2[r];
				r++;
			}

			k++;
		}

		while (l < arr1.length) {
			arr3[k] = arr1[l];
			l++;
			k++;
		}

		while (r < arr2.length) {
			arr3[k] = arr2[r];
			r++;
			k++;
		}

		return arr3;
		// TC : O(n + m)
		// SC : O(n + m)
	}

	// Without using extra space

	// have 2 pointers, 1 at the end of arr1 and another at starting of arr2. If
	// left is greater than right then swap and move l left and r right. Repeat and
	// if arr1[l] < arr2[r] then all elements left to l will be by default lesser
	// than all elements to right of r

	public static void swap(int[] arr1, int[] arr2, int l, int r) {
		int temp = arr1[l];
		arr1[l] = arr2[r];
		arr2[r] = temp;
	}

	public static void mergeArrays_Opt(int[] arr1, int[] arr2) {

		int l = arr1.length - 1, r = 0;

		while (l >= 0 && r < arr2.length) {// O(n + m)

			if (arr1[l] > arr2[r]) {
				swap(arr1, arr2, l, r);
				l--;
				r++;
			} else // if arr1[l] < arr2[r] then all the elements left of arr1[l] < all elements
					// right of arr2[r]
				break;
		}

		// now sort arr1 and arr2 to get to final state
		Arrays.sort(arr1);// O(nlogn)
		Arrays.sort(arr2);// O(mlogm)
		System.out.println(Arrays.toString(arr1) + Arrays.toString(arr2));

		// TC : O(n + m + nlogn + mlogm)
		// SC : O(n + m)

	}

	public static void main(String[] args) {
		// have distinct elements
		int[] arr1 = { 1, 3, 5, 7 };
		int[] arr2 = { 0, 2, 6, 8, 9 };

		System.out.println(Arrays.toString(mergeArrays_Brute(arr1, arr2)));
		mergeArrays_Opt(arr1, arr2);
	}

}
