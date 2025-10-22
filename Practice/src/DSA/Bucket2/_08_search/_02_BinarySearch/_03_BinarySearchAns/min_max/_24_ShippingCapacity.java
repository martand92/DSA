package DSA.Bucket2._08_search._02_BinarySearch._03_BinarySearchAns.min_max;

//https://www.youtube.com/watch?v=MG-Ac4TAvTY
//https://www.naukri.com/code360/problems/capacity-to-ship-packages-within-d-days_1229379
public class _24_ShippingCapacity {

	static int maxWeight = 0, sumOfWeights = 0;

	public static void calWeight(int[] weights) {

		for (int i = 0; i < weights.length; i++) {
			maxWeight = Math.max(maxWeight, weights[i]);
			sumOfWeights += weights[i];
		}
	}

	public static boolean isPossible(int[] weights, int maxWeightPerDay, int day) {

		int noOfDays = 0, weight = 0;

		for (int i = 0; i < weights.length; i++) {

			weight += weights[i];

			if (weight > maxWeightPerDay) {
				noOfDays++;
				weight = weights[i];
			}
		}

		return (noOfDays + 1) <= day; // this considers last one day with the remaining packages
	}

	public static int findLeastCapacity(int[] weights, int days) {

		// here need to find min capacity that ship can carry all the items.
		// Capacity of ship should be atleast max(weights) & utmost sum(weights)
		// Hence range : l = max(weights[]), r = sum(weights[])
		calWeight(weights);
		int l = maxWeight, r = sumOfWeights;

		while (l <= r) {

			// here mid indicates max weight/day that ship can carry
			int weightPerDay = (l + r) / 2;

			if (isPossible(weights, weightPerDay, days))
				r = weightPerDay - 1;
			else
				l = weightPerDay + 1;
		}

		return l;
	}

	public static void main(String[] args) {
		int[] weights = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int days = 1;

//		int[] weights = { 5, 4, 5, 2, 3, 4, 5, 6 };
//		int days = 5;

		System.out.println(findLeastCapacity(weights, days));
	}

}
