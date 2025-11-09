package DSA.Bucket3._03_linkedlist._03_circularLinkedList;

public class _09_AddingAndDeletingNodeInBetween {

	Node head;
	Node tailNode;
	int length = 0;
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
		length = 0;
		Node n = head;
		if (head != null) {
			do {
				System.out.print(n.data + " ");
				n = n.next;
				length++;
			} while (n != head);
		}
	}

	public void addInBetween(int d) {
		System.out.println();
		System.out.print("Adding Node in between : ");
		Node newNode = new Node(d);

		Node n = head;

		for (int i = 0; i < length / 2 - 1; i++) {
			n = n.next;
		}
		newNode.next = n.next;
		n.next = newNode;
	}

	public void deleteInBetween() {
		System.out.println();
		System.out.print("Deleting Node in between : ");

		Node n = head;

		for (int i = 0; i < length / 2; i++) {
			prev = n;
			n = n.next;
		}
		prev.next = n.next;

	}

	public static void main(String[] args) {
		_09_AddingAndDeletingNodeInBetween lList = new _09_AddingAndDeletingNodeInBetween();
		// lList.push(5);
		lList.push(4);
		lList.push(3);
		lList.push(2);
		lList.push(1);

		lList.printList();

		lList.addInBetween(6);
		lList.printList();
		lList.deleteInBetween();
		lList.printList();
	}
}
