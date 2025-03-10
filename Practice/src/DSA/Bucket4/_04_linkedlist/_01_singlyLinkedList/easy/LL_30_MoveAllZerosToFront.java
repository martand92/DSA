package DSA.Bucket4._04_linkedlist._01_singlyLinkedList.easy;

//https://practice.geeksforgeeks.org/problems/move-all-zeros-to-the-front-of-the-linked-list/1
public class LL_30_MoveAllZerosToFront {

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

	public void printList() {
		Node n = head;
		while (n != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
		System.out.println();
	}

	public void moveAllZerosToFront() {

		Node n = head;
		Node prev = null;

		while (n != null) {

			// basically push all zeros to head
			if (n.data == 0 && prev != null) {
				prev.next = n.next;
				n.next = head;
				head = n;
				n = prev; // make prev as n when u have n.data = 0
			}

			prev = n;
			n = n.next;
		}

	}

	public static void main(String[] args) {

		LL_30_MoveAllZerosToFront lList = new LL_30_MoveAllZerosToFront();

		lList.push(0);
		lList.push(5);
		lList.push(0);
		lList.push(4);
		lList.push(0);

		lList.printList();

		lList.moveAllZerosToFront(); // 0->0->0->4->5

		lList.printList();
	}

}
