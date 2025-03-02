package DSA.Bucket2._01_arrays._06_search._04_BinarySearchAns.minofmax_maxofmin;

import java.util.*;

//https://www.youtube.com/watch?v=kMSBvlZ-_HA

//https://www.naukri.com/code360/problems/minimise-max-distance_7541449

//In previous approach, 2 loops were there.
//1st : to loop through k stations to add them to existing network 
//2nd : inside loop to find maximum distanced consecutive gas station and their initialSection

//2nd loop can be replaced using priority queue to get max distanced consecutive gas station

public class _29_02_GasStations_minofmax {

	public static class Data {
		int dist;
		int section;

		Data(int dist, int section) {
			this.dist = dist;
			this.section = section;
		}
	}

	public static int findMinDistBetGasStations(int[] arr, int k) {

		// store initial sections of given array. There are 3 sections where gas
		// stations can be placed
		int[] initialSections = new int[arr.length - 1]; // O(n-1)

		// initially load pq with initial station's distances and their resp section
		PriorityQueue<Data> pq = new PriorityQueue<Data>(new Comparator<Data>() {
			public int compare(Data a, Data b) {
				return b.dist - a.dist;
			}
		});
		for (int i = 1; i < arr.length; i++) // O(n log n)
			pq.add(new Data(arr[i] - arr[i - 1], i - 1));

		// start looping through every single new gas stations to be placed
		for (int i = 0; i < k; i++) { // O(k)

			// first get max distanced consecutive gas stations and its section
			Data currMax = pq.poll();

			// now you have max distance and its section, hence need to add new kth station
			// in this section to reduce distance between consecutive stations
			initialSections[currMax.section]++;

			// calculate new distance by placing current gas station in this section. As
			// placing new stations alter initial distance, will derive initial arr[j] -
			// arr[j-1] distance using section of currMax
			int newDist = (arr[currMax.section + 1] - arr[currMax.section]) / (initialSections[currMax.section] + 1);

			// add this new derived distance and same section back to pq
			pq.add(new Data(newDist, currMax.section));

		}

		// now top of pq contains max distanced consecutive gas stations after placing
		// all stations
		return pq.poll().dist;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 13, 17, 23 };
		int k = 5; // need to place 5 gas stations such that max dist between 2 consecutive gas
					// stations after placing new stations should be minimum

		System.out.println(findMinDistBetGasStations(arr, k));
	}
}
//TC : O(nlogn) for initially adding all elements to pq + O(k*logn) // reduced from k*n to  k*logn as pq takes log n for push()
//SC : O(n-1) + O(n-1) //extra n-1 for pq