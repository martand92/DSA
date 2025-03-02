package DSA.Bucket3._04_linkedlist._01_singlyLinkedList.important;

//https://practice.geeksforgeeks.org/problems/intersection-of-two-sorted-linked-lists/1
public class LL_21_CommonEleInSortedLL_With2Pointer_Optimized {
	Node head1;
	Node head2;

	public static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	public void push1(int d) {
		Node newNode = new Node(d);
		newNode.next = head1;
		head1 = newNode;
	}

	public void push2(int d) {
		Node newNode = new Node(d);
		newNode.next = head2;
		head2 = newNode;
	}

	public static void printList(Node head) {
		Node n = head;

		while (n != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
	}

	public void findCommonElements(Node first, Node second) {

		Node head = null;
		Node prev = null;

		while (head1 != null && head2 != null) {

			if (head1.data < head2.data)
				head1 = head1.next;

			else if (head1.data > head2.data)
				head2 = head2.next;

			else {
				Node newNode = new Node(head1.data);

				if (head == null)
					head = newNode;
				else
					prev.next = newNode;

				prev = newNode;

				head1 = head1.next;
				head2 = head2.next;
			}
		}

		printList(head);
	}

	public static void main(String[] args) {

		LL_21_CommonEleInSortedLL_With2Pointer_Optimized lList = new LL_21_CommonEleInSortedLL_With2Pointer_Optimized();
		lList.push1(50);
		lList.push1(40);
		lList.push1(40);
		lList.push1(20);
		lList.push1(15);
		lList.push1(10);

		lList.push2(40);
		lList.push2(40);
		lList.push2(15);

		lList.findCommonElements(lList.head1, lList.head2);

	}
}
