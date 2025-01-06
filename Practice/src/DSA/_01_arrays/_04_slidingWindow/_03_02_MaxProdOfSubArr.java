package DSA._01_arrays._04_slidingWindow;

//https://www.naukri.com/code360/problems/subarray-with-maximum-product_6890008
//https://www.youtube.com/watch?v=hnswaLJvr6g

public class _03_02_MaxProdOfSubArr {

	// Kadane's algo
	public static int maxProdOfSubArr_Opt(int[] arr) {

		int prod = 1, maxProd = Integer.MIN_VALUE;

		for (int i = 0; i < arr.length; i++) {

			prod *= arr[i];
			maxProd = Math.max(maxProd, prod);

			if (prod == 0)
				prod = 1;
		}

		return maxProd;
		// TC : O(n), SC : O(1)
	}

	public static void main(String[] args) {

		// int[] arr = { 1, 2, 7, -4, 3, 2, -10, 9, 1 };
		// int[] arr = { -2, 3, 0, -4 };
		 int[] arr = { 1, -2, 3, -4 };
		//int[] arr = { -1, 3, 0, -4, 3 };
		System.out.println(maxProdOfSubArr_Opt(arr));
	}

}
