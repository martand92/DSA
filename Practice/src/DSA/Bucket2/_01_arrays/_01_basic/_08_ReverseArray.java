package DSA.Bucket2._01_arrays._01_basic;

import java.util.Arrays;

public class _08_ReverseArray {

	public static void main(String[] args) {
		int[] arr = { 8, 2, 3, 6, 4, 6, 0, 2, 6 };

		// 2nd Approach : Time O(N), Space O(1)
		int i = 0, j = arr.length - 1;
		int temp;

		while (i < j) {
			temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}

		System.out.println(Arrays.toString(arr));

	}

}
