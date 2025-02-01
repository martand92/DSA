package DSA._11_greedy;

import java.util.*;

public class _07_CntOverlappingIntrvl_OverlappingInterval {

	public static class Interval {
		int start;
		int end;

		public Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	public static int countNonOverlappingIntervals(int[][] interval) {

		Interval[] intervals = new Interval[interval.length];

		for (int i = 0; i < interval.length; i++)
			intervals[i] = new Interval(interval[i][0], interval[i][1]);

		Arrays.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval a, Interval b) {
				return a.end - b.end;
			}
		});

		int prevIntervalEndTime = 0, count = 0;
		for (int i = 0; i < intervals.length; i++) {

			if (intervals[i].start < prevIntervalEndTime)
				count++;
			else
				prevIntervalEndTime = intervals[i].end;
		}

		return count;
	}

	public static void main(String[] args) {

//		int[][] interval = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 3 } };
		int[][] interval = { { 1, 2 }, { 1, 2 }, { 1, 2 } };

		System.out.println(countNonOverlappingIntervals(interval));
	}

}
