package DSA._04_linkedlist._03_circularLinkedList;

public class _08_AddingAndDeletingNodeAtLast {

	Node head;
	Node tailNode;
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

	public void addTail(int d) {
		System.out.println();
		System.out.print("Adding tail node : ");
		Node newNode = new Node(d);

		tailNode.next = newNode;
		newNode.next = head;
		tailNode = newNode;
	}

	public void deleteTail() {
		System.out.println();
		System.out.print("Deleting tail node : ");
		Node n = head;

		do {
			if (n.next == head) {
				prev.next = head;
				tailNode = prev;
				break;
			}
			prev = n;
			n = n.next;
		} while (n != head);
	}

	public static void main(String[] args) {
		_08_AddingAndDeletingNodeAtLast lList = new _08_AddingAndDeletingNodeAtLast();
		lList.push(5);
		lList.push(4);
		lList.push(3);
		lList.push(2);
		lList.push(1);

		lList.printList();

		lList.addTail(6);
		lList.printList();
		lList.deleteTail();
		lList.printList();
	}
}
