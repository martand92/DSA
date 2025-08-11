package DSA.Bucket2._06_search._02_BinarySearch._03_BinarySearchAns.min_max;

//https://www.youtube.com/watch?v=TXAuxeYBTdg
//https://www.naukri.com/code360/problems/rose-garden_2248080
public class _22_RoseGarden {

	public static int bloomDay(int[] arr, boolean first) {

		int lastBloomDay = arr[0];
		int firstBloomDay = arr[0];

		for (int i = 1; i < arr.length; i++) {
			lastBloomDay = Math.max(lastBloomDay, arr[i]);
			firstBloomDay = Math.min(firstBloomDay, arr[i]);
		}

		if (first)
			return firstBloomDay;
		else
			return lastBloomDay;
	}

	public static boolean isPossibleWithCurrBloomDay(int[] arr, int k, int m, int currBloomDay) {

		int l = 0;

		for (int r = 0; r < arr.length; r++) { // O(n)

			// if you get consecutive k flowers thats blooming by currBloomDay, then 1
			// buquote can be constructed
			if (arr[r] <= currBloomDay && (r - l + 1) == k) {
				l = r + 1;
				m--;

				// if all bouquets can be created with each containing k flowers, then return
				// true
				if (m == 0)
					return true;
			}

			// if current day is higher than current bloom day, then adjacency is broken, so
			// need to find next k adjacent days from next day
			if (arr[r] > currBloomDay) {
				l = r + 1;
			}

		}

		// if m bouquets are not possible each with k flowers then return false
		return false;
	}

	public static int minNumOfDays(int[] arr, int k, int m) {

		// bloom day possibilities will range from min of bloomday -> max of bloomday
		// i.e, max bloom day possible is last day that rose takes to bloom
		int l = bloomDay(arr, true), r = bloomDay(arr, false), mid = 0; // O(2n) as callig fn() twice-> can be reduced
																		// to O(n)

		// if no of flowers needed to make m bouquets each with k flowers exceeds total
		// num of flowers n, then not possible
		if (m * k > arr.length)
			return -1;

		while (l <= r) { // O(log arr(max-min))

			// mid indicates current bloom day
			mid = (l + r) / 2;

			// if possible with bloomday=mid, then creating m bouquets is also possible with
			// all higher bloomdays. As we need to look for min days, check for lower bloom
			// day if its possible

			// if not possible with bloomday=mid, then definitely not possible for lower
			// bloom days, so look for higher bloom days
			boolean isPossible = isPossibleWithCurrBloomDay(arr, k, m, mid);// O(N)

			if (isPossible)
				r = mid - 1;

			else // if (!isPossible)
				l = mid + 1;
		}

		return l;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 1, 2, 7, 6, 2, 3, 1 };
		int k = 3, m = 2;
		System.out.println(minNumOfDays(arr, k, m));
	}

}
//TC : O(2N) + O(log(arr(max-min)) * N)
//SC : O(1)
