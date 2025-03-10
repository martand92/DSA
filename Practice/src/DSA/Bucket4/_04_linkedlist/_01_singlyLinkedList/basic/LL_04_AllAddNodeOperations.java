package DSA.Bucket4._04_linkedlist._01_singlyLinkedList.basic;

public class LL_04_AllAddNodeOperations {

	Node head;

	public static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public void addNodeAtStart(int data) {
		Node n = new Node(data);
		if (head != null)
			n.next = head;

		head = n;
	}

	public void addNodeAtEnd(int data) {
		Node n = new Node(data);
		if (head == null)
			head = n;

		else {
			Node n1 = head;

			while (n1.next != null)
				n1 = n1.next;

			n1.next = n;
		}
	}

	// Here 0 is considered as starting position and no of nodes count = last
	// position
	public void addNodeAtPosition(int position, int data) {
		Node newNode = new Node(data);

		Node n = head;
		int count = 0;

		// Counting no of nodes as to check if given position is valid for available
		// nodes
		while (n != null) {
			n = n.next;
			count++;
		}

		System.out.println("Count : " + count);

		// If given position > no of nodes then given position is invalid
		if (position > count)
			System.out.println("As provided position is greater than no of counts, please provide proper position");

		n = head;
		Node prev = head;

		do {

			// Loop till position == 0
			if (position == 0) {

				// When new node to be inserted check if current node is head
				if (n == head) {
					newNode.next = head;
					head = newNode;

				} else {
					prev.next = newNode;
					newNode.next = n;
				}

				break;
			}

			prev = n;
			position--;
			n = n.next;

			// to handle inserting new node at the last
			if (n == null && position == 0)
				prev.next = newNode;

		} while (n != null);

	}

	public void printList() {
		Node n = head;

		while (n != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
	}

	public static void main(String[] args) {
		LL_04_AllAddNodeOperations ll = new LL_04_AllAddNodeOperations();

		ll.addNodeAtStart(4);
		ll.addNodeAtStart(3);
		ll.addNodeAtStart(2);
		ll.addNodeAtStart(1);

		ll.addNodeAtEnd(6);
		ll.addNodeAtEnd(7);

		ll.addNodeAtPosition(0, 0);// at 0 position

		ll.printList();

	}
}
