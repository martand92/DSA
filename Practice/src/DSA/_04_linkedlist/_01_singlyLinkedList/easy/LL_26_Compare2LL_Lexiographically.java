package DSA._04_linkedlist._01_singlyLinkedList.easy;

//https://practice.geeksforgeeks.org/problems/compare-two-linked-lists/1
public class LL_26_Compare2LL_Lexiographically {

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

	public int compareTwoLL_Lexi(Node l1, Node l2) {

		while (l1 != null && l2 != null) {

			if (l1.data > l2.data) {
				return 1;

			} else if (l1.data < l2.data) {
				return -1;

			} else {
				l1 = l1.next;
				l2 = l2.next;
			}
		}

		return 0;
	}

	public static void main(String[] args) {

		LL_26_Compare2LL_Lexiographically lList = new LL_26_Compare2LL_Lexiographically();
		lList.push1('a');
		lList.push1('b');
		lList.push1('a');
		lList.push1('b');
		lList.push1('a');

		lList.push2('a');
		lList.push2('a');
		lList.push2('b');
		lList.push2('a');

		System.out.println(lList.compareTwoLL_Lexi(lList.head1, lList.head2));

	}

}
