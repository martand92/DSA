package DSA._01_arrays._03_prefixSum;

public class SumOfArray {

	public static void main(String[] args) {

		int[] arr = { 3, 6, 2, 8, 9, 2 };
		int[][] q = { { 2, 3 }, { 4, 6 }, { 1, 5 }, { 3, 6 } };

		int[] prefixSum = new int[arr.length];
		prefixSum[0] = arr[0];
		int l = 0, r= 0;

		for (int i = 1; i < arr.length; i++)
			prefixSum[i] = prefixSum[i - 1] + arr[i];

		for (int i = 0; i < q.length; i++) {
			l = q[i][0];
			r = q[i][1];
		}

		if (l == 1)
			System.out.println(prefixSum[r]);
		else
			System.out.println(prefixSum[r] - prefixSum[l - 1]);
	}
}
