package DSA.Bucket1._05_Create_Stack_Queue._02_Create_Stack_Q_UsingLinkedList;

public class _02_Q_UsingLL {

	Node front;
	Node rear;
	int size;
	final int MAX = 5;

	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	public void enqueue(int d) {

		if (size == MAX)
			System.out.println("Queue Overflow");

		else {
			Node newNode = new Node(d);
			if (front == null)
				front = newNode;
			else
				rear.next = newNode;
			
			rear = newNode;
			size++;
		}
	}

	public void dequeue() {
		if (size == 0)
			System.out.println("Queue Underflow");
		else {
			System.out.println("Dequeued : " + front.data);
			front = front.next;
			size--;
		}
	}

	public void rear() {
		System.out.println("Rear : " + rear.data);
	}

	public void front() {
		System.out.println("Front : " + front.data);
	}

	public void isEmpty() {
		if (size == 0)
			System.out.println("Queue is Empty");
		else
			System.out.println("Queue is not Empty");
	}

	public void isFull() {
		if (size == MAX)
			System.out.println("Queue is Full");
		else
			System.out.println("Queue is not Full");
	}

	public void printQueue() {
		Node n = front;
		while (n != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		_02_Q_UsingLL queue = new _02_Q_UsingLL();
		queue.enqueue(0);
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.printQueue();
		queue.front();
		queue.rear();

		queue.dequeue();
		queue.printQueue();
		queue.front();
		queue.rear();

		queue.isFull();
		queue.isEmpty();

	}

}
