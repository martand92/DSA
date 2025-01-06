package DSA._10_dynamicprogramming._23_PartitionDP_MatrixChainMultiplication;

public class _01_Recursion {

	public static int minOperations(int[] arr, int i, int j) {

		if (i == j)
			return 0;

		int minNoOperations = Integer.MAX_VALUE;

		// partition happens as kth index
		for (int k = i; k < j; k++) {

			int currentPartitionOps = arr[i - 1] * arr[k] * arr[j];
			int left = minOperations(arr, i, k);
			int right = minOperations(arr, k + 1, j);

			int totalOps = currentPartitionOps + left + right;

			minNoOperations = Math.min(minNoOperations, totalOps);
		}

		return minNoOperations;
	}

	public static void main(String[] args) {
		int[] arr = { 10, 20, 30, 40, 50 };
		System.out.println(minOperations(arr, 1, arr.length - 1));

	}

}
