package DSA.Bucket2._01_arrays._04_search._02_BinarySearch._03_BinarySearchAns.minofmax_maxofmin;

import java.util.*;

//https://www.youtube.com/watch?v=R_Mfw4ew-Vo
//https://www.naukri.com/code360/problems/aggressive-cows_1082559

//Given no of cows need to find their placement in stalls such that distance between them is max

public class _26_AggressiveCows_maxofmin {

	public static boolean isPossible(int[] arr, int cows, int minDist) {

		int prev = 0;
		cows--; // as cow 1 will be always placed at 0th stall

		for (int i = 1; i < arr.length; i++) {

			// check if next cow can be placed at ith stall thats far by minDist
			if (arr[i] - arr[prev] >= minDist) {
				cows--;// place cow at ith stall and make this stall as prev and reduce count of cows
						// to be placed
				prev = i;
			}
			if (cows == 0)
				return true;
		}

		return false;
	}

	public static int maxOfMinPossibleDist(int[] arr, int cows) {

		// finding range. Say given 2 cows, the min possible distance between cows = 1
		// the max possible distance between 2 cows = farthest stall from first stall
		// i.e, distance between 1st and last stall i.e, arr[n] - arr[0]
		// Hence range will be 1 -> arr[n] - arr[0]

		int l = 1, r = arr[arr.length - 1] - arr[0], mid = 0;

		while (l <= r) {

			// here mid will indicate min distance between cows at stall
			mid = (l + r) / 2;

			// need to check with this min distance if all cows can be placed
			if (isPossible(arr, cows, mid))
				l = mid + 1;

			else
				r = mid - 1;
		}
		// eventually r will be standing at possible max distance place where cows can
		// be placed
		return r;
	}

	public static void main(String[] args) {
		int[] arr = { 0, 3, 4, 7, 10, 9 };
		int cows = 4;
		Arrays.sort(arr);// as min distance between any 2 cows will be of consecutive stalls, so need to
							// have stalls in sorted order
		System.out.println(maxOfMinPossibleDist(arr, cows));
	}

}
