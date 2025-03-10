package DSA.Bucket3._06_stacks;

public class _25_MaxRectangle {

	public static void main(String[] args) {
		int[][] mat = { { 1, 0, 1, 0, 1 }, { 1, 0, 1, 1, 1 }, { 1, 1, 1, 1, 1 }, { 1, 0, 0, 1, 0 } };

		int[][] prefixSumMat = new int[mat.length][mat[0].length];

		int maxArea = Integer.MIN_VALUE;
		int[] arr = new int[mat[0].length];

		for (int col = 0; col < mat[0].length; col++) {
			prefixSumMat[0][col] = mat[0][col];
			arr[col] = prefixSumMat[0][col];// extracting each row of matrix into separate array to cal max Rectangle
											// area for current histogram
		}

		maxArea = Math.max(maxArea, _24_01_LongestRactangleInHistogram.findLongestRectangleArea(arr));

		for (int i = 1; i < mat.length; i++) {

			for (int j = 0; j < mat[0].length; j++) {

				if (mat[i][j] == 0)
					prefixSumMat[i][j] = 0;

				else
					prefixSumMat[i][j] = prefixSumMat[i - 1][j] + mat[i][j];

				arr[j] = prefixSumMat[i][j];
			}

			// for each prefixSum of matrix that represents histogram at this level,
			// calculate max area
			maxArea = Math.max(maxArea, _24_01_LongestRactangleInHistogram.findLongestRectangleArea(arr));

		}

		// System.out.println(Arrays.deepToString(prefixSumMat));
		System.out.println(maxArea);

	}

}
