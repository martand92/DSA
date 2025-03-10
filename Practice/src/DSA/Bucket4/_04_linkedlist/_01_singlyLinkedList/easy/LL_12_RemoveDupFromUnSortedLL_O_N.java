package DSA.Bucket4._04_linkedlist._01_singlyLinkedList.easy;

import java.util.HashSet;

//https://www.geeksforgeeks.org/problems/remove-duplicates-from-an-unsorted-linked-list/1
public class LL_12_RemoveDupFromUnSortedLL_O_N {
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

	public static void main(String[] args) {

		LL_12_RemoveDupFromUnSortedLL_O_N lList = new LL_12_RemoveDupFromUnSortedLL_O_N();

		lList.push(1);
		lList.push(2);
		lList.push(3);
		lList.push(4);
		lList.push(4);

		HashSet<Integer> hs = new HashSet<Integer>();

		Node n = lList.head;
		Node prev = null;

		while (n != null) {

			if (!hs.contains(n.data)) {
				hs.add(n.data);
				if (prev != null)
					prev.next = n;

				prev = n;
			}

			n = n.next;
		}

		Node k = lList.head;
		while (k != null) {
			System.out.println(k.data);
			k = k.next;
		}

	}

}
