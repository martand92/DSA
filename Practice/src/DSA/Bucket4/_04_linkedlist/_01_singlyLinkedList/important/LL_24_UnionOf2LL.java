package DSA.Bucket4._04_linkedlist._01_singlyLinkedList.important;

import java.util.*;

//https://practice.geeksforgeeks.org/problems/union-of-two-linked-list/1
public class LL_24_UnionOf2LL {
	Node head1;
	Node head2;

	public static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	public void push1(int d) {
		Node newNode = new Node(d);
		newNode.next = head1;
		head1 = newNode;
	}

	public void push2(int d) {
		Node newNode = new Node(d);
		newNode.next = head2;
		head2 = newNode;
	}

	public static void printList(Node head) {
		Node n = head;

		while (n != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
	}

	public void unionOfLL(Node first, Node second) {

		TreeSet<Integer> ts = new TreeSet<Integer>();

		Node n = head1;
		while (n != null) {
			ts.add(n.data);
			n = n.next;
		}

		n = head2;
		while (n != null) {
			ts.add(n.data);
			n = n.next;
		}

		Node head = null;
		Node prev = null;

		for (int i : ts) {
			Node newNode = new Node(i);
			if (head == null)
				head = newNode;
			else
				prev.next = newNode;

			prev = newNode;
		}

		printList(head);

	}

	public static void main(String[] args) {

		LL_24_UnionOf2LL lList = new LL_24_UnionOf2LL();
		lList.push1(6);
		lList.push1(4);
		lList.push1(3);
		lList.push1(2);
		lList.push1(1);

		lList.push2(8);
		lList.push2(6);
		lList.push2(4);
		lList.push2(2);

		lList.unionOfLL(lList.head1, lList.head2);

	}
}
