package DSA.Bucket3._03_linkedlist._01_singlyLinkedList.easy;

public class LL_09_DeleteMiddleNode {

	static Node head;

	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	public static void push(int d) {
		Node newNode = new Node(d);
		newNode.next = head;
		head = newNode;
	}

	public static void printList() {
		Node n = head;

		while (n != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}

		System.out.println();
	}

	public static void main(String[] args) {

		push(1);
		push(2);
		push(3);
		push(4);

		Node n = head;
		printList();

		int count = 0, midPos = 0;
		while (n != null) {
			count++;
			n = n.next;
		}
		midPos = ((count + 1) / 2);

		n = head;
		Node prev = null;
		while (midPos != 0) {
			prev = n;
			n = n.next;
			midPos--;
		}
		prev.next = n.next;
		printList();
	}
}