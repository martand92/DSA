package DSA.Bucket5._10_dynamicprogramming._08_SubSeq_SubSetSum;

public class _01_02_Recursion {

	public static boolean checkIfKSum(int[] arr, int k, int index) {

		if (k == 0)
			return true;

		if (index == 0) {
			if (k == arr[index])
				return true;

			return false;
		}

		boolean pick = false;
		if (k >= arr[index])
			pick = checkIfKSum(arr, k - arr[index], index - 1);

		boolean notPick = checkIfKSum(arr, k, index - 1);

		return pick | notPick;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3 };
		int k = 10;
		System.out.println(checkIfKSum(arr, k, arr.length - 1));
	}
}