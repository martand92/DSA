package DSA.Bucket4._04_linkedlist._01_singlyLinkedList.important;

//https://www.youtube.com/watch?v=Lhu3MsXZy-Q

//Fast & Slow Algo is also know as Tortoise & Hare algo as Hare moves twice as fast as Tortoise
public class _01_DeleteNthNodeFromLast_FastSlow {

	Node head;
	int count = 0;

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	public void addNode(int data) {
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
	}

	public void printList() {
		Node n = head;

		while (n != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}

		System.out.println();
	}

	public void deleteNthNodeFromLast(int pos) {

		Node fast = head;
		Node slow = head;

		while (pos > 0) {
			fast = fast.next;
			pos--;
		}

		while (fast != null && fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}

		if (slow == head)
			head = head.next;
		else
			slow.next = slow.next.next;

	}

	public static void main(String[] args) {
		_01_DeleteNthNodeFromLast_FastSlow ll = new _01_DeleteNthNodeFromLast_FastSlow();
		ll.addNode(5);
		ll.addNode(4);
		ll.addNode(3);
		ll.addNode(2);
		ll.addNode(1);

		ll.printList();
		ll.deleteNthNodeFromLast(5);
		ll.printList();
	}

}

//TC: O(N). 