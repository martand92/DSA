package DSA.Bucket2._01_arrays._04_search;

public class _29_01_FindMedianOfTwoSortedArrays {

	public static int median(int[] arr1, int[] arr2) {
		int[] arr3 = new int[arr1.length + arr2.length];
		int pointer1 = 0, pointer2 = 0, pointer3 = 0;
		int median = 0;

		while (pointer1 < arr1.length && pointer2 < arr2.length) {

			if (arr1[pointer1] < arr2[pointer2]) {
				arr3[pointer3] = arr1[pointer1];
				pointer1++;
				pointer3++;
			} else {
				arr3[pointer3] = arr2[pointer2];
				pointer2++;
				pointer3++;
			}

		}

		while (pointer1 < arr1.length) {
			arr3[pointer3] = arr1[pointer1];
			pointer1++;
			pointer3++;
		}

		while (pointer2 < arr2.length) {
			arr3[pointer3] = arr2[pointer2];
			pointer2++;
			pointer3++;
		}

		int n = arr3.length;
		if (n % 2 == 0)
			median = (arr3[n / 2] + arr3[(n / 2 - 1)]) / 2;
		else
			median = arr3[n / 2];

		return median;

	}

	public static void main(String[] args) {
//		int[] arr1 = { 1, 3, 4, 7, 10, 12 };
//		int[] arr2 = { 2, 3, 6, 15 };

		int[] arr1 = { 2, 3, 4 };
		int[] arr2 = { 1, 3 };

		System.out.println(median(arr1, arr2));
	}
}

//TC : O(n1 + n2)
//SC : O(n1 + n2)