package DSA.Bucket2._04_intervals;

import java.util.*;

//https://leetcode.com/problems/non-overlapping-intervals/description/
public class _07_NonOverlappingIntrvl_imp {

	// here custom class might not be needed, you can sort 2D array
	public static class Interval {
		int start;
		int end;

		public Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	public static int removeOverlappingIntervals(int[][] interval) {

		Interval[] intervals = new Interval[interval.length];

		for (int i = 0; i < interval.length; i++)
			intervals[i] = new Interval(interval[i][0], interval[i][1]);

		Arrays.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval a, Interval b) {
				return a.end - b.end;//This also works if you sort by start time but then pick the interval that ends sooner
			}
		});

		int prevIntervalEndTime = 0, count = 0;
		for (int i = 0; i < intervals.length; i++) {

			if (intervals[i].start < prevIntervalEndTime)// if overlapping
				count++;
			else
				prevIntervalEndTime = intervals[i].end;// if non-overlapping then consider its endpoint
		}

		return count;
	}

	public static void main(String[] args) {

		// int[][] interval = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 3 } };
		// int[][] interval = { { 1, 2 }, { 1, 2 }, { 1, 2 } };
		int[][] interval = { { 1, 2 }, { 2, 3 } };

		System.out.println("Need to remove " + removeOverlappingIntervals(interval) + " overlapping intervals");
	}

}
