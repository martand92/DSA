package DSA.Bucket3._03_linkedlist._01_singlyLinkedList.basic;

public class LL_08_DeleteNodeAtGivenPosition {
	Node head;
	int count = 0;

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

		System.out.println(count);
	}

	public static void main(String[] args) {
		LL_08_DeleteNodeAtGivenPosition lList = new LL_08_DeleteNodeAtGivenPosition();
		lList.push(1);
		lList.push(2);
		lList.push(3);
		lList.push(4);
		lList.push(5);
		
		lList.deleteNodeAtPos(1);
	}

	void deleteNodeAtPos(int pos) {
		System.out.print("Deleting node : ");

		Node n = head;
		Node prev = head;
		int i = 1;

		while (i != pos) {
			prev = n;
			n = n.next;
			i++;
		}
		if (pos == 1)
			head = n.next;
		else
			prev.next = n.next;

		printList();

	}
}
