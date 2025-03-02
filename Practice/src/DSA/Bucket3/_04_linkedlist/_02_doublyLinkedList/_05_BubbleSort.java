package DSA.Bucket3._04_linkedlist._02_doublyLinkedList;

public class _05_BubbleSort {

	Node head;
	int temp;
	int length = 0;

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
			length++;
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

	public void bubbleSort() {

		for (int i = 0; i < length; i++) {
			Node n = head;
			while (n != null) {
				if (n.prev != null) {
					if (n.prev.data > n.data) {
						temp = n.prev.data;
						n.prev.data = n.data;
						n.data = temp;
					}

				}
				n = n.next;
			}
		}

	}

	public static void main(String[] args) {
		_05_BubbleSort lList = new _05_BubbleSort();
		lList.push(4);
		lList.push(2);
		lList.push(3);
		lList.push(5);
		lList.push(1);
		lList.printlist();
		lList.bubbleSort();
		lList.printlist();
	}

}
