package DSA.Bucket3._03_linkedlist._01_singlyLinkedList.important;

public class _08_01_MergeSortedLL_NotInPlace {

	Node head1;
	Node head2;

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	private void printList(Node n) {

		while (n != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
	}

	public Node mergeLL() {

		if (head1 == null)
			return head2;
		if (head2 == null)
			return head1;

		// Initialize the merged list's head
		Node mergedHead = null;

		// add head to merged list
		if (head1.data < head2.data) {
			mergedHead = head1;
			head1 = head1.next;
		} else {
			mergedHead = head2;
			head2 = head2.next;
		}

		Node current = mergedHead;

		while (head1 != null && head2 != null) {
			if (head1.data < head2.data) {
				current.next = head1;
				head1 = head1.next;
			} else {
				current.next = head2;
				head2 = head2.next;
			}

			current = current.next;
		}

		// Attach the remaining part of the list if any
		if (head1 != null)
			current.next = head1;
		else
			current.next = head2;

		return mergedHead;

	}

	public void addNode(int index, int data) {

		Node newNode = new Node(data);

		if (index == 1) {
			newNode.next = head1;
			head1 = newNode;
		} else {
			newNode.next = head2;
			head2 = newNode;
		}
	}

	public static void main(String[] args) {

		_08_01_MergeSortedLL_NotInPlace ll = new _08_01_MergeSortedLL_NotInPlace();

		ll.addNode(1, 9);
		ll.addNode(1, 7);
		ll.addNode(1, 5);
		ll.addNode(2, 13);
		ll.addNode(2, 12);
		ll.addNode(2, 11);
		ll.addNode(2, 10);
		ll.addNode(2, 8);
		ll.addNode(2, 4);
		ll.addNode(2, 3);

		Node n = ll.mergeLL();
		ll.printList(n);

	}
}
