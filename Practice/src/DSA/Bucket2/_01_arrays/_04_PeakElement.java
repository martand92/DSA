package DSA.Bucket2._01_arrays;

public class _04_PeakElement {

	public static void main(String[] args) {

		int[] arr = { 6, 1, 15, 19, 9, 13, 12, 6, 7, 2, 10, 4, 1, 14, 11, 14, 14, 13 };

		int peakElement = arr[0], index = 0;

		for (int i = 1; i < arr.length; i++) {

			if (arr[i] > peakElement) {
				peakElement = arr[i];
				index = i;
			}
		}

		System.out.println(index);
	}
}
