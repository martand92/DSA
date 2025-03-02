package DSA.Bucket2._01_arrays._06_search._04_BinarySearchAns.min_max;

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

	// Total time taken to completely eat all bananas with m bananas/hr rate
	public static int timeTakenToEatAllBananas(int[] arr, int m) {

		int hours = 0;

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] % m == 0)
				hours += arr[i] / m;
			else
				hours += arr[i] / m + 1;
		}

		return hours;
	}

	// If eating m bananas/hour gets completed before 'h' hours then eat less
	// bananas/hr
	// If eating m bananas/hour takes more than 'h' hours, then eat more
	// bananas/hr
	public static int minNumOfBananasPerHour(int[] arr, int h) {

		// no of bananas to be eaten every hour ranges from 1 -> highest of arr element
		int l = 1, r = maxArrEle(arr), mid = 0;

		while (l <= r) {

			// here mid(m) indicates no of bananas to be consumed/hr
			mid = (l + r) / 2;

			int time = timeTakenToEatAllBananas(arr, mid);

			// If time taken to consumer all bananas with speed of m(mid)/hr is less than
			// given hours then need decrease /hr rate(m)
			if (time < h)
				r = mid - 1;

			else if (time > h)
				l = mid + 1;

			else
				return mid;
		}

		return -1;

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