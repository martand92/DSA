package DSA.Bucket3._03_linkedlist._03_circularLinkedList;

public class _05_SortedInsert {

	Node head;
	Node tailNode;

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
		do {
			System.out.print(n.data + " ");
			n = n.next;
		} while (n != head);
	}

	public void sortInsert(int data) {
		System.out.println("Inserting data");
		Node n = head;
		Node prev = null;

		Node newNode = new Node(data);
		boolean inserted = false;

		do {

			if (n.data > data) {

				if (n == head) {
					newNode.next = head;
					head = newNode;
					tailNode.next = head;

				} else {
					prev.next = newNode;
					newNode.next = n;
				}

				inserted = true;

				break;
			}

			prev = n;
			n = n.next;

		} while (n != head);

		// if loop ends without inserting as provided data > tail node data
		if (!inserted) {
			prev.next = newNode;
			newNode.next = head;
			tailNode = newNode;
		}

	}

	public static void main(String[] args) {
		_05_SortedInsert lList = new _05_SortedInsert();
		lList.push(5);
		lList.push(4);
		lList.push(2);
		lList.push(1);
		lList.printList();
		System.out.println();
		lList.sortInsert(6);
		lList.printList();

	}

}
