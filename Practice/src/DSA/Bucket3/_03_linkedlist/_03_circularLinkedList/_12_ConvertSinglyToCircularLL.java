package DSA.Bucket3._03_linkedlist._03_circularLinkedList;

public class _12_ConvertSinglyToCircularLL {

	Node head;
	Node tailNode;

	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}

	}

	public void push(int data) {
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
	}

	public void printList() {
		Node n = head;

		do {

			if (n != null) {
				System.out.println(n.data);
				n = n.next;
			} else
				break;

		} while (n != head);
	}

	public void convertToCircularLL() {
		Node n = head;
		
		while (n.next != null)
			n = n.next;

		n.next = head;
	}

	public static void main(String[] args) {
		_12_ConvertSinglyToCircularLL lList = new _12_ConvertSinglyToCircularLL();
		lList.push(5);
		lList.push(4);
		lList.push(3);
		lList.push(2);
		lList.push(1);

		lList.printList();

		lList.convertToCircularLL();
		lList.printList();
	}

}
