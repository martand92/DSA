package practice;

import java.util.concurrent.*;

public class PriorityBlockingQueueClass {

	public static void main(String[] args) {
		PriorityBlockingQueue<Job> queue = new PriorityBlockingQueue<>();

		ExecutorService es = Executors.newFixedThreadPool(2);
		es.execute(() -> {

			queue.put(new Job(4, "collegue job"));
			queue.put(new Job(2, "junior job"));
			queue.put(new Job(10, "md job"));
			queue.put(new Job(6, "manager job"));

		});

		es.execute(() -> {
			try {
				for (int i = 0; i < 5; i++) {
					Thread.sleep(1000);
					System.out.println(queue.take());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

	}

}

class Job implements Comparable<Job> {
	int priority;
	String jobname;

	public Job(int priority, String jobname) {
		this.priority = priority;
		this.jobname = jobname;
	}

	@Override
	public int compareTo(Job o) {
		return o.priority - priority;
	}

	public String toString() {
		return "Job Name...:" + jobname + ":...Priority.." + priority;
	}
}
