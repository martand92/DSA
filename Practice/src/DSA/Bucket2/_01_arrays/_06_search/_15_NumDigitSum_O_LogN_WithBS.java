package DSA.Bucket2._01_arrays._06_search;

//https://practice.geeksforgeeks.org/problems/number-and-the-digit-sum4021/1
public class _15_NumDigitSum_O_LogN_WithBS {

	public static void main(String[] args) {

		// int n = 19, k = 19;
		int n = 40918, k = 18;
		int arrayIndex = n / 9;

		int[] arr = new int[arrayIndex];

		for (int i = 0; i < arrayIndex; i++)
			arr[i] = (i + 1) * 9;

		int ceilingIndexOfK = binarySearchCeilingOfK(arr, k);

		if (ceilingIndexOfK == -1)
			System.out.println(0);

		System.out.println(ceilingIndexOfK);
		System.out.println(n - (arr[ceilingIndexOfK] / 9 * 10) + 1);
	}

	public static int binarySearchCeilingOfK(int[] arr, int k) {

		int l = 0, r = arr.length - 1;

		while (l <= r) {

			int mid = l + (r - l) / 2;

			if (k == arr[mid])
				return mid;

			else if (k < arr[mid])
				r = mid - 1;

			else
				l = mid + 1;
		}

		return l; // if (l > r) then return ceiling element from array

	}

}
