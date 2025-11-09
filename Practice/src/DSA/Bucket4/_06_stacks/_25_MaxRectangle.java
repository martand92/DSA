package DSA.Bucket4._06_stacks;

public class _25_MaxRectangle {

	public static void main(String[] args) {

		int[][] mat = { { 1, 0, 1, 0, 1 }, { 1, 0, 1, 1, 1 }, { 1, 1, 1, 1, 1 }, { 1, 0, 0, 1, 0 } };

		int[][] prefixSumMat = new int[mat.length][mat[0].length];
		int[] arr = new int[mat[0].length];
		int maxArea = Integer.MIN_VALUE;

		for (int col = 0; col < mat[0].length; col++) {
			prefixSumMat[0][col] = mat[0][col];// initial prefixSum is constructed
			arr[col] = prefixSumMat[0][col];// First matrix row is extracted as array to cal maxRectangleArea
		}
		maxArea = Math.max(maxArea, _24_01_LargestRectangleInHistogram.findLongestRectangleArea(arr));

		// Now build prefixSum to derive 1D array at each level
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
			maxArea = Math.max(maxArea, _24_01_LargestRectangleInHistogram.findLongestRectangleArea(arr));

		}

		// System.out.println(Arrays.deepToString(prefixSumMat));
		System.out.println(maxArea);

	}

}
