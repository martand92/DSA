package DSA._04_linkedlist._03_circularLinkedList;

public class _07_AddingAndDeletingNodeAtStart {

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

	public void printList() {

		Node n = head;
		if (head != null) {
			do {
				System.out.print(n.data + " ");
				n = n.next;
			} while (n != head);
		}
	}

	public void addHead(int data) {
		System.out.println();
		System.out.print("Adding head : ");
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
		tailNode.next = head;
	}

	public void deleteHead() {
		System.out.println();
		System.out.print("Deleting head : ");
		Node n = head;
		n = n.next;
		tailNode.next = n;
		head = n;
	}

	public static void main(String[] args) {
		_07_AddingAndDeletingNodeAtStart lList = new _07_AddingAndDeletingNodeAtStart();
		lList.push(5);
		lList.push(4);
		lList.push(3);
		lList.push(2);
		lList.push(1);

		lList.printList();

		lList.addHead(0);
		lList.printList();
		lList.deleteHead();
		lList.printList();
	}

}
