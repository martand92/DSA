package DSA._04_linkedlist._01_singlyLinkedList.basic;

public class LL_01_SimpleLinkedList {
	// First declare a reference to head node
	Node head;

	static class Node {
		int data;
		Node next;

		Node(int d) {
			this.data = d;
			this.next = null;
		}
	}

	public void printList() {
		Node n = head;

		while (n != null) {
			System.out.println(n.data);
			n = n.next; // here basically updating reference 'n' to point to next node as "next" stores
						// reference to next node
		}
	}

	public static void main(String[] args) {
		LL_01_SimpleLinkedList lList = new LL_01_SimpleLinkedList();

		lList.head = new Node(1); // for first node storing data
		Node second = new Node(2); // for second node storing data
		Node third = new Node(3); // for third node storing data
		lList.head.next = second; // for first node having second node's reference
		second.next = third; // for second node having third node's reference
		lList.printList();

		Node n = lList.head;
		while (n != null) {
			n = n.next; 
		}

	}

}
