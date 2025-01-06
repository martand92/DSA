package DSA._04_linkedlist._01_singlyLinkedList.easy;

//https://www.geeksforgeeks.org/problems/remove-duplicate-element-from-sorted-linked-list/1
public class LL_12_RemoveDupfromSortedLL_O_1 { // Without HashSet
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

	public void printList(Node head) {
		Node n = head;

		while (n != null) {
			System.out.println(n.data);
			n = n.next;
		}
	}

	public static void main(String[] args) {

		LL_12_RemoveDupfromSortedLL_O_1 lList = new LL_12_RemoveDupfromSortedLL_O_1();

		lList.push(1);
		lList.push(2);
		lList.push(2);
		lList.push(3);
		lList.push(4);

		Node n = lList.head;
		Node prev = n;

		while (n != null) {

			if (prev.data != n.data) {
				prev.next = n;
				prev = n;
			}

			n = n.next;
		}

		lList.printList(lList.head);

	}

}
