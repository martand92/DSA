package DSA._01_arrays._01_basic;

public class _04_PeakElement {

	public static void main(String[] args) {

		int[] arr = { 6, 1, 15, 19, 9, 13, 12, 6, 7, 2, 10, 4, 1, 14, 11, 14, 14, 13 };

		int peakElement = 0, index = 0;

		for (int i = 0; i < arr.length; i++) {

			if (peakElement < arr[i]) {
				peakElement = arr[i];
				index = i;
			}
		}

		System.out.println(index);
	}
}
