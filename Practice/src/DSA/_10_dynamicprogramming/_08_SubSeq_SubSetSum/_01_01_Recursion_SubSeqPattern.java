package DSA._10_dynamicprogramming._08_SubSeq_SubSetSum;

public class _01_01_Recursion_SubSeqPattern {

	public static boolean checkIfKSum(int[] arr, int k, int index, int sum) {

		if (index < 0) {
			if (sum == k)
				return true;

			return false;
		}

		if (checkIfKSum(arr, k, index - 1, sum + arr[index]))
			return true;
		if (checkIfKSum(arr, k, index - 1, sum))
			return true;

		return false;

	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3 };
		int k = 2;
		System.out.println(checkIfKSum(arr, k, arr.length - 1, 0));
	}

}
