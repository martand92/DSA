package DSA.Bucket3._03_linkedlist._02_doublyLinkedList;

import java.util.HashSet;

public class _08_RemoveDuplicatesFromUnSortedLL {

	Node head;

	static class Node {
		int data;
		Node next;
		Node prev;

		Node(int d) {
			data = d;
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

	public void removeDup() {
		HashSet<Integer> hs = new HashSet<Integer>();
		Node n = head;
		while (n != null) {

			if (!hs.add(n.data)) {
				n.prev.next = n.next;

				if (n.next != null)
					n.next.prev = n.prev;

			}
			n = n.next;
		}
	}

	public static void main(String[] args) {
		_08_RemoveDuplicatesFromUnSortedLL lList = new _08_RemoveDuplicatesFromUnSortedLL();
		lList.push(5);
		lList.push(5);
		lList.push(3);
		lList.push(2);
		lList.push(1);
		lList.push(1);
		lList.printlist();
		lList.removeDup();
		lList.printlist();
	}

}
