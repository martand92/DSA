package DSA.Bucket4._04_linkedlist._01_singlyLinkedList.important;

public class LL_16_2_SwapNodePairWise {

	Node head;

	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	public void push(int d) {
		Node newNode = new Node(d);
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

	public static void main(String[] args) {

		LL_16_2_SwapNodePairWise lList = new LL_16_2_SwapNodePairWise();
		lList.push(6);
		lList.push(5);
		lList.push(4);
		lList.push(3);
		lList.push(2);
		lList.push(1);

		lList.printList();

		lList.swapNodesPairWise();
	}

	void swapNodesPairWise() {

		Node n = head;
		int i = 1;
		Node prev = null;
		

		Node prevSwappedNode = null; // to hold previously swapped node (1, 3, etc as
		// for next iteration after
		// swapping 1 should point to 4

		while (n != null) {

			// every second node should be swapped with previous node
			if (i % 2 == 0) {

				if (i == 2)
					head = n;

				prev.next = n.next;
				n.next = prev;

				if (prevSwappedNode != null)
					prevSwappedNode.next = n; // 1-> 4 etc..
				
				n = prev;
				prevSwappedNode = prev; // Storing 1, 3, 5 etc..

			} else
				prev = n;

			n = n.next;
			i++;

		}


		printList();

	}

}
