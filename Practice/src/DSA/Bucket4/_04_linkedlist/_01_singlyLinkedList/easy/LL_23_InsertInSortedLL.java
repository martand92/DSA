package DSA.Bucket4._04_linkedlist._01_singlyLinkedList.easy;

public class LL_23_InsertInSortedLL {

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

	public void print() {
		Node n = head;

		while (n != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
		System.out.println();
	}

	public void sortedInsert(int key) {
		Node n = head;
		Node prev = null;

		Node newNode = new Node(key);

		while (n != null) {
			if (key < n.data) {

				if (prev == null)
					head = newNode;
				else
					prev.next = newNode;

				newNode.next = n;
				break;
			} else if (n.next == null) {
				n.next = newNode;
				break;
			}

			prev = n;
			n = n.next;
		}

	}

	public static void main(String[] args) {

		LL_23_InsertInSortedLL lList = new LL_23_InsertInSortedLL();

		int key = 2;

		lList.push(5);
		lList.push(4);
		lList.push(3);
		lList.push(1);

		lList.print();

		lList.sortedInsert(key);

		lList.print();

	}

}
