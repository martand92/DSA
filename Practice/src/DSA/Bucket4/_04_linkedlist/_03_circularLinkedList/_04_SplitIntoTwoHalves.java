package DSA.Bucket4._04_linkedlist._03_circularLinkedList;

public class _04_SplitIntoTwoHalves {

	Node head;
	Node head1;
	Node tailNode;
	
	int length = 0;

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
		length++;
	}

	public void splitIntoTwoHalves() {
		Node n = head;
		for (int i = 0; i < (length / 2) - 1; i++) {
			n = n.next;
		}
		head1 = n.next;
		n.next = head;
		tailNode.next = head1;

	}

	public void printList() {
		Node n  = head;
		do {
			System.out.println(n.data);
			n = n.next;
		} while (n != head);
		
		n = head1;
		do {
			System.out.println(n.data);
			n = n.next;
		} while (n != head1);
	}

	public static void main(String[] args) {

		_04_SplitIntoTwoHalves lList = new _04_SplitIntoTwoHalves();
		lList.push(6);
		lList.push(5);
		lList.push(4);
		lList.push(3);
		lList.push(2);
		lList.push(1);
		lList.splitIntoTwoHalves();
		lList.printList();
	}

}
