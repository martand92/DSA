package DSA.Bucket3._04_linkedlist._01_singlyLinkedList;

//https://practice.geeksforgeeks.org/problems/linked-list-that-is-sorted-alternatingly/1

//1) Since list is in alternate ascending and descending order so separate them into two lists using odd even LL logic.
//2) Now we have two sorted lists but 2nd list is in descending order so -> Reverse the 2nd list.
//3) Merge both the lists using Merge sort logic.
public class LL_18_AlternatelySorted_O_1_Space_Incomp {

	Node head;

	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	public void push(int data) {
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
	}

	public Node reverseLL(Node head) {

		Node next = null;
		Node n = head;
		Node prev = null;

		while (n != null) {
			next = n.next;
			n.next = prev;
			prev = n;
			n = next;
		}

		head = prev;

		return head;

	}

	public void printList() {
		Node n = head;
		while (n != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}

		System.out.println();
	}

	public void sort() {
		Node n = head;
		Node asc = null;
		Node ascHead = null;
		Node desc = null;
		Node descHead = null;
		boolean odd = true;

		while (n != null) {

			if (odd) {
				if (asc == null)
					ascHead = n;

				else
					asc.next = n;

				asc = n;

			} else {

				if (desc == null)
					descHead = n;

				else
					desc.next = n;

				desc = n;

			}

			odd = !odd;

			n = n.next;

		}

		asc.next = null;
		desc.next = null;

		// reverse desc list to make it ascending order as its in descending order
		descHead = reverseLL(descHead);

		// Merge above asc and desc LL -- pending
		asc = ascHead;
		desc = descHead;
	}

	public static void main(String[] args) {

		LL_18_AlternatelySorted_O_1_Space_Incomp lList = new LL_18_AlternatelySorted_O_1_Space_Incomp();
//		lList.push(7);
//		lList.push(3);
//		lList.push(8);
//		lList.push(2);
//		lList.push(9);
//		lList.push(1);

		lList.push(2);
		lList.push(10);
		lList.push(4);
		lList.push(5);
		lList.push(7);
		lList.push(1);

		lList.printList();

		lList.sort();

		lList.printList();

	}

}
