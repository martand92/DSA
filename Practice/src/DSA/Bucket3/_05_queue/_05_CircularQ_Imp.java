package DSA.Bucket3._05_queue;

//Using circular Linked list
public class _05_CircularQ_Imp {

	Node rear;
	Node front;

	public static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	public void enqueue(int d) {

		Node newNode = new Node(d);

		if (rear == null && front == null)
			front = rear = newNode;

		rear.next = newNode;
		rear = newNode;
		newNode.next = front;

	}

	public void dequeue() {
		System.out.println("Popped : " + front.data);
		rear.next = front.next;
		front = front.next;
	}

	public void printQueue() {
		Node n = front;
		do {
			System.out.print(n.data + " ");
			n = n.next;
		} while (n != front);
	}

	public void front() {
		System.out.println("front : " + front.data);
	}

	public void rear() {
		System.out.println("rear : " + rear.data);
	}

	public static void main(String[] args) {
		_05_CircularQ_Imp circlQ = new _05_CircularQ_Imp();
		circlQ.enqueue(0);
		circlQ.enqueue(1);
		circlQ.enqueue(2);
		circlQ.enqueue(3);
		circlQ.enqueue(4);

		circlQ.printQueue();

		circlQ.front();
		circlQ.rear();

		circlQ.dequeue();
		circlQ.front();
		circlQ.rear();
	}

}
