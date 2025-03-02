package DSA.Bucket1._05_Create_Stack_Queue._03_Create_Queue_UsingStack;

//When our operations are not push heavy, then we can use below method to enqueue in O(N) but dequeue in O(1) 
import java.util.*;

public class _03_1_Q_Using2Stacks {

	static class Queue {
		static Stack<Integer> s = new Stack<Integer>();
		static Stack<Integer> temp = new Stack<Integer>();

		public void enqueue(int data) {

			while (!s.isEmpty())
				temp.push(s.pop());

			s.push(data);
			while (!temp.isEmpty())
				s.push(temp.pop());

		}

		public int dequeue() {
			if (s.isEmpty()) {
				System.out.println("Queue is Empty");
				return -1;
			} else
				return s.pop();
		}

		public int top() {
			return (s.peek());
		}

		public void printQueue() {
			for (int d : s) {
				System.out.println(d);
			}
		}

	}

	public static void main(String[] args) {

		Queue q = new Queue();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.enqueue(5);

		System.out.println("Top : " + q.top());

		q.printQueue();

		System.out.println(q.dequeue());
	}
}
