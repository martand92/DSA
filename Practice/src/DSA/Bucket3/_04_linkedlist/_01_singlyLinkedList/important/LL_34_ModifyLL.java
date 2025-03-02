package DSA.Bucket3._04_linkedlist._01_singlyLinkedList.important;

import java.util.*;

//https://practice.geeksforgeeks.org/problems/modify-linked-list-1/1
public class LL_34_ModifyLL {

	static Node head;

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

	public void printList(Node head) {
		Node n = head;
		while (n != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
	}

	public void modify() {

		Node n = head;

		ArrayList<Integer> al = new ArrayList<Integer>();
		ArrayList<Integer> al1 = new ArrayList<Integer>();

		while (n != null) {
			al.add(n.data);
			n = n.next;
		}

		int size = al.size();

		for (int i = 0; i < size / 2; i++)
			al1.add(al.get(i) - al.get(size - 1 - i));

		for (int i = size / 2; i < size; i++)
			al1.add(al.get(i));

		head = null;
		Node current = null;
		for (int i = 0; i < al1.size(); i++) {
			Node newNode = new Node(al1.get(i));
			if (head == null)
				head = newNode;
			else
				current.next = newNode;

			current = newNode;
		}

	}

	public static void main(String[] args) {

		LL_34_ModifyLL lList = new LL_34_ModifyLL();

		lList.push(10);
		lList.push(4);
		lList.push(5);
		lList.push(3);
		lList.push(6);

		lList.modify();

		lList.printList(head);
	}

}
