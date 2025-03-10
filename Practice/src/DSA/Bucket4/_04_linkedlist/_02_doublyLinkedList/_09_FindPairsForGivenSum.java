package DSA.Bucket4._04_linkedlist._02_doublyLinkedList;

import java.util.*;

public class _09_FindPairsForGivenSum {
	Node head;

	ArrayList<ArrayList<Integer>> finalAl = new ArrayList<ArrayList<Integer>>();
	// HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
	HashSet<Integer> hs = new HashSet<Integer>();

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

	public void findPairs(int sum) {
		Node n = head;

		while (n != null) {

			// As input doesn't contain duplicates, have used hashset else would use hashmap
			if (hs.contains(sum - n.data)) {
				// if (hm.containsKey(sum - n.data)) { // needed if input has duplicates
				ArrayList<Integer> al = new ArrayList<Integer>();
				al.add(sum - n.data);
				al.add(n.data);
				finalAl.add(0,al);

			} else
				hs.add(n.data);
			// hm.put(n.data, 1);

			n = n.next;

		}

	}

	public static void main(String[] args) {
		_09_FindPairsForGivenSum lList = new _09_FindPairsForGivenSum();
		lList.push(9);
		lList.push(8);
		lList.push(6);
		lList.push(5);
		lList.push(4);
		lList.push(2);
		lList.push(1);

		lList.printlist();

		lList.findPairs(7);

		System.out.println(lList.finalAl);
	}
}
