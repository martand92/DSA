package DSA._05_Create_Stack_Queue._05_Create_PQ;

public class _08_PriorityQUsingDoublyLinkedList {

	Node front;
	Node rear;
	boolean inserted = false;

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

	public void push(int d) {
		inserted = false;
		Node newNode = new Node(d);

		if (front == null)
			front = rear = newNode;

		else {
			Node n = front;
			while (n != null) {

				if (n.data > newNode.data) {

					if (n == front)
						front = newNode;

					else {
						newNode.prev = n.prev;
						n.prev.next = newNode;
					}

					n.prev = newNode;
					newNode.next = n;
					inserted = true;
					break;
				}

				n = n.next;
			}

			if (!inserted) {
				newNode.prev = rear;
				rear.next = newNode;
				rear = newNode;
			}
		}
	}

	public void pop() {
		if (front != null) {
			System.out.println("Popped : " + front.data);
			front = front.next;
			front.prev = null;
		} else
			System.out.println("Popped : " + front);
	}

	public void peek() {
		System.out.println("front : " + front.data);
	}

	public void rear() {
		System.out.println("rear : " + rear.data);
	}

	public void printQueue() {
		Node n = front;
		while (n != null) {
			System.out.println(n.data);
			n = n.next;
		}
	}

	public static void main(String[] args) {
		_08_PriorityQUsingDoublyLinkedList queue = new _08_PriorityQUsingDoublyLinkedList();
		queue.push(0);
		queue.push(1);
		queue.push(4);
		queue.push(3);
		queue.push(2);
		queue.printQueue();
		queue.peek();
		queue.rear();

		queue.pop();
		queue.printQueue();
		queue.peek();
		queue.rear();

	}

}
