package DSA._04_linkedlist._01_singlyLinkedList.important;

public class _11_02_DeepCopyLinkedList {

	Node head;

	static class Node {
		int data;
		Node next;
		Node random;

		Node(int data) {
			this.data = data;
			this.next = null;
			this.random = null;
		}
	}

	public void addNode(int data) {
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
	}

	public void addRandom() {
		Node n = head;
		n.random = n.next.next.next;
		n = n.next;
		n.random = head;
		n = n.next.next;
		n.random = head.next;
	}

	public void printList(Node head) {
		System.out.println();
		Node n = head;

		while (n != null) {

			System.out.print("data:" + n.data);

			if (n.next != null)
				System.out.print(" next:" + n.next.data);
			else
				System.out.print(" next:" + null);

			if (n.random != null)
				System.out.print(" random:" + n.random.data);
			else
				System.out.print(" random:" + null);

			System.out.println();

			n = n.next;
		}

		System.out.println();
	}

	public Node deepCopy() {

		Node headCopy = null;

		// Step 1 : Create new cloned node for each and add it next to existing node
		Node n = head;
		while (n != null) {
			Node newNode = new Node(n.data);
			newNode.next = n.next;
			n.next = newNode;
			n = n.next.next;
		}

		n = head;

		// Step 2 : point random of new nodes to new node of existing linkedlist
		// random's
		while (n != null && n.next != null) {

			if (n.random == null)
				n.next.random = null;// here n.next points to new node
			else
				n.next.random = n.random.next;

			n = n.next.next;
		}


		// Step 3 : need to point back old node's next to its original neighbors
		// instead of new nodes and new nodes to its new neighboring nodes
		n = head;
		headCopy = n.next;
		Node ncopy = null;
		Node next = null;

		while (n != null && n.next != null) {

			ncopy = n.next;
			next = n.next.next; // pointing to next old node

			n.next = next;

			if (next != null)
				ncopy.next = next.next;
			else
				ncopy.next = next;

			n = next;
		}

		return headCopy;
	}

	public static void main(String[] args) {

		_11_02_DeepCopyLinkedList ll = new _11_02_DeepCopyLinkedList();
		ll.addNode(4);
		ll.addNode(3);
		ll.addNode(2);
		ll.addNode(1);

		ll.addRandom();

		ll.printList(ll.head);
		Node head = ll.deepCopy();
		ll.printList(head);

	}

}
//TC : O(3N) for each step
//SC: O(1)