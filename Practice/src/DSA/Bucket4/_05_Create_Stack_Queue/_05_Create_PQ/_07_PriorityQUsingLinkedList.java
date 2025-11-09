package DSA.Bucket4._05_Create_Stack_Queue._05_Create_PQ;

//Basically to insert in an order (Ascending)
public class _07_PriorityQUsingLinkedList {
	Node front;
	Node rear;
	Node prev;
	boolean inserted = false;

	public static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	public void push(int d) {
		Node newNode = new Node(d);
		inserted = false;

		if (front == null)
			front = rear = newNode;

		else {
			Node n = front;

			while (n != null) {
				if (n.data > newNode.data) {
					if (n == front)
						front = newNode;
					else
						prev.next = newNode;

					newNode.next = n;
					inserted = true;
					break;
				}
				prev = n;
				n = n.next;
			}
			if (!inserted) {
				prev.next = newNode;
				rear = newNode;
			}
		}
	}

	public void pop() {
		System.out.println("Popped :" + front.data);
		front = front.next;
	}

	public void peek() {
		System.out.println("Peek or Rear element : " + rear.data);
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
		_07_PriorityQUsingLinkedList pQue = new _07_PriorityQUsingLinkedList();
		pQue.push(3);
		pQue.push(1);
		pQue.push(2);
		pQue.push(4);
		pQue.push(0);

		pQue.peek();

		pQue.printQueue();

		pQue.pop();

	}

}
