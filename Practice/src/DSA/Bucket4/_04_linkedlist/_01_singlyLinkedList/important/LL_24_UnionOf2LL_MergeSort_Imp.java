package DSA.Bucket4._04_linkedlist._01_singlyLinkedList.important;

//https://practice.geeksforgeeks.org/problems/union-of-two-linked-list/1
public class LL_24_UnionOf2LL_MergeSort_Imp {
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

	public Node mergeTwoLL(Node first, Node second) {

		head = first;

		while (first.next != null)
			first = first.next;

		first.next = second;

		printList(head);
		return head;
	}

	public Node divideLL(Node head) {

		int len = findLength(head);

		if (len == 1)
			return head;

		int ptr = 0;

		Node n = head;

		while (ptr < (len / 2) - 1) {
			n = n.next;
			ptr++;
		}

		Node nextofmiddle = n.next;
		n.next = null;

		Node left = divideLL(head);
		Node right = divideLL(nextofmiddle);

		Node sortedList = mergeSort(left, right);
		return sortedList;

	}

	public Node mergeSort(Node left, Node right) {
		Node n1 = left;
		Node n2 = right;
		Node resultHead = null;
		Node resultptr = null;

		while (n1 != null && n2 != null) {

			if (n1.data < n2.data) {

				if (resultHead == null) {
					resultHead = n1;
					resultptr = n1;

				} else {
					resultptr.next = n1;
					resultptr = resultptr.next;
				}

				n1 = n1.next;

			} else if (n1.data > n2.data) {

				if (resultHead == null) {
					resultHead = n2;
					resultptr = n2;
				} else {
					resultptr.next = n2;
					resultptr = resultptr.next;
				}

				n2 = n2.next;

			} else {

				if (resultHead == null) {
					resultHead = n2;
					resultptr = n2;
				} else {
					resultptr.next = n2;
					resultptr = resultptr.next;
				}

				n1 = n1.next;
				n2 = n2.next;
			}

			// resultptr = resultptr.next;
		}

		while (n1 != null) {

			if (resultHead == null) {
				resultHead = n1;
				resultptr = n1;
			} else {
				resultptr.next = n1;
				resultptr = resultptr.next;
			}

			n1 = n1.next;

			// resultptr = resultptr.next;
		}

		while (n2 != null) {

			if (resultHead == null) {
				resultHead = n2;
				resultptr = n2;
			} else {
				resultptr.next = n2;
				resultptr = resultptr.next;
			}

			n2 = n2.next;

			// resultptr = resultptr.next;
		}

		return resultHead;
	}

	public Node unionOfLL(Node first, Node second) {
		// First : merge both LL
		Node head = mergeTwoLL(first, second);

		// Second : Divide LL recursively by half
		return divideLL(head);
	}

	public static void main(String[] args) {

		LL_24_UnionOf2LL_MergeSort_Imp lList = new LL_24_UnionOf2LL_MergeSort_Imp();
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
