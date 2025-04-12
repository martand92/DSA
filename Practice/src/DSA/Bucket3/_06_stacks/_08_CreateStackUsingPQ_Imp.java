package DSA.Bucket3._06_stacks;

import java.util.Comparator;
import java.util.PriorityQueue;

public class _08_CreateStackUsingPQ_Imp {

	public static class Stack {
		int count = 0;
		PriorityQueue<StackModel> pq = new PriorityQueue<StackModel>(new Comparator<StackModel>() {
			@Override
			public int compare(StackModel o1, StackModel o2) {
				return o2.count - o1.count;
			}

		});

		// prioritize based on latest added element as its stack, so keep increasing
		// counter and higher counter value has highest priority
		public boolean push(int data) {
			count++;
			return pq.add(new StackModel(count, data));
		}

		public int pop() {
			return pq.remove().data;
		}
	}

	static class StackModel {
		Integer count;
		int data;

		public StackModel(Integer count, int data) {
			this.count = count;
			this.data = data;
		}
	}

	public static void main(String[] args) {
		Stack st = new Stack();
		st.push(1);
		st.push(2);
		st.push(3);
		st.push(8);
		st.push(10);

		System.out.println(st.pop());
		System.out.println(st.pop());
		System.out.println(st.pop());
	}
}
