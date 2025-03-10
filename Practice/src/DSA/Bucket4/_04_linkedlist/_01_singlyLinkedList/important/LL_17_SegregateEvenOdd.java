package DSA.Bucket4._04_linkedlist._01_singlyLinkedList.important;

public class LL_17_SegregateEvenOdd {

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

	public void printList() {
		Node n = head;
		while (n != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
		System.out.println();
	}

	public void segregateNodes() {
		Node n = head;
		Node evenHead = null, oddHead = null, evenPrev = null, oddPrev = null;

		while (n != null) {

			if (n.data % 2 == 0) {

				if (evenHead == null)
					evenHead = n;

				else
					evenPrev.next = n;

				evenPrev = n;

			} else {

				if (oddHead == null)
					oddHead = n;

				else
					oddPrev.next = n;

				oddPrev = n;

			}

			n = n.next;
		}

		if (evenPrev != null)
			evenPrev.next = oddHead;

		if (oddPrev != null)
			oddPrev.next = null;

		if (evenHead != null)
			head = evenHead;
		else
			head = oddHead;

		printList();
	}

	public static void main(String[] args) {
		LL_17_SegregateEvenOdd lList = new LL_17_SegregateEvenOdd();
		lList.push(6);
		lList.push(5);
		lList.push(4);
		lList.push(3);
		lList.push(2);
		lList.push(1);

		lList.printList();

		lList.segregateNodes();
	}

}
