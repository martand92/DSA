package DSA.Bucket3._04_linkedlist._01_singlyLinkedList.easy;

import java.util.HashMap;
import java.util.Map;

//https://practice.geeksforgeeks.org/problems/find-length-of-loop/1
public class LL_11_DetectIfLLHasInsideLoop_O_N {

	Node head;

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

	public static void main(String[] args) {

		LL_11_DetectIfLLHasInsideLoop_O_N lList = new LL_11_DetectIfLLHasInsideLoop_O_N();
		lList.push(1);
		lList.push(2);
		lList.push(3);
		lList.push(4);
		lList.push(5);

		Node n = lList.head;
		HashMap<Integer, Node> hm = new HashMap<Integer, Node>();
		int i = 1;

		while (n != null) {

			if (hm.containsValue(n)) {

				int key = 0;

				for (Map.Entry<Integer, Node> e : hm.entrySet()) {

					if (e.getValue() == n) {
						key = e.getKey();
						break;
					}
				}

				System.out.println(hm.size() - key + 1);
				break;
			}

			hm.put(i++, n);
			n = n.next;

		}

	}
}
