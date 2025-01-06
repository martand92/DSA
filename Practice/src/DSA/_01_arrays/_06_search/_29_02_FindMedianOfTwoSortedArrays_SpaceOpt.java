package DSA._01_arrays._06_search;

public class _29_02_FindMedianOfTwoSortedArrays_SpaceOpt {

	// as interested in only n/2 and n/2-1 indices if n is even and n/2 index if n
	// is odd to find then median, keep traversing and stop once required indices
	// are found
	public static int median(int[] arr1, int[] arr2) {

		int pointer1 = 0, pointer2 = 0, count = 0; // count is used to check if mid way is reached
		int median = 0;
		int n = arr1.length + arr2.length;

		// need to stop ptr1 and ptr2 of arr1 and arr2 based on total length being even
		// or odd
		int expectedMid = (n % 2 == 0) ? n / 2 - 1 : n / 2;

		while (count < expectedMid && pointer1 < arr1.length && pointer2 < arr2.length) {

			if (arr1[pointer1] < arr2[pointer2])
				pointer1++;

			else
				pointer2++;

			count++;
		}

		// if total length is even, then avg of arr[ptr1] and arr[ptr2] will be the
		// median
		if (n % 2 == 0)
			median = (arr1[pointer1] + arr2[pointer2]) / 2;

		// if total length is odd, then smaller of either arr[ptr1] or arr[ptr2] will be
		// the median
		else
			median = arr1[pointer1] < arr2[pointer2] ? arr1[pointer1] : arr2[pointer2];

		return median;

	}

	public static void main(String[] args) {
		int[] arr1 = { 1, 3, 6, 8 };
		int[] arr2 = { 2, 4, 7, 9 };

//		int[] arr1 = { 2, 3, 4 };
//		int[] arr2 = { 1, 5 };
		

		System.out.println(median(arr1, arr2));
	}
}

//TC : O(n1 + n2)
//SC : O(1)