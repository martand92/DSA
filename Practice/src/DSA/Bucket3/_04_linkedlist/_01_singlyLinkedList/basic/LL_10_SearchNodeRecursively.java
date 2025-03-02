package DSA.Bucket3._04_linkedlist._01_singlyLinkedList.basic;

public class LL_10_SearchNodeRecursively {
	Node head;

	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	public static void main(String[] args) {
		LL_10_SearchNodeRecursively lList = new LL_10_SearchNodeRecursively();
		lList.head = new Node(1);
		Node second = new Node(2);
		lList.head.next = second;
		Node third = new Node(3);
		second.next = third;
		Node fourth = new Node(4);
		third.next = fourth;
		Node fifth = new Node(5);
		fourth.next = fifth;

		int pos = lList.search(3, lList.head, 1);
		System.out.println("Position : " + pos);
	}

	public int search(int data, Node n, int pos) {

		if (n.data == data)
			return pos;

		return search(data, n.next, pos + 1);
	}

}
