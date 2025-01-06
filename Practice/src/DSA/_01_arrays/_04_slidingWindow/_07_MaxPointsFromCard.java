package DSA._01_arrays._04_slidingWindow;

public class _07_MaxPointsFromCard {

	public static int findMaxPointsFromCards(int[] cardPoints, int k) {

		int sum = 0, maxSum = 0, l = 0, r = k - 1;

		// initially fix window from 0 -> k-1
		for (int i = 0; i < k; i++)// O(K)
			maxSum += cardPoints[i];
		sum = maxSum;

		// now move window in backward direction so that first and last elements
		// together can form window of length k till all k last elements of array are
		// checked
		while (r >= 0) {// O(K)
			sum -= cardPoints[r];
			r--;
			l--;
			sum += cardPoints[cardPoints.length + l];
			maxSum = Math.max(maxSum, sum);
		}

		return maxSum;
	}

	public static void main(String[] args) {
		int[] cardPoints = { 6, 2, 3, 4, 7, 2, 1, 7, 1 };
		int k = 4; // Static window size

		// Expected ans is cards picked -> {2,6,1,7}

		System.out.println(findMaxPointsFromCards(cardPoints, k));
	}

}
//TC : O(2 * K)
//SC : O(1)
