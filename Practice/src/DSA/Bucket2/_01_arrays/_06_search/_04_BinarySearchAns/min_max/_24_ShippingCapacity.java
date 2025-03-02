package DSA.Bucket2._01_arrays._06_search._04_BinarySearchAns.min_max;

//https://www.youtube.com/watch?v=MG-Ac4TAvTY
//https://www.naukri.com/code360/problems/capacity-to-ship-packages-within-d-days_1229379
public class _24_ShippingCapacity {

	public static int maxOfWeights(int[] weights) {
		int maxWeight = weights[0];
		for (int i = 0; i < weights.length; i++) {
			maxWeight = Math.max(maxWeight, weights[i]);
		}
		return maxWeight;
	}

	public static int sumOfAllWeights(int[] weights) {
		int sum = 0;
		for (int i = 0; i < weights.length; i++) {
			sum += weights[i];
		}
		return sum;
	}

	public static int noOfDaysWithCurrMidWt(int[] weights, int maxWeightPerDay) {

		int noOfDays = 0;
		int currWeight = 0;

		for (int r = 0; r < weights.length; r++) {

			// if adding current weight surpass expected weight, then more +1 day is
			// required to ship this weight
			if ((currWeight + weights[r]) > maxWeightPerDay) {
				noOfDays++;
				currWeight = weights[r];

			} else
				currWeight += weights[r];
		}

		return noOfDays + 1;
	}

	public static int findMinCapacity(int[] weights, int days) {

		// here need to find min capacity that ship can carry all the items.
		// capacity of ship should be able to hold atleast max of all available weights
		// and utmost sum of all weights.
		// Hence ranges is from max(weights[]) to sum of all weights

		int l = maxOfWeights(weights), r = sumOfAllWeights(weights), mid = 0;

		// finding min weight/day that would be needed to ship all items in given days
		while (l <= r) {

			// here mid indicates max weight/day that ship can hold and if all weights are
			// transported before given days then reduce weight else increase weight
			mid = (l + r) / 2;

			int noOfDays = noOfDaysWithCurrMidWt(weights, mid);

			// if no of days taken with mid weight is less than expected days to ship all
			// container, then reduce mid weight
			if (noOfDays < days) {
				r = mid - 1;

				// if no of days taken with mid weight is greater than expected days to ship all
				// container, then increase mid weight
			} else if (noOfDays > days)
				l = mid + 1;
			else
				return mid;
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] weights = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int days = 1;

//		int[] weights = { 5, 4, 5, 2, 3, 4, 5, 6 };
//		int days = 5;

		System.out.println(findMinCapacity(weights, days));
	}

}
