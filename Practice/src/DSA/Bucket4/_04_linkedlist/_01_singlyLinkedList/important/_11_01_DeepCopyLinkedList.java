package DSA.Bucket4._04_linkedlist._01_singlyLinkedList.important;

import java.util.HashMap;

public class _11_01_DeepCopyLinkedList {

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
		Node n = head;

		while (n != null) {

			System.out.print("data : " + n.data);

			if (n.next != null)
				System.out.print(" next : " + n.next.data);
			else
				System.out.print(" next : " + null);

			if (n.random != null)
				System.out.print(" random : " + n.random.data);
			else
				System.out.print(" random : " + null);

			System.out.println();

			n = n.next;
		}

		System.out.println();
	}

	public Node deepCopy_hashMap() {
		Node headCopy = null;
		HashMap<Node, Node> hm = new HashMap<Node, Node>();

		// Step 1:create copy of each node and store both original and copied nodes in
		// hm
		Node n = head;
		while (n != null) {
			Node newNode = new Node(n.data);
			hm.put(n, newNode);
			n = n.next;
		}

		n = head;

		// Step 2 : start pointing next and random pointers of copied nodes while
		// referring to original ll
		while (n != null) {

			// Get copied node of current node from hm and establish connections
			Node copiedNode = hm.get(n);
			Node copiedNext = hm.get(n.next);
			Node copiedRandom = hm.get(n.random);

			if (n == head)
				headCopy = copiedNode;

			copiedNode.next = copiedNext;
			copiedNode.random = copiedRandom;

			n = n.next;
		}

		return headCopy;
	}

	public static void main(String[] args) {

		_11_01_DeepCopyLinkedList ll = new _11_01_DeepCopyLinkedList();
		ll.addNode(4);
		ll.addNode(3);
		ll.addNode(2);
		ll.addNode(1);

		ll.addRandom();

		ll.printList(ll.head);
		Node head = ll.deepCopy_hashMap();
		ll.printList(head);

	}

}
//TC : O(N) to put to hm + O(N) to poit new node's pointers
//SC: O(N) for hash map