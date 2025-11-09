package DSA.Bucket3._03_linkedlist._01_singlyLinkedList.easy;

import java.util.HashMap;

//https://practice.geeksforgeeks.org/problems/find-length-of-loop/1
public class LL_11_FindLengthOfLoop {

	static Node head;

	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	public void push(int n) {
		Node newNode = new Node(n);
		newNode.next = head;
		head = newNode;
	}

	public static void makeLoop() {
		Node n = head;

		while (n.next != null)
			n = n.next;

		n.next = head.next;
	}

	public static int findLengthOfLoop() {

		Node n = head;
		int index = 1;
		HashMap<Node, Integer> hm = new HashMap<Node, Integer>();

		while (n != null) {

			if (hm.containsKey(n.next))
				return index - hm.get(n.next) + 1;

			hm.put(n, index);
			index++;
			n = n.next;
		}

		return -1;
	}

	public static void main(String[] args) {

		LL_11_FindLengthOfLoop lList = new LL_11_FindLengthOfLoop();
		lList.push(5);
		lList.push(4);
		lList.push(3);
		lList.push(2);
		lList.push(1);

		//makeLoop();
		System.out.println("Has loop length of : " + findLengthOfLoop());

	}
}
