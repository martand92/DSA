package DSA.Bucket3._03_linkedlist._02_doublyLinkedList;

public class _02_DeleteNode {

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
		System.out.println();
	}

	public void push(int data) {
		Node newNode = new Node(data);

		if (head != null)
			head.prev = newNode;

		newNode.next = head;
		head = newNode;

	}

	public void deleteAtStart() {
		System.out.println("Deleting at start");
		head.next.prev = null;
		head = head.next;
	}

	public void deleteAtEnd() {
		System.out.println("Deleting at end");
		
		Node n = head;
		
		while(n.next != null)
			n = n.next;
		
		
		n.prev.next = null;
	}

	public void deleteNode(int d) {
		System.out.println("Deleting node");
		Node n = head;

		while (n.data != d) {
			n = n.next;
		}
		n.prev.next = n.next;
		n.next.prev = n.prev;
	}

	public static void main(String[] args) {
		_02_DeleteNode lList = new _02_DeleteNode();
		lList.push(5);
		lList.push(4);
		lList.push(3);
		lList.push(2);
		lList.push(1);
		lList.deleteAtStart();
		lList.printlist();
		lList.deleteAtEnd();
		lList.printlist();
		lList.deleteNode(3);
		lList.printlist();
	}
}
