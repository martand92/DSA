package DSA.Bucket3._04_linkedlist._03_circularLinkedList;

public class _01_CircularLinkedListTraversal {
	Node head;

	Node tailNode;

	public static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	public void printList() {
		Node n = head;
		do {
			System.out.println(n.data);
			n = n.next;
		} while (n != head);
	}

	public void push(int data) {
		Node newNode = new Node(data);

		if (head == null)
			tailNode = newNode;

		newNode.next = head;
		head = newNode;
		tailNode.next = head;
	}

	public static void main(String[] args) {
		_01_CircularLinkedListTraversal lList = new _01_CircularLinkedListTraversal();
		lList.push(5);
		lList.push(4);
		lList.push(3);
		lList.push(2);
		lList.push(1);

		lList.printList();
	}
}
