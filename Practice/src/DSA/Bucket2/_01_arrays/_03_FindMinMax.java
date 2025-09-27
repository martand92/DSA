package DSA.Bucket2._01_arrays;

public class _03_FindMinMax {
	public static void main(String[] args) {
		int[] arr = { 3, 4, 20, 1, 5 };

		int min = arr[0], max = arr[0];

		for (int i = 0; i < arr.length; i++) {

			if (max < arr[i])
				max = arr[i];

			if (min > arr[i])
				min = arr[i];
		}

		System.out.println("Min:" + min + ", Max:" + max);
	}

}
