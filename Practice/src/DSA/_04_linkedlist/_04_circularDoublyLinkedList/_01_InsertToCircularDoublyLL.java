package DSA._04_linkedlist._04_circularDoublyLinkedList;

public class _01_InsertToCircularDoublyLL {
	Node head;
	Node tailNode;

	public static class Node {
		int data;
		Node prev;
		Node next;

		Node(int d) {
			data = d;
		}
	}

	public void push(int data) {
		Node newNode = new Node(data);
		
		if (head != null)
			head.prev = newNode;
		else
			tailNode = newNode;

		newNode.next = head;
		newNode.prev = tailNode;
		head = newNode;
		tailNode.next = newNode;
	}

	public void printList() {
		Node n = head;

		do {
			System.out.println(n.data);
			n = n.next;

		} while (n != head);

//		while (n != null) {
//			System.out.println(n.data);
//			n = n.next;
//		}
	}

	public static void main(String[] args) {
		_01_InsertToCircularDoublyLL lList = new _01_InsertToCircularDoublyLL();
		lList.push(5);
		lList.push(4);
		lList.push(3);
		lList.push(2);
		lList.push(1);
		lList.printList();

	}

}
