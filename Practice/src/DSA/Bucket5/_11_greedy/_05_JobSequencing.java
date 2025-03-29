package DSA.Bucket5._11_greedy;

import java.util.Arrays;
import java.util.Comparator;

public class _05_JobSequencing {

	static class Job {
		int jobId;
		int deadline;
		int profit;

		Job(int jobId, int deadline, int profit) {
			this.jobId = jobId;
			this.deadline = deadline;
			this.profit = profit;
		}
	}

	public static int maxProfit(Job[] jobs) {

		// Step 1 : sort by max profit
		Arrays.sort(jobs, new Comparator<Job>() {
			public int compare(Job o1, Job o2) {
				return o2.profit - o1.profit;
			}
		});

		// Step 2 : Create array with max deadline size to schedule jobs
		int maxDeadline = Integer.MIN_VALUE;
		for (int i = 0; i < jobs.length; i++)
			maxDeadline = Math.max(maxDeadline, jobs[i].deadline);
		int[] schedulingDays = new int[maxDeadline + 1];// to store value as index

		// Step 3 : Pick jobs by their max profit & Schedule on their resp last deadline
		// day.If already occupied then previous days

		int totalProfit = 0;
		for (int i = 0; i < jobs.length; i++) {

			// first check if this job's deadline is not occupied, if occupied then keep
			// moving to previous days till 1st day to schedule current job
			int k = jobs[i].deadline;
			while (k >= 1 && schedulingDays[k] != 0)
				k--;

			if (k >= 1) {
				schedulingDays[k] = jobs[i].profit;
				totalProfit += jobs[i].profit;
			}
		}

		// below loop can be avoided if you sum up total Profit in previous step
		// directly and hold jobId instead of profit in schedulingDays[]
//		for (int i = 1; i < schedulingDays.length; i++)
//			totalProfit += schedulingDays[i];
//
		return totalProfit;
	}

	public static void main(String[] args) {
		Job[] jobs = { new Job(1, 4, 20), new Job(2, 1, 1), new Job(3, 1, 40), new Job(4, 1, 30) };
		System.out.println(maxProfit(jobs));
	}
}