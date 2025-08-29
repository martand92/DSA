package DSA.Bucket2._04_intervals;

import java.util.*;

public class _20_01_MergeIntervals_imp {

	public static List<ArrayList<Integer>> mergeInterval(int[][] interval) {

		List<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		Arrays.sort(interval, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return a[0] - b[0];
			}
		});

		int prevStartTime = interval[0][0];
		int prevEndTime = interval[0][1];

		for (int i = 1; i < interval.length; i++) {

			if (interval[i][0] <= prevEndTime) // if start time of current interval is overlapping with prev interval
				prevEndTime = Math.max(prevEndTime, interval[i][1]);

			else {

				result.add(new ArrayList<>(Arrays.asList(prevStartTime, prevEndTime)));
				prevStartTime = interval[i][0];
				prevEndTime = interval[i][1];
			}
		}

		// add last interval
		result.add(new ArrayList<>(Arrays.asList(prevStartTime, prevEndTime)));

		return result;
	}

	public static void main(String[] args) {

		int[][] interval = { { 3, 5 }, { 1, 4 }, { 7, 9 }, { 6, 8 }, { 10, 11 } };
		System.out.println(mergeInterval(interval));
	}
}