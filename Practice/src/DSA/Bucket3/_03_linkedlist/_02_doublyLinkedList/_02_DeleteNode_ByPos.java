package DSA.Bucket3._03_linkedlist._02_doublyLinkedList;

public class _02_DeleteNode_ByPos {

	Node head;

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
	}

	public void push(int data) {
		Node newNode = new Node(data);

		if (head != null)
			head.prev = newNode;

		newNode.next = head;
		head = newNode;

	}

	public void deleteNodeAtPos(int pos) {
		System.out.println();
		System.out.print("Deleting node : ");
		int count = 1;
		Node n = head;
		Node prev = null;

		while (count != pos && n != null) {
			count++;
			prev = n;
			n = n.next;
		}

		if (n.prev != null)
			n.prev.next = n.next;
		else
			head = n.next;

		if (n.next != null)
			n.next.prev = prev;

		printlist();
	}

	public static void main(String[] args) {
		_02_DeleteNode_ByPos lList = new _02_DeleteNode_ByPos();
		lList.push(5);
		lList.push(4);
		lList.push(3);
		lList.push(2);
		lList.push(1);

		lList.printlist();

		lList.deleteNodeAtPos(3);
	}
}
