package DSA.Bucket3._11_greedy;

import java.util.*;

public class _08_MinimumPlatform {

	public static int numberOfMinPlatforms(int[] arrival, int[] dep) {

		Arrays.sort(arrival);
		Arrays.sort(dep);

		int arrPointer = 0;
		int depPointer = 0;
		int count = 0, max = 0;

		while (arrPointer < arrival.length) {

			if (arrival[arrPointer] <= dep[depPointer]) {
				arrPointer++;
				count++;
			} else if (arrival[arrPointer] > dep[depPointer]) {
				depPointer++;
				count--;
			}

			max = Math.max(max, count);

		}

		return max;

	}

	public static void main(String[] args) {
//		int[] arr = { 900, 940, 950, 1100, 1500, 1800 };
//		int[] dep = { 910, 1200, 1120, 1130, 1900, 2000 };

		int[] arr = { 1000, 935, 1100 };
		int[] dep = { 1200, 1240, 1130 };

		System.out.println(numberOfMinPlatforms(arr, dep));
	}

}
