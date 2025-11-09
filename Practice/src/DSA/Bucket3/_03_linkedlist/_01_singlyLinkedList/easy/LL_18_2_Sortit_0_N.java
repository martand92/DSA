package DSA.Bucket3._03_linkedlist._01_singlyLinkedList.easy;

import java.util.Arrays;

public class LL_18_2_Sortit_0_N {

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

	public void printList(Node n) {
		while (n != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
	}

	public void sort() {

		Node n = head;
		int count = 0;
		int i = 0;

		while (n != null) {
			count++;
			n = n.next;
		}

		int[] arr = new int[count];

		n = head;
		while (n != null) {
			arr[i] = n.data;
			n = n.next;
			i++;
		}
		Arrays.sort(arr);

		i = 0;
		head = null;

		while (i < arr.length) {
			Node newNode = new Node(arr[arr.length - 1 - i]);
			newNode.next = head;
			head = newNode;
			i++;
		}
		
		System.out.println();

		printList(head);
	}

	public static void main(String[] args) {

		LL_18_2_Sortit_0_N lList = new LL_18_2_Sortit_0_N();
		lList.push(5);
		lList.push(5);
		lList.push(1);
		lList.push(1);
		lList.push(3);
		lList.push(2);

		lList.printList(lList.head);

		lList.sort();

	}

}
