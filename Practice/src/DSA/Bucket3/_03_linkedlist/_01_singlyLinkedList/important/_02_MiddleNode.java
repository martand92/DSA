package DSA.Bucket3._03_linkedlist._01_singlyLinkedList.important;

public class _02_MiddleNode {

	Node head;
	int count = 0;

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	public void printList() {
		Node n = head;

		while (n != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}

		System.out.println();
	}

	public void addNode(int data) {
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
	}

	public int getMiddleNode() {

		Node slow = head;
		Node fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow.data;
	}

	public static void main(String[] args) {
		_02_MiddleNode ll = new _02_MiddleNode();
		ll.addNode(6);
		ll.addNode(5);
		ll.addNode(4);
		ll.addNode(3);
		ll.addNode(2);
		ll.addNode(1);

		System.out.println(ll.getMiddleNode());

	}

}
