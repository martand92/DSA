package DSA.Bucket2._01_arrays;

public class _00_CheckIfArrIsSorted {

	public static boolean isArrSorted(int[] arr) {

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < arr[i - 1])
				return false;
		}

		return true;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 2, 3, 3, 4 };
		System.out.println(isArrSorted(arr));
	}

}
