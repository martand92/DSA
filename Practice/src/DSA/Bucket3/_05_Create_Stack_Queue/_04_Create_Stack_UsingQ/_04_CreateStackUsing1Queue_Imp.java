package DSA.Bucket3._05_Create_Stack_Queue._04_Create_Stack_UsingQ;

import java.util.LinkedList;
import java.util.Queue;

public class _04_CreateStackUsing1Queue_Imp {

	Queue<Integer> q = new LinkedList<>();
	int x;

	public void push(int d) {
		q.add(d);
		for (int i = 0; i < q.size() - 1; i++) { // -1 cz last element is currently added
			x = q.remove();
			q.peek();
			q.add(x);
		}
	}

	public void pop() {
		System.out.println(q.remove());
	}

	public void printQueue() {
		for (int a : q)
			System.out.print(a + " ");
		
		System.out.println();
	}

	public static void main(String[] args) {
		_04_CreateStackUsing1Queue_Imp stack = new _04_CreateStackUsing1Queue_Imp();
		stack.push(0);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.printQueue();
		System.out.println("Peek : " + stack.q.peek());

		stack.pop();
		stack.printQueue();
		System.out.println("Peek : " + stack.q.peek());

	}

}
