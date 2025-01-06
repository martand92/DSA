package DSA._04_linkedlist._01_singlyLinkedList.easy;

public class LL_15_MoveLastNodeToFirst {
	static Node head;

	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	public static void push(int data) {
		Node n = new Node(data);
		n.next = head;
		head = n;

	}

	public static void main(String[] args) {

		push(5);
		push(4);
		push(3);
		push(2);
		push(1);

		Node n = head;
		Node prev = null;

		while (n.next != null) {
			prev = n;
			n = n.next;
		}

		if (n == head)
			return;

		prev.next = null;
		n.next = head;
		head = n;

		n = head;
		while (n != null) {
			System.out.println(n.data);
			n = n.next;
		}

	}

}