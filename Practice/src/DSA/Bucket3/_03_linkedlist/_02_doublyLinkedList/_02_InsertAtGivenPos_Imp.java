package DSA.Bucket3._03_linkedlist._02_doublyLinkedList;

public class _02_InsertAtGivenPos_Imp {

	Node head;
	int len = 0;

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
			len++;
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

	public void addNode(int pos, int data) {

		Node n = head;
		Node prev = null;

		if (pos > len) {
			System.out.println("invalid pos, pos out of range");
			return;
		}

		while (pos != 0 && n != null) {
			prev = n;
			n = n.next;
			pos--;
		}

		Node newNode = new Node(data);

		if (n == null) {
			prev.next = newNode;
			prev = newNode.prev;
			printlist();
			return;
		}

		if (n == head) {
			newNode.next = n;
			head = newNode;

		} else {
			newNode.next = n;
			n.prev.next = newNode;
			newNode.prev = n.prev;
		}

		n.prev = newNode;

		printlist();
	}

	public static void main(String[] args) {
		_02_InsertAtGivenPos_Imp lList = new _02_InsertAtGivenPos_Imp();

		lList.push(5);
		lList.push(4);
		lList.push(3);
		lList.push(2);
		lList.push(1);

		lList.printlist();

		lList.addNode(6, 44);

	}

}
