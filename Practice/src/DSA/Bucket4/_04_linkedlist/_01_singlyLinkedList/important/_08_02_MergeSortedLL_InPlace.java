package DSA.Bucket4._04_linkedlist._01_singlyLinkedList.important;

public class _08_02_MergeSortedLL_InPlace {

	Node head1;
	Node head2;
	Node head3;

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

		Node n1 = head1;
		Node n2 = head2;
		Node prev1 = null, prev2 = null;

		while (n1 != null && n2 != null) {

			if (n1.data < n2.data) {

				while (n1 != null && (n1.data < n2.data)) {
					prev1 = n1;
					n1 = n1.next;
				}

				prev1.next = n2;

			} else {

				while (n2 != null && (n2.data < n1.data)) {
					prev2 = n2;
					n2 = n2.next;
				}

				prev2.next = n1;

			}
		}

		return head1.data < head2.data ? head1 : head2;

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

		_08_02_MergeSortedLL_InPlace ll = new _08_02_MergeSortedLL_InPlace();

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
