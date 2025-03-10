package DSA.Bucket4._04_linkedlist._02_doublyLinkedList;

public class _03_ReverseDoublyLL {

	Node head;
	Node temp;
	Node tempNext;

	static class Node {
		int data;
		Node next;
		Node prev;

		Node(int d) {
			data = d;
		}
	}

	public void printlist() {
		Node n = head;
		while (n != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
		System.out.println();
	}

	public void push(int data) {
		Node newNode = new Node(data);
		if (head != null)
			head.prev = newNode;

		newNode.next = head;
		head = newNode;
	}

	public void reverseList() {

		Node n = head;
		Node prev = null;
		Node next = null;

		while (n != null) {
			next = n.next;
			n.next = prev;
			n.prev = next; // additional step in Doubly LL
			prev = n;
			n = next;
		}

		head = prev;
	}

	public static void main(String[] args) {
		_03_ReverseDoublyLL lList = new _03_ReverseDoublyLL();
		lList.push(5);
		lList.push(4);
		lList.push(3);
		lList.push(2);
		lList.push(1);
		lList.printlist();
		lList.reverseList();
		lList.printlist();
	}

}
