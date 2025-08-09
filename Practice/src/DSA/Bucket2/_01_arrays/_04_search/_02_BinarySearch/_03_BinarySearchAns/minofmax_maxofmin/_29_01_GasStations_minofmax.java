package DSA.Bucket2._01_arrays._04_search._02_BinarySearch._03_BinarySearchAns.minofmax_maxofmin;

//https://www.youtube.com/watch?v=kMSBvlZ-_HA
//https://www.naukri.com/code360/problems/minimise-max-distance_7541449
public class _29_01_GasStations_minofmax {

	public static int findMinDistBetGasStations(int[] arr, int k) {

		// store initial sections of given array. There are 3 sections where gas
		// stations can be placed
		int[] initialSections = new int[arr.length - 1]; // O(n-1)

		// start looping through every single new gas stations to be placed
		for (int i = 0; i < k; i++) { // O(k)

			// loop through current gas stations to find max distanced stations and their
			// section
			int maxDist = 0, maxSection = 0;
			for (int j = 1; j < arr.length; j++) { // O(n)

				// checking distance between gas stations per initial section considering new
				// gas stations might be added every iteration to this section
				int dist = (arr[j] - arr[j - 1]) / (initialSections[j - 1] + 1);

				if (dist >= maxDist) {
					// Store max found distance between gas stations(including newly added stations)
					// and its initial section
					maxDist = dist;
					maxSection = j - 1;
				}
			}

			// now you have max distance and its section, hence need to add new kth station
			// in this section to reduce distance between consecutive stations
			initialSections[maxSection]++;// this will make sure when calculating distance between consecutive stations,
											// these newly added stations are also considered
		}

		// now need to find maximum dist between 2 consecutive gas stations after
		// placing all stations
		int maxDist = 0;
		for (int j = 1; j < arr.length; j++) // O(n)
			maxDist = Math.max(maxDist, (arr[j] - arr[j - 1]) / (initialSections[j - 1] + 1));

		return maxDist;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 13, 17, 23 };
		int k = 5; // need to place 5 gas stations such that max dist between 2 consecutive gas
					// stations after placing new stations should be minimum

		System.out.println(findMinDistBetGasStations(arr, k));
	}
}
//TC : O(k * n) + O(n)
//SC : O(n-1)