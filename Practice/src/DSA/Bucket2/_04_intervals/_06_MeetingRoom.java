package DSA.Bucket2._04_intervals;

import java.util.*;

//you need non-overlapping intervals here, so need to sort by end time
public class _06_MeetingRoom {

	public static class Meeting {
		int start;
		int end;

		public Meeting(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	public static int countMeetings(int[] start, int[] end) {

		Meeting[] meetings = new Meeting[start.length];

		for (int i = 0; i < start.length; i++)
			meetings[i] = new Meeting(start[i], end[i]);

		// Select meetings that are ending faster
		Arrays.sort(meetings, new Comparator<Meeting>() {
			public int compare(Meeting a, Meeting b) {
				return a.end - b.end;
			}
		});

		int prevIntervalEndTime = 0, count = 0;
		for (int i = 0; i < meetings.length; i++) {
			if (meetings[i].start >= prevIntervalEndTime) {
				prevIntervalEndTime = meetings[i].end; // if non-overlapping then consider its endpoint
				count++;
			}
		}

		return count;
	}

	public static void main(String[] args) {

		int[] start = { 1, 3, 0, 5, 8, 5 };
		int[] end = { 2, 4, 6, 7, 9, 9 };

		System.out.println(countMeetings(start, end));
	}

}
