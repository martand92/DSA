package DSA.Bucket2._08_search._02_BinarySearch._03_BinarySearchAns.min_max;

//https://www.youtube.com/watch?v=TXAuxeYBTdg

//https://www.naukri.com/code360/problems/rose-garden_2248080

/* Adjacent : Consider roses that are blooming adjacently 
 * i.e, If 1st rose bloom on 1st day, If 2nd rose bloom on 5th day, If 3rd rose bloom on 3rd day
 * though they are no blooming on consecutive days they are still blooming adjacently*/
public class _22_RoseGarden {

	static int firstBloomDay, lastBloomDay;

	public static void bloomDay(int[] arr) {

		firstBloomDay = Integer.MAX_VALUE;
		lastBloomDay = Integer.MIN_VALUE;

		for (int i = 0; i < arr.length; i++) {
			lastBloomDay = Math.max(lastBloomDay, arr[i]);
			firstBloomDay = Math.min(firstBloomDay, arr[i]);
		}
		
	}
	
	//finding if m bouquets are possible each with k roses within currBloomDay
	public static boolean isPossible(int[] arr, int k, int m, int currBloomDay) {

		int l = 0;

		for (int r = 0; r < arr.length; r++) { // O(n)

			// if you get consecutive k flowers thats blooming by currBloomDay, then 1
			// Bouquet can be constructed
			if (arr[r] <= currBloomDay && (r - l + 1) == k) {
				l = r + 1;
				m--;
			}

			// if all bouquets can be created with each containing k flowers, then return
			// true
			if (m == 0)
				return true;

			// if current day is higher than current bloom day, then adjacency is broken, so
			// need to find next k adjacent days from next day
			if (arr[r] > currBloomDay)
				l = r + 1;
		}

		// if m bouquets are not possible each with k flowers then return false
		return false;
	}

	public static int minNumOfDays(int[] arr, int k, int m) {

		// bloom day ranges from min(bloomday[]) i.e, first day rose bloom to
		// max(bloomday[]) i.e last day rose blooms
		bloomDay(arr);
		int l = firstBloomDay, r = lastBloomDay, mid = 0; // O(n)

		// to make m bouquets each with k roses, atleast m * k roses are needed
		if (m * k > arr.length)
			return -1;

		while (l <= r) { // O(log arr(max-min))

			// mid indicates min day considered to pluck already bloomed roses to
			// make m bouquets
			mid = (l + r) / 2;

			/*
			 * if possible with bloomday=mid, then creating m bouquets is also possible with
			 * all higher bloomdays. As we need to look for min days, check for lower bloom
			 * day
			 * 
			 * if not possible with bloomday=mid, then definitely not possible for lower
			 * bloom days, so look for higher bloom days
			 */

			if (isPossible(arr, k, m, mid))// O(N)
				r = mid - 1;

			else
				l = mid + 1;
		}

		return l;
		/*
		 * In a binary search for the minimum valid value, you always return l. When
		 * searching for the maximum valid value, you return r.
		 */
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 1, 2, 7, 2, 2, 3, 1 };
		int k = 3, m = 2;
		System.out.println(minNumOfDays(arr, k, m));
	}

}
//TC : O(2N) + O(log(arr(max-min)) * N)
//SC : O(1)
