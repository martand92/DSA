package DSA.Bucket2._04_intervals;

//https://www.youtube.com/watch?v=IexN60k62jo

//https://www.naukri.com/code360/problems/merge-all-overlapping-intervals_6783452

//intention is to count overlapping intervals that could be removed
import java.util.*;

public class _20_02_MergeIntrvlAndCntNonOverlapngIntrvls_imp {

	public static int cntNonOverlappingIntrvls(int[][] arr) {

		int count = 1;
		Arrays.sort(arr, new Comparator<int[]>() {

			public int compare(int[] a, int[] b) {
				return a[0] - b[0];// sorting by start time
			}
		});

		int prevIntervalEndTime = arr[0][1]; // store first intrvl endtime as previntrvlendtime

		for (int i = 1; i < arr.length; i++) {

			if (arr[i][0] <= prevIntervalEndTime) {
				prevIntervalEndTime = Math.max(arr[i][1], prevIntervalEndTime);// as this is overlapping interval,
																				// consider merged intervals max endtime
			} else if (arr[i][0] > prevIntervalEndTime) {
				count++;
				prevIntervalEndTime = arr[i][1]; // as this is non overlapping interval, consider its endtime as new
													// prevendtime
			}
		}

		return count;
	}

	public static void main(String[] args) {
		// Need not be sorted by start time
		int[][] arr = { { 1, 3 }, { 2, 6 }, { 8, 9 }, { 9, 11 }, { 8, 10 }, { 2, 4 }, { 15, 18 }, { 16, 17 } };
		System.out.println(cntNonOverlappingIntrvls(arr));
	}

}
