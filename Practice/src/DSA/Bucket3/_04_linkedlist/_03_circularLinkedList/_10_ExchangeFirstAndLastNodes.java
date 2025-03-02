package DSA.Bucket3._04_linkedlist._03_circularLinkedList;

public class _10_ExchangeFirstAndLastNodes {

	Node head;
	Node tailNode;
	int count = 0;
	Node prev;

	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	public void push(int data) {
		Node newNode = new Node(data);

		if (head == null)
			tailNode = newNode;

		newNode.next = head;
		head = newNode;
		tailNode.next = head;
	}

	public void printList() {
		Node n = head;
		if (head != null) {
			do {
				System.out.print(n.data + " ");
				n = n.next;
			} while (n != head);
		}
	}

	public void exchange() {
		System.out.println();
		Node n = head;

		do {
			prev = n;
			n = n.next;

		} while (n.next != head);

		prev.next = head;
		n.next = head.next;
		head.next = n;
		head = n;
	}

	public static void main(String[] args) {
		_10_ExchangeFirstAndLastNodes lList = new _10_ExchangeFirstAndLastNodes();
		lList.push(5);
		lList.push(4);
		lList.push(3);
		lList.push(2);
		lList.push(1);

		lList.printList();

		lList.exchange();

		lList.printList();
	}

}
