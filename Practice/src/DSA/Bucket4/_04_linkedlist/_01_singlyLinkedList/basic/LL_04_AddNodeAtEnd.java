package DSA.Bucket4._04_linkedlist._01_singlyLinkedList.basic;

public class LL_04_AddNodeAtEnd {

	Node head;

	public static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	public void push(int d) {
		Node newNode = new Node(d);

		if (head == null)
			head = newNode;
		else {
			Node n = head;
			while (n.next != null) // Costly
				n = n.next;
			n.next = newNode;
		}
	}

	public void printList() {
		Node n = head;

		while (n != null) {
			System.out.println(n.data);
			n = n.next;
		}
	}

	public static void main(String[] args) {
		LL_04_AddNodeAtEnd lList = new LL_04_AddNodeAtEnd();
		lList.push(1);
		lList.push(2);
		lList.push(3);
		lList.push(4);
		lList.push(5);
		lList.printList();
	}
}
