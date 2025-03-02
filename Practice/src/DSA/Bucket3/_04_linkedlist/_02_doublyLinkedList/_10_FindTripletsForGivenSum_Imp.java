package DSA.Bucket3._04_linkedlist._02_doublyLinkedList;

import java.util.*;

public class _10_FindTripletsForGivenSum_Imp {

	Node head;
	ArrayList<String> al = new ArrayList<String>();

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

	public void findTriplets(int sum) {

		Node n = head;
		Node firstNext;
		Node secondNext;

		while (n != null) {
			firstNext = n.next;

			while (firstNext != null) {
				secondNext = firstNext.next;

				while (secondNext != null) {
					if (n.data + firstNext.data + secondNext.data == sum)
						al.add("(" + n.data + "," + firstNext.data + "," + secondNext.data + ")");

					secondNext = secondNext.next;
				}
				firstNext = firstNext.next;
				if (firstNext != null)
					secondNext = firstNext.next;

			}
			n = n.next;

		}

	}

	public static void main(String[] args) {
		_10_FindTripletsForGivenSum_Imp lList = new _10_FindTripletsForGivenSum_Imp();
//		lList.push(-2);
//		lList.push(-1);
//		lList.push(5);
//		lList.push(4);
//		lList.push(3);
//		lList.push(2);
//		lList.push(1);
//		lList.push(5);
//		lList.push(4);
//		lList.push(3);
//		lList.push(2);
//		lList.push(1);

		lList.push(2);
		lList.push(1);
		lList.push(3);

		lList.printlist();
		lList.findTriplets(6);
		System.out.println(lList.al);
	}

}
