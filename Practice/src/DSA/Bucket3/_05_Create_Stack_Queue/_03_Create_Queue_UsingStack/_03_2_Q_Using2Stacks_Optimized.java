package DSA.Bucket3._05_Create_Stack_Queue._03_Create_Queue_UsingStack;

import java.util.*;

// When our operations are push heavy, then we want push to be O(1)

// Here we still maintain 2 stacks.
// enqueue() happens to stack1 in LIFO basis in O(1).
// But for top() or dequeue(), first move all elements from stack1 to stack2 and then remove top of stack2
// But if s2 already has previous elements, then remove top of stack2
// 

public class _03_2_Q_Using2Stacks_Optimized {

	static class Queue {

		static Stack<Integer> s1 = new Stack<Integer>();
		static Stack<Integer> s2 = new Stack<Integer>();

		public void enqueue(int data) { // O(1)
			s1.push(data);
		}

		public int dequeue() {

			if (!s2.isEmpty())
				return s2.pop();

			else {
				while (!s1.isEmpty()) {
					s2.push(s1.pop());
				}

				return s2.pop();
			}

		}

		public int top() {

			if (!s2.isEmpty())
				return s2.peek();

			else {
				while (!s1.isEmpty()) {
					s2.push(s1.pop());
				}

				return s2.peek();
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
		System.out.println(q.dequeue());
	}
}
