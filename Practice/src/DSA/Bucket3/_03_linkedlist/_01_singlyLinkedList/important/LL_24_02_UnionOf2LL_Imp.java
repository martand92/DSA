package DSA.Bucket3._03_linkedlist._01_singlyLinkedList.important;

//https://practice.geeksforgeeks.org/problems/union-of-two-linked-list/1
public class LL_24_02_UnionOf2LL_Imp {
	Node head1;
	Node head2;
	Node head;

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

		System.out.println();
	}

	public int findLength(Node head) {

		Node n = head;
		int len = 0;

		while (n != null) {
			len++;
			n = n.next;
		}
		return len;
	}

	public Node mergeSort(Node left, Node right) {

		Node sortedList = null;

		if (left == null)
			return right;

		if (right == null)
			return left;

		if (left.data <= right.data) {
			sortedList = left; // assign left node to sorted LL
			sortedList.next = mergeSort(left.next, right);

		} else if (left.data > right.data) {
			sortedList = right; // assign right node to sorted LL
			sortedList.next = mergeSort(left, right.next);
		}

		return sortedList;
	}

	public Node findMid(Node head, int len) {
		Node n = head;
		len = (len / 2) - 1;

		while (len > 0) {
			n = n.next;
			len--;
		}

		return n;
	}

	public Node divideLL(Node head) {

		int len = findLength(head);

		if (len < 2)
			return head;

		Node mid = findMid(head, len);
		Node nextToMid = mid.next;
		mid.next = null;

		Node left = divideLL(head);
		Node right = divideLL(nextToMid);

		Node sortedList = mergeSort(left, right);
		return sortedList;
	}

	public Node mergeTwoLL(Node first, Node second) {

		head = first;

		while (first.next != null)
			first = first.next;

		first.next = second;

		printList(head);
		return head;
	}

	public Node removeDup(Node head) {

		Node n = head;

		while (n.next != null) {
			if (n.data == n.next.data)
				n.next = n.next.next;
			else
				n = n.next;
		}

		return head;
	}

	public Node unionOfLL(Node first, Node second) {

		// merge both LL
		Node head = mergeTwoLL(first, second);

		// Divide LL recursively by half & do MergeSort
		head = divideLL(head);

		// Remove duplicates from sorted list
		return removeDup(head);
	}

	public static void main(String[] args) {

		LL_24_02_UnionOf2LL_Imp lList = new LL_24_02_UnionOf2LL_Imp();
//		lList.push1(8);
//		lList.push1(3);
//		lList.push1(2);
//		lList.push1(4);
//		lList.push1(6);
//		lList.push1(9);
//
//		lList.push2(2);
//		lList.push2(6);
//		lList.push2(8);
//		lList.push2(2);
//		lList.push2(1);

		lList.push1(9);
		lList.push1(4);
		lList.push1(4);
		lList.push1(4);
		lList.push1(3);
		lList.push1(2);

		lList.push2(8);
		lList.push2(6);
		lList.push2(4);
		lList.push2(2);
		lList.push2(1);

		printList(lList.head1);
		printList(lList.head2);

		lList.head = lList.unionOfLL(lList.head1, lList.head2);

		printList(lList.head);

	}
}
