package DSA.Bucket3._03_linkedlist._03_circularLinkedList;

public class _11_CountNodes {

	Node head;
	Node tailNode;
	int count = 0;

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

	public void countNodes() {
		Node n = head;

		do {
			n = n.next;
			count++;
		} while (n != head);
		System.out.println();
		System.out.println("Count : " + count);
	}

	public static void main(String[] args) {
		_11_CountNodes lList = new _11_CountNodes();
		lList.push(5);
		lList.push(4);
		lList.push(3);
		lList.push(2);
		lList.push(1);

		lList.printList();

		lList.countNodes();
	}

}
