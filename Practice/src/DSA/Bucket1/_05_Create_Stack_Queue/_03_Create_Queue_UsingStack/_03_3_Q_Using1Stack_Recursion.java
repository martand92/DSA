package DSA.Bucket1._05_Create_Stack_Queue._03_Create_Queue_UsingStack;

import java.util.*;

public class _03_3_Q_Using1Stack_Recursion {

	static class Queue {
		static Stack<Integer> s = new Stack<Integer>();
		int res = 0;

		public void enqueue(int data) {
			s.push(data);
		}

		public int dequeue() {
			if (s.size() == 1) {
				res = s.pop();
				return res;
			}
			int x = s.pop();
			res = dequeue();
			s.push(x);

			return res;
		}
	}

	public static void main(String[] args) {

		Queue q = new Queue();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);

		System.out.println(q.dequeue());
	}
}
