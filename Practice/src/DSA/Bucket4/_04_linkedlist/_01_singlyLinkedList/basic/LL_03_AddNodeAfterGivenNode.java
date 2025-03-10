package DSA.Bucket4._04_linkedlist._01_singlyLinkedList.basic;

public class LL_03_AddNodeAfterGivenNode {
	Node head;

	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	public static void main(String[] args) {
		LL_03_AddNodeAfterGivenNode linkedList = new LL_03_AddNodeAfterGivenNode();
		linkedList.head = new Node(0);
		Node second = new Node(1);
		linkedList.head.next = second;
		Node third = new Node(2);
		second.next = third;
		Node fourth = new Node(3);
		third.next = fourth;
		Node fifth = new Node(4);
		fourth.next = fifth;

		Node n = linkedList.head;
		while (n != null) {
			System.out.println(n.data);
			n = n.next;
		}

		linkedList.addingNode(3);
	}

	public void addingNode(int position) {
		System.out.println("Adding new node");
		Node n = head;
		Node newNode = new Node(5);
		int i = 0;
		while (i < position-1) {
			n = n.next;
			i++;
		}

		// first add initial nth next reference node to newNode's "next" and then point
		// nth node to newnode : n-> newnode -> nthinitialrefNode
		newNode.next = n.next;
		n.next = newNode;

		Node k = head;
		while (k != null) {
			System.out.println(k.data);
			k = k.next;
		}

	}

}
