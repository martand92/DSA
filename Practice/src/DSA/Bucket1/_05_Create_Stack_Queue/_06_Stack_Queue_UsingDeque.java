package DSA.Bucket1._05_Create_Stack_Queue;

import java.util.ArrayDeque;
import java.util.*;

public class _06_Stack_Queue_UsingDeque {
	Node front;
	Node rear;
	Node prev;

	public static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	public void addFirst(_06_Stack_Queue_UsingDeque q, int data) { // to add Node n to
																	// deque q
		Node newNode = new Node(data);
		if (q.front == null)
			q.front = q.rear = newNode;
		else {
			newNode.next = q.front;
			q.front = newNode;
		}

	}

	public _06_Stack_Queue_UsingDeque addLast(_06_Stack_Queue_UsingDeque q, int data) {
		Node newNode = new Node(data);
		if (q.front == null)
			q.front = q.rear = newNode;
		else {
			q.rear.next = newNode;
			q.rear = newNode;
		}
		return q;
	}

	public void removeFirst(_06_Stack_Queue_UsingDeque q) {
		System.out.println("Removing first : " + q.front.data);
		q.front = q.front.next;

	}

	public void removeLast(_06_Stack_Queue_UsingDeque q) {
		Node n = q.front;
		while (n.next != null) {
			q.prev = n;
			n = n.next;
		}
		System.out.println("Removing last : " + n.data);
		q.rear = q.prev;
		q.prev.next = null;
	}

	public void front(_06_Stack_Queue_UsingDeque q) {
		System.out.println("front : " + q.front.data);
	}

	public void rear(_06_Stack_Queue_UsingDeque q) {
		System.out.println("rear : " + q.rear.data);
	}

	public void printQueue(_06_Stack_Queue_UsingDeque q) {
		Node n = q.front;
		while (n != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
	}

	public static void main(String[] args) {

		Stack stack = new Stack();
		Queue queue = new Queue();

		stack.push(0);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.printStack();
		stack.top();

		queue.enqueue(0);
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.printQueue();
		queue.front();
		queue.rear();
	}

}

class Stack {
	_06_Stack_Queue_UsingDeque stackDeq = new _06_Stack_Queue_UsingDeque();

	public void push(int d) {
		stackDeq.addFirst(stackDeq, d);
	}

	public void pop() {
		stackDeq.removeFirst(stackDeq);
	}

	public void top() {
		stackDeq.front(stackDeq);
	}

	public void printStack() {
		stackDeq.printQueue(stackDeq);
	}

}

class Queue {
	_06_Stack_Queue_UsingDeque queueDeq = new _06_Stack_Queue_UsingDeque();

	public void enqueue(int d) {
		queueDeq.addLast(queueDeq, d);
	}

	public void dequeue() {
		queueDeq.removeFirst(queueDeq);
	}

	public void front() {
		queueDeq.front(queueDeq);
	}

	public void rear() {
		queueDeq.rear(queueDeq);
	}

	public void printQueue() {
		queueDeq.printQueue(queueDeq);
	}
}
