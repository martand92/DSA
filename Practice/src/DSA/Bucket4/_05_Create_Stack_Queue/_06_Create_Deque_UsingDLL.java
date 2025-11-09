package DSA.Bucket4._05_Create_Stack_Queue;

public class _06_Create_Deque_UsingDLL {

	Node front;
	Node rear;
	int size = 0;

	static class Node {
		int data;
		Node next;
		Node prev;

		Node(int d) {
			data = d;
			next = null;
			prev = null;
		}
	}

	public void insert(int d) { // same as insert rear
		Node newNode = new Node(d);
		if (front == null) {
			front = rear = newNode;
		} else {
			rear.next = newNode;
			newNode.prev = rear;
			rear = newNode;
		}
		size++;
	}

	public void insertFront(int d) {
		Node newNode = new Node(d);
		if (front == null)
			front = rear = newNode;
		else {
			front.prev = newNode;
			newNode.next = front;
			front = newNode;
		}
		size++;
	}

	public void insertRear(int d) {
		Node newNode = new Node(d);
		if (front == null)
			front = rear = newNode;
		else {
			rear.next = newNode;
			newNode.prev = rear;
			rear = newNode;
		}
		size++;
	}

	public void deleteFront() {
		if (front == null)
			System.out.println("Q is empty");
		else {
			System.out.println("Deleting : " + front.data);
			front = front.next;
			front.prev = null;
			size--;
		}

	}

	public void deleteRear() {
		if (rear == null)
			System.out.println("Q is empty");
		else {
			System.out.println("Deleting : " + rear.data);
			rear = rear.prev;
			rear.next = null;
			size--;
		}
	}

	public void getFront() {
		if (front != null)
			System.out.println("front : " + front.data);
		else
			System.out.println("front : " + front);

	}

	public void getRear() {
		if (rear != null)
			System.out.println("rear : " + rear.data);
		else
			System.out.println("rear : " + rear);

	}

	public void isEmpty() {
		if (front == null)
			System.out.println("Q is empty");
	}

	public void size() {
		System.out.println("Size : " + size);
	}

	public void erase() {
		front = null;
		rear = null;
		size = 0;

	}

	public void printQueue() {
		Node n = front;

		while (n != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
	}

	public static void main(String[] args) {
		_06_Create_Deque_UsingDLL queue = new _06_Create_Deque_UsingDLL();
		queue.insertFront(1);
		queue.insertFront(0);
		queue.insertRear(2);
		queue.insertRear(3);
		queue.insertRear(4);
		queue.insertRear(5);
		queue.insertRear(6);
		queue.printQueue();

		queue.size();
		queue.getFront();
		queue.getRear();

		queue.deleteFront();
		queue.deleteRear();
		queue.printQueue();

		queue.size();
		queue.getFront();
		queue.getRear();

	}

}
