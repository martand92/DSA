package DSA.Bucket2._01_arrays._01_arrays;

import java.util.Arrays;

//bubble sort
public class _10_SortArray_NSqr {

	public static void main(String[] args) {

		int[] a = { 1, 5, 3, 2 };
		int temp;

		for (int i = 0; i < a.length; i++) {

			for (int j = i + 1; j < a.length; j++) {

				if (a[i] > a[j]) {
					temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}

		System.out.println(Arrays.toString(a));
	}
}