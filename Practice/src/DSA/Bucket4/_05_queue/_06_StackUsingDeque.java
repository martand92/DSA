package DSA.Bucket4._05_queue;

import java.util.Deque;
import java.util.LinkedList;

public class _06_StackUsingDeque {

	Deque<Integer> deque = new LinkedList<>();

	public void push(int d) {
		deque.offerFirst(d);
	}

	public void pop() {
		System.out.println("Popped : " + deque.removeFirst());
	}

	public void printDeque() {
		for (int a : deque)
			System.out.print(a + " ");
	}

	public void top() {
		System.out.println("Top : " + deque.peek());
	}

	public static void main(String[] args) {
		_06_StackUsingDeque stack = new _06_StackUsingDeque();
		stack.push(0);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.printDeque();
		stack.top();
		
		stack.pop();
		stack.printDeque();
		stack.top();
	}
}
