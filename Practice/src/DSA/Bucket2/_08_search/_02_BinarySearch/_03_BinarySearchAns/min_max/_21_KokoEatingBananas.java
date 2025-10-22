package DSA.Bucket2._08_search._02_BinarySearch._03_BinarySearchAns.min_max;

//https://www.naukri.com/code360/problems/minimum-rate-to-eat-bananas_7449064
//https://www.youtube.com/watch?v=qyfekrNni90
public class _21_KokoEatingBananas {

	// as need to figure out min no of bananas to be eaten every hour, the range of
	// bananas to be eaten/hr varies from 1 -> max(arr) to finish in given hr
	public static int maxArrEle(int[] arr) {
		int max = arr[0];
		for (int i = 1; i < arr.length; i++)
			max = Math.max(max, arr[i]);

		return max;
	}

	// finding if all bananas can be consumed with mid/hr rate
	public static boolean isPossible(int[] arr, int mid, int h) {

		int hours = 0;

		// Total time taken to completely eat all bananas with m bananas/hr rate
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % mid == 0)
				hours += arr[i] / mid;
			else
				hours += (arr[i] / mid) + 1;
		}

		if (hours <= h)
			return true;

		return false;
	}

	// If eating m bananas/hr completes before 'h' hrs then eat less bananas/hr
	// If eating m bananas/hr takes more than 'h' hrs, then eat more bananas/hr
	public static int minNumOfBananasPerHour(int[] arr, int h) {

		// no of bananas eaten/hr ranges from 1 -> highest element in arr[]
		int l = 1, r = maxArrEle(arr), mid = 0;

		while (l <= r) {

			// mid = no of bananas consumed/hr
			mid = (l + r) / 2;

			// If all bananas are eaten faster then reduce no of bananas consumed/hr
			if (isPossible(arr, mid, h))
				r = mid - 1;

			// If all bananas are eaten slower then increase no of bananas consumed/hr
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
//		int[] arr = { 25, 12, 8, 14, 19 };
//		int h = 5;

		int[] arr = { 3, 6, 2, 8 };
		int h = 7;

		System.out.println(minNumOfBananasPerHour(arr, h));
	}
}
//TC : O(n) + O(log(max(arr) * n))