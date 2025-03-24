package DSA.Bucket3._11_greedy;

import java.util.*;

public class _06_MeetingRoom_OverlappingIntrvl {

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

		int endTime = 0, count = 0;
		for (int i = 0; i < meetings.length; i++) {
			if (meetings[i].start > endTime) {
				endTime = meetings[i].end;
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
