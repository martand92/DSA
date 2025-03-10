package DSA.Bucket4._04_linkedlist._01_singlyLinkedList.important;

public class _03_DetectCycle_FastSlow {

	Node head;

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	public void printList() {
		Node n = head;

		do {
			System.out.print(n.data + " ");
			n = n.next;
		} while (n != head);

		System.out.println();
	}

	public void createCycle() {
		Node n = head;
		while (n.next != null) {
			n = n.next;
		}

		n.next = head;
	}

	public boolean hasCycle() {
		Node fast = head;
		Node slow = head;
		fast = fast.next.next;

		while (fast != null && fast.next != null) {

			if (fast == slow)
				return true;

			fast = fast.next.next;
			slow = slow.next;

		}
		return false;
	}

	public void addNode(int data) {
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
	}

	public static void main(String[] args) {
		_03_DetectCycle_FastSlow ll = new _03_DetectCycle_FastSlow();
		ll.addNode(5);
		ll.addNode(4);
		ll.addNode(3);
		ll.addNode(2);
		ll.addNode(1);

		ll.createCycle();

		// ll.printList();

		System.out.println(ll.hasCycle());
	}

}
