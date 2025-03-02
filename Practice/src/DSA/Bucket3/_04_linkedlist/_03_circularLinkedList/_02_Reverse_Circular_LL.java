package DSA.Bucket3._04_linkedlist._03_circularLinkedList;

public class _02_Reverse_Circular_LL {

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

	public void reverseCircularLL() {
		Node current = head;
		Node next = null;
		Node prev = tailNode;

		do {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		} while (current != head);

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

		_02_Reverse_Circular_LL lList = new _02_Reverse_Circular_LL();
		lList.push(6);
		lList.push(5);
		lList.push(4);
		lList.push(3);
		lList.push(2);
		lList.push(1);
		
		lList.printList();
		
		lList.reverseCircularLL();
		
		lList.printList();
	}

}
