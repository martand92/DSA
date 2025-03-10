package DSA.Bucket4._04_linkedlist._03_circularLinkedList;

public class _06_IsLLCircular {
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

	public void printList() {
		Node n = head;

		do {
			System.out.print(n.data + " ");
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

	public void push1(int data) {
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
	}

	public void isLinkedListCircular() {
		Node n = head;
		boolean isCircular = true;

		do {

			if (n == null)
				isCircular = false;

			n = n.next;

		} while (n != head);

		if (isCircular)
			System.out.println("List is circular");
		else
			System.out.println("List is not circular");

	}

	public static void main(String[] args) {
		_06_IsLLCircular lList = new _06_IsLLCircular();

		lList.push(5);
		lList.push(4);
		lList.push(3);
		lList.push(2);
		lList.push(1);
		lList.printList();
		lList.isLinkedListCircular();

		System.out.println("Adding nodes again");

		// LL_4_IsLLCircular lList1 = new LL_4_IsLLCircular();
		lList.head = null;
		lList.push1(5);
		lList.push1(4);
		lList.push1(3);
		lList.push1(2);
		lList.push1(1);

		lList.isLinkedListCircular();

	}

}
