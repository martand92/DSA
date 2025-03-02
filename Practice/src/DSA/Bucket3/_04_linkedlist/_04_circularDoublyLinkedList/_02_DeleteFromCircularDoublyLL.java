package DSA.Bucket3._04_linkedlist._04_circularDoublyLinkedList;

public class _02_DeleteFromCircularDoublyLL {
	Node head;
	Node tailNode;

	public static class Node {
		int data;
		Node next;
		Node prev;

		Node(int d) {
			data = d;
		}
	}

	public void printList() {
		System.out.println();
		Node n = head;
		do {
			System.out.print(n.data + ",");
			n = n.next;
		} while (n != head);
	}

	public void push(int data) {
		Node newNode = new Node(data);

		if (head != null)
			head.prev = newNode;
		else {
			tailNode = newNode;
		}

		newNode.next = head;
		newNode.prev = tailNode;
		head = newNode;
		tailNode.next = newNode;

	}

	public void delete(int d) {
		Node n = head;
		do {
			if (n.data == d) {
				n.prev.next = n.next;
				n.next.prev = n.prev;
				if (n == head)
					head = n.next;
			}
			n = n.next;
		} while (n != head);
	}

	public static void main(String[] args) {

		_02_DeleteFromCircularDoublyLL lList = new _02_DeleteFromCircularDoublyLL();
		lList.push(5);
		lList.push(4);
		lList.push(3);
		lList.push(2);
		lList.push(1);

		lList.printList();
		lList.delete(1);
		lList.printList();
	}
}
