package DSA.Bucket5._11_greedy;

import java.util.Arrays;

public class _03_ShortestJobFirst {

	public static int avgWaitTime(int[] bt) {

		// to pick execution of processes by their shortest time
		Arrays.sort(bt);
		int totalWaitTime = 0;

//		int[] prefixSum = new int[bt.length];
//		prefixSum[0] = 0;// holds wait time of each process
//		for (int i = 1; i < bt.length; i++) {
//			prefixSum[i] = bt[i - 1] + prefixSum[i - 1];
//			totalWaitTime += prefixSum[i];
//		}

		// Instead of using above prefix sum, you can use single variable
		int prevSum = 0;
		for (int i = 1; i < bt.length; i++) {
			prevSum = bt[i - 1] + prevSum;
			totalWaitTime += prevSum;
		}

		return totalWaitTime / bt.length;

	}

	public static void main(String[] args) {
		int[] bt = { 4, 3, 7, 1, 2 };
		System.out.println(avgWaitTime(bt));
	}

}
