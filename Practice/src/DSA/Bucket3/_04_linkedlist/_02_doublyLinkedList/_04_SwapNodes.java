package DSA.Bucket3._04_linkedlist._02_doublyLinkedList;

public class _04_SwapNodes {

	Node head;
	Node firstNode;
	Node secondNode;

	static class Node {
		int data;
		Node prev;
		Node next;

		Node(int d) {
			data = d;
			prev = null;
			next = null;
		}
	}

	public void printlist() {
		Node n = head;
		while (n != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}

		System.out.println();
	}

	public void push(int data) {
		Node newNode = new Node(data);

		if (head != null)
			head.prev = newNode;

		newNode.next = head;
		head = newNode;
	}

	public void swapNodes(int nodeFromBeginning, int nodeFromEnd) {

		Node n = head;

		while (n.next != null)
			n = n.next;

		Node tail = n;
		Node begin = head;

		while (nodeFromBeginning > 1) {
			begin = begin.next;
			nodeFromBeginning--;
		}

		while (nodeFromEnd > 1) {
			tail = tail.prev;
			nodeFromEnd--;
		}

		Node beginPrev = begin.prev;
		Node beginNext = begin.next;
		Node tailPrev = tail.prev;
		Node tailNext = tail.next;

		tail.prev = beginPrev;
		if (beginPrev == null)
			head = tail;
		else
			beginPrev.next = tail;

		tail.next = beginNext;

		if (beginNext != null)
			beginNext.prev = tail;

		begin.prev = tailPrev;
		if (tailPrev != null)
			tailPrev.next = begin;

		begin.next = tailNext;
		if (tailNext != null)
			tailNext.prev = begin;

	}

	public static void main(String[] args) {

		_04_SwapNodes lList = new _04_SwapNodes();

		lList.push(5);
		lList.push(4);
		lList.push(3);
		lList.push(2);
		lList.push(1);

		lList.printlist();

		// Swap 2nd Node from beginning with 2nd node from end
		lList.swapNodes(2, 2);
		lList.printlist();
	}

}
