package DSA.Bucket2._05_slidingWindow;

//you can only pick either from beginning or the end
public class _07_MaxPointsFromCard {

	public static int findMaxPointsFromCards(int[] cardPoints, int k) {

		int sum = 0, maxSum = 0, i = k - 1, r = cardPoints.length - 1;

		// initially find sum of left k elements
		for (int l = 0; l < k; l++)// O(K)
			maxSum += cardPoints[l];

		sum = maxSum;

		// Now from left window sum, start removing left elements, add right elements &
		// check for window sum
		while (i >= 0) {// O(K)
			sum -= cardPoints[i--];
			sum += cardPoints[r--];
			maxSum = Math.max(maxSum, sum);
		}

		return maxSum;
	}

	public static void main(String[] args) {
		int[] cardPoints = { 6, 2, 3, 4, 7, 2, 1, 7, 1 }; // Expected ans is cards picked -> {2,6,1,7}
		int k = 4; // Static window size

		System.out.println(findMaxPointsFromCards(cardPoints, k));
	}

}
//TC : O(2 * K)
//SC : O(1)