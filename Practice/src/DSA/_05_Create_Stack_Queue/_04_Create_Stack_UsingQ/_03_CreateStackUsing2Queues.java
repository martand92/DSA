package DSA._05_Create_Stack_Queue._04_Create_Stack_UsingQ;

import java.util.LinkedList;
import java.util.Queue;

public class _03_CreateStackUsing2Queues {

	static class Stack {
		Queue<Integer> q = new LinkedList<Integer>();
		Queue<Integer> temp = new LinkedList<Integer>();

		public void push(int data) { // putting existing elements from 1st q into 2nd q and then adding back
			while (!q.isEmpty()) {
				temp.add(q.poll());
			}
			q.add(data);

			while (!temp.isEmpty()) {
				q.add(temp.poll());
			}

//          if you dont want to add back then swap references temp and q
//			Queue<Integer> swapTemp = q;
//            q = temp;
//            temp = swapTemp;

		}

		public int pop() {
			return q.poll();
		}

		public int peek() {
			return q.peek();
		}

		public void printStack() {
			for (int data : q)
				System.out.println(data);
		}
	}

	public static void main(String[] args) {
		Stack s = new Stack();
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
		s.printStack();
		System.out.println("peek : " + s.peek());

		System.out.println("popped : " + s.pop());
		s.printStack();
		System.out.println("peek : " + s.peek());

	}

}
