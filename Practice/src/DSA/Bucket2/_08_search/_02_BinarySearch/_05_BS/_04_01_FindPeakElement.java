package DSA.Bucket2._08_search._02_BinarySearch._05_BS;

public class _04_01_FindPeakElement {

	public static int findPeakElement(int[] arr) {

		int max = arr[0], index = 0;

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
				index = i;
			}
		}

		return index;
	}

	public static void main(String[] args) {

		int[] arr = { 6, 1, 15, 19, 9, 13, 12, 6, 7, 2, 10, 4, 1, 14, 11, 14, 14, 13 };
		System.out.println(findPeakElement(arr));
	}
}

//TC : O(N)