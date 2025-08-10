package DSA.Bucket2._01_arrays._02_prefixSum;

public class _02_SumOfSubArray {

	public static void main(String[] args) {

		int[] arr = { 3, 6, 2, 8, 9, 2 };
		int[][] q = { { 2, 3 }, { 4, 6 }, { 1, 5 }, { 3, 6 } }; // 1 based indexing

		int[] prefixSum = new int[arr.length]; // SC : O(N)
		prefixSum[0] = arr[0];

		for (int i = 1; i < arr.length; i++) // TC : O(N)
			prefixSum[i] = prefixSum[i - 1] + arr[i];

		for (int k = 0; k < q.length; k++) { // O(Q)
			int j = q[k][1];
			int i = q[k][0];

			// to calculate consider either
			// prefixSum[j+1] - prefixSum[i] or prefixSum[j] - prefixSum[i-1]

			// considering prefixSum[j] - prefixSum[i-1]
			if (i == 1)
				System.out.println(prefixSum[j - 1]);// due to 1 based indexing
			else
				System.out.println(prefixSum[j - 1] - prefixSum[i - 2]);
		}

	}
}

//TC : O(N + Q)
//SC : O(N)