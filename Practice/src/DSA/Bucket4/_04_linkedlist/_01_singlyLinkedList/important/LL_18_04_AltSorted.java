package DSA.Bucket4._04_linkedlist._01_singlyLinkedList.important;

//https://practice.geeksforgeeks.org/problems/linked-list-that-is-sorted-alternatingly/1
public class LL_18_04_AltSorted {

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

		Node next = null, n = head, prev = null;

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

	// here two new linked lists are created, but they are created by rearranging
	// the existing nodes from the original linked list. No new Node objects are
	// created

	// This is same as we saw in mergeSort() where new sortedList is created to
	// which existing nodes from existing ll are appended in sorted order

	public void altSort() {
		//creation of 2 dummy linkedlist  firstHead & secondHead
		Node firstHead = null, firstPtr = null;
		Node secondHead = null, secondPtr = null;
		int i = 1;

		Node n = head;

		// Create 2 different LLs with alternate nodes

		// As we traverse the original linked list, we are essentially taking the
		// existing nodes and placing them into two separate linked lists
		while (n != null) {

			if (i % 2 != 0) {

				if (firstHead == null)
					firstHead = n;
				else
					firstPtr.next = n;

				firstPtr = n;

			} else {

				if (secondHead == null)
					secondHead = n;
				else
					secondPtr.next = n;

				secondPtr = n;
			}
			i++;
			n = n.next;
		}

		// nullify second linkedlist tail as it would contain last element
		secondPtr.next = null;

		// reverse second ll as its sorted in desc and need to have it in asc
		secondHead = reverseLL(secondHead);
		firstPtr.next = secondHead;
		head = firstHead;
	}

	public static void main(String[] args) {

		LL_18_04_AltSorted lList = new LL_18_04_AltSorted();

		lList.push(50);
		lList.push(80);
		lList.push(21);
		lList.push(99);
		lList.push(13);

		lList.printList();
		lList.altSort();
		lList.printList();

	}
}