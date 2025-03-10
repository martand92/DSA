package DSA.Bucket4._04_linkedlist._03_circularLinkedList;

public class _03_Delete_Reverse_Circular_LL {

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

	public void deleteNode(int key) {
		Node n = head;
		Node prev = null;

		do {
			if (n.data == key) {
				prev.next = n.next;
				break;
			}
			prev = n;
			n = n.next;
		} while (n != head);
	}

	public void reverseCircularLL() {
		Node n = head;
		Node next = null;

		do {
			n = n.next;
		} while (n.next != head);

		// point tail as prev
		Node prev = n;

		n = head;

		do {
			next = n.next;
			n.next = prev;
			prev = n;
			n = next;
		} while (n != head);

		head = prev;

	}

	public void printList() {

		Node n = head;

		do {
			System.out.print(n.data + " ");
			n = n.next;
		} while (n != head);

		System.out.println();
	}

	public static void main(String[] args) {

		_03_Delete_Reverse_Circular_LL lList = new _03_Delete_Reverse_Circular_LL();

		int key = 2;

		lList.push(6);
		lList.push(5);
		lList.push(4);
		lList.push(3);
		lList.push(2);
		lList.push(1);

		lList.deleteNode(key);

		lList.printList();

		lList.reverseCircularLL();

		lList.printList();
	}

}
