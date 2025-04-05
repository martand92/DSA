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
		Node prev = null;

		while (n != null) {

			Node temp = n.next;
			n.next = n.next.next;
			temp.next = n;

			if (n == head)
				head = temp;

			if (prev != null)
				prev.next = temp;

			prev = n;
			n = n.next;
		}

	}

}
